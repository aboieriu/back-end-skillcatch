package dao.impl;


import dao.api.IUserDao;
import model.Badge;
import model.Project;
import model.Task;
import model.User;
import org.hibernate.procedure.UnknownSqlResultSetMappingException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.soap.SOAPBinding;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class UserDao extends GenericDao<User> implements IUserDao,Serializable{

    public UserDao() {
        super(User.class);
    }


    @Transactional
    public void deleteUserById(Long userId) {
        User itemFromDbs = this.getById(userId);
        if (itemFromDbs != null) {
            if (itemFromDbs.getProjects() != null) {
                if (itemFromDbs.getTaskPlans() != null) {
                    itemFromDbs.getProjects().stream().forEach(project -> {
                        itemFromDbs.getTaskPlans().stream().forEach(taskPlan -> {
                            taskPlan.getTasks().stream().forEach(task -> {
                                task.getBadges().stream().forEach(badge -> {
                                    entityManager.remove(badge);
                                });
                                entityManager.remove(task);
                            });

                            entityManager.remove(taskPlan);
                        });
                        entityManager.remove(project);
                    });


                    itemFromDbs.setTaskPlans(new HashSet<>());
                    itemFromDbs.setTaskPlans(new HashSet<>());
                    itemFromDbs.setUserRole(new HashSet<>());
                    itemFromDbs.setProjects(new HashSet<>());
                    entityManager.persist(itemFromDbs);
                    entityManager.remove(itemFromDbs);
                    entityManager.flush();
                    entityManager.clear();
                }
            }
        }
    }
    @Transactional
    public void updateUser(User myUser){
        User itemFromDbs = this.getById(myUser.getId());
        if (itemFromDbs != null) {
            if(!Objects.equals(myUser.getName(), "") && myUser.getName() !=null){
                itemFromDbs.setName(myUser.getName());
            }
            if(!Objects.equals(myUser.getSurname(), "") && myUser.getSurname() !=null){
                itemFromDbs.setSurname(myUser.getSurname());
            }
            if(!Objects.equals(myUser.getUsername(), "") && myUser.getUsername() !=null){
                itemFromDbs.setUsername(myUser.getUsername());
            }

            if(!Objects.equals(myUser.getPassword(), "") && myUser.getPassword() !=null){
                String password=  myUser.getPassword();
                PasswordEncoder passEncoded = new BCryptPasswordEncoder();

                itemFromDbs.setPassword(passEncoded.encode(password));
            }
            if(!Objects.equals(myUser.getEmail(), "") && myUser.getEmail() !=null){
                itemFromDbs.setEmail(myUser.getEmail());
            }
            if(!Objects.equals(myUser.getPhone(), "") && myUser.getPhone() !=null){
                itemFromDbs.setPhone(myUser.getPhone());
            }

            if(!Objects.equals(myUser.getImage(), "") && myUser.getImage() != null){
                itemFromDbs.setImage(myUser.getImage());
            }
            entityManager.merge(itemFromDbs);
            entityManager.flush();
        }
    }

    public User findByUserName(String username){

        if(username!=null) {
            Query query = this.entityManager.createQuery("from User WHERE username=:username",User.class);
            query.setParameter("username", username);

            List<User> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }
        return null;
    }


    public Set<Badge> getUserBadges(Long userId) {

        if (userId != null) {
            Query query = this.entityManager.createQuery("select b from Badge as b join b.userBadges as ub where ub.id=:userId");
            query.setParameter("userId", userId);
            List<Badge> result = query.getResultList();
            if(!result.isEmpty()){

                return new HashSet<Badge>(result);

            }

            throw new EmptyResultDataAccessException("No result for this id!", 1);

        }
        throw  new UnknownSqlResultSetMappingException("Not found");
    }
    @Transactional
    @Override
    public void assignUserToProject(User userFromDbs) {
       userFromDbs.setProjects(userFromDbs.getProjects());
        userFromDbs.getTaskPlans().stream().forEach(taskPlan -> {
            taskPlan.getBadges().stream().forEach(badge -> {
               taskPlan.getBadges().add(badge);
                entityManager.merge(badge);
            });
            userFromDbs.getTaskPlans().add(taskPlan);
            entityManager.merge(taskPlan);
        });
        userFromDbs.setTaskPlans(userFromDbs.getTaskPlans());
            entityManager.merge(userFromDbs);
            entityManager.flush();
            entityManager.clear();


    }

    @Override
    public List<User> getProjectUnAssignedUsers(Long projectId) {
        Query query=this.entityManager.createQuery("SELECT users FROM User users, Project projects JOIN projects.users AS projectUsers WHERE users.id NOT IN(SELECT users.id FROM User users, Project projects JOIN projects.users AS projectUser WHERE users.id=projectUser.id AND  projects.id=:targetProjectId) GROUP BY users.id");
        query.setParameter("targetProjectId",projectId);
        List<User> result=query.getResultList();
        if(!result.isEmpty()){
            return result;
        }
        return null;
    }


}