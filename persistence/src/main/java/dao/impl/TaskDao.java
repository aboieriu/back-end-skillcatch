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
