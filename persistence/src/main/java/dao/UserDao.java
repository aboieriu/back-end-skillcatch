package dao;

import model.Badge;
import model.ProjectGroup;
import model.Task;
import model.User;
import org.springframework.dao.DataAccessException;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;


public class UserDao extends GenericDao<User> implements IUserDao{

    public UserDao() {
        super(User.class);
    }


    @Transactional
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
    @Transactional
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

    @Transactional
    public Set<ProjectGroup> getAssignedProjects(Long userId) throws Exception {
        if (userId!=null){

            Query query =this.entityManager.createQuery("select pg.name,pg.descriptions,pg.status from ProjectGroup as pg, User as u join pg.ProjectForUser as pgu where  u.id = :userId and pgu.id=u.id ");
            query.setParameter("userId",userId);
            List<ProjectGroup> result=query.getResultList();
            if (!result.isEmpty()){
                Set<ProjectGroup> projectGroupSet=new HashSet<ProjectGroup>(result);

                return projectGroupSet;
            }


        }
        throw new Exception();
    }
    @Transactional
    public Set<Task> getUserTasks(Long userId){
        User targetUser=getById(userId);
        return targetUser.getUserTasks();
    }

}