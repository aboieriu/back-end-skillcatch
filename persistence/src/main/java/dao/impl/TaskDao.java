package dao.impl;

import dao.api.ITaskDao;
import model.Badge;
import model.Task;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

public class TaskDao extends GenericDao<Task> implements ITaskDao {

    public TaskDao() {
        super(Task.class);
    }

    public Task getTask(Long groupId, Long taskplanId, Long taskId) {
        Query query = this.entityManager.createQuery("select t from Project as pg join pg.taskplans as tp join tp.tasks as t where tp.id = :targettaskplanId AND t.id = :targettaskId AND pg.id =:targetprojectgroupId ");
        query.setParameter("targettaskId", taskId);
        query.setParameter("targettaskplanId", taskplanId);
        query.setParameter("targetprojectgroupId", groupId);
        List<Task> result = query.getResultList();
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    public Task getUserTask(Long userId,Long taskId) {
        Query query = this.entityManager.createQuery("select t from Task as t join t.userTasks as utsk where utsk.id=:userId");
        query.setParameter("userId", userId);
        List<Task> result = query.getResultList();
        if (!result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    public List<Badge> getBadgeFromTask(Long taskId) {
        Task targetTask = this.getById(taskId);
        return null;
    }

    @Transactional
    public void updateTask(Task task) {
        Task taskFromDbs = this.getById(task.getId());
        if (taskFromDbs != null) {
            taskFromDbs.setBadges(task.getBadges());
            entityManager.merge(taskFromDbs);
            entityManager.flush();
        }
    }

    @Transactional
    public void add(Task task) {
        entityManager.persist(task);

    }

    @Transactional
    @Override
    public void deleteById(Long taskId) {
        Task taskFromDbs=this.getById(taskId);
        if(taskFromDbs!=null){
            taskFromDbs.getBadges().stream().forEach(badge -> {
                entityManager.remove(badge);
            });
            entityManager.remove(taskFromDbs);
            entityManager.flush();
            entityManager.clear();
        }

    }
    @Transactional
    @Override
    public void removeBadgeFromTask(Long taskId, Long badgeId) {
        Task taskFromDbs=this.getById(taskId);
        if(taskFromDbs!=null){
            taskFromDbs.getBadges().removeIf(badge -> badge.getId().equals(badgeId));
            entityManager.merge(taskFromDbs);
            entityManager.flush();
            entityManager.clear();
        }

    }


}
