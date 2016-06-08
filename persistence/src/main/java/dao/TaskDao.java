package dao;

import model.Badge;
import model.ProjectGroup;
import model.Task;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class TaskDao extends GenericDao<Task> implements ITaskDao {

    public TaskDao() {
        super(Task.class);
    }


    public Task getTask(Long groupId, Long taskplanId, Long taskId) {
        Query query = this.entityManager.createQuery("select t from ProjectGroup as pg join pg.taskplans as tp join tp.tasks as t where tp.id = :targettaskplanId AND t.id = :targettaskId AND pg.id =:targetprojectgroupId ");
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
        return targetTask.getBadges();
    }

    @Transactional
    public void updateTask(Task task) {
        Task taskFromDbs = this.getById(task.getId());
        if (taskFromDbs != null) {
            taskFromDbs.setName(task.getName());
            taskFromDbs.setDescription(task.getDescription());
            taskFromDbs.setStatus(task.getStatus());
            entityManager.persist(taskFromDbs);
        }
    }

    @Transactional
    public void add(Task task) {

        entityManager.persist(task);

    }



}
