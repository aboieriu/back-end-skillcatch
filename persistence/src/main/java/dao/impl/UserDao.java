package dao.impl;


import dao.api.IUserDao;
import model.Badge;
import model.Project;
import model.Task;
import model.User;
import org.hibernate.procedure.UnknownSqlResultSetMappingException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDao extends GenericDao<User> implements IUserDao,Serializable{

    public UserDao() {
        super(User.class);
    }

    public User getUser(Long groupId,Long userId) {
        if(groupId !=null || userId != null)
        {
            Query query = this.entityManager.createQuery("select u from User as u, Project as pg join pg.users where pg.id = :targetgroupId AND u.id = :targetuserId ");
            query.setParameter("targetgroupId" , groupId);
            query.setParameter("targetuserId" , userId);
            List<User> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

    @Override
    @Transactional
    public void deleteById(Long userId) {
        User itemFromDbs = this.getById(userId);
        if (itemFromDbs != null) {
            if (itemFromDbs.getTaskPlans() != null) {
                itemFromDbs.getTaskPlans().stream().forEach(taskPlan -> {
                    taskPlan.getTasks().stream().forEach(task -> {
                        task.getBadges().stream().forEach(badge -> {
                            entityManager.remove(badge);
                        });
                        entityManager.remove(task);
                    });
                    taskPlan.getBadges().stream().forEach(badge -> {
                        entityManager.remove(badge);
                    });
                    entityManager.remove(taskPlan);
                });
            }

            itemFromDbs.setTaskPlans(new HashSet<>());
            itemFromDbs.setUserRole(new HashSet<>());
            itemFromDbs.setProjects(new HashSet<>());
            entityManager.persist(itemFromDbs);
            entityManager.remove(itemFromDbs);
            entityManager.flush();
            entityManager.clear();
        }
    }

    public void updateUser(User myUser){
        User itemFromDbs = this.getById(myUser.getId());
        if (itemFromDbs != null) {
            itemFromDbs.setName(myUser.getName());
            itemFromDbs.setSurname(myUser.getSurname());
            itemFromDbs.setUsername(myUser.getUsername());
            itemFromDbs.setPassword(myUser.getPassword());
            itemFromDbs.setEmail(myUser.getEmail());
            itemFromDbs.setPhone(myUser.getPhone());
            itemFromDbs.setImage(myUser.getImage());
            entityManager.persist(itemFromDbs);
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

    public Set<Project> getAssignedProjects(Long userId) {

        if (userId!=null){

            Query query =this.entityManager.createQuery("select pj from Project as pj join pg.users as pgu where  pgu.id=:userId");
            query.setParameter("userId",userId);
            List<Project> result = query.getResultList();
            if (!result.isEmpty()){
                return new HashSet<Project>(result);
            }
            throw new EmptyResultDataAccessException("No result for this id!", 1);

        }
       throw  new UnknownSqlResultSetMappingException("Not found");
    }

    public Set<Task> getUserTasks(Long userId) {
        if (userId != null) {
            Query query = this.entityManager.createQuery("select t from Task as t join t.userTasks as utsk where utsk.id=:userId");
            query.setParameter("userId", userId);
            List<Task> result = query.getResultList();
            if(!result.isEmpty()){

                return new HashSet<Task>(result);

            }

            throw new EmptyResultDataAccessException("No result for this id!", 1);

        }
        throw  new UnknownSqlResultSetMappingException("Not found");
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


}