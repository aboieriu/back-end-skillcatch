package dao;


import model.Badge;
import model.ProjectGroup;
import model.Task;
import model.User;
import org.hibernate.procedure.UnknownSqlResultSetMappingException;
import org.springframework.dao.EmptyResultDataAccessException;

import javax.persistence.Query;
import javax.transaction.Transactional;
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
            Query query = this.entityManager.createQuery("select u from User as u, ProjectGroup as pg join pg.users where pg.id = :targetgroupId AND u.id = :targetuserId ");
            query.setParameter("targetgroupId" , groupId);
            query.setParameter("targetuserId" , userId);
            List<User> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }

        }
        return null;
    }

    @Transactional
    public void deleteUser(Long groupId , Long userId) {
        User itemFromDbs = this.getUser(groupId, userId);

        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
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

    public Set<ProjectGroup> getAssignedProjects(Long userId) {

        if (userId!=null){

            Query query =this.entityManager.createQuery("select pg from ProjectGroup as pg join pg.users as pgu where  pgu.id=:userId");
            query.setParameter("userId",userId);
            List<ProjectGroup> result = query.getResultList();
            if (!result.isEmpty()){
                return new HashSet<ProjectGroup>(result);
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