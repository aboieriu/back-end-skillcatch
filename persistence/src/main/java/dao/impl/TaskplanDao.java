package dao.impl;

import dao.api.IProjectDao;
import dao.api.ITaskDao;
import dao.api.ITaskplanDao;
import dao.api.IUserDao;
import model.Project;
import model.Task;
import model.TaskPlan;
import model.User;
import org.hibernate.CacheMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.FlushModeType;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class TaskplanDao extends GenericDao<TaskPlan> implements ITaskplanDao {

    @Autowired
    private ITaskDao taskDao;


    public TaskplanDao() {
        super(TaskPlan.class);
    }

    public TaskPlan getTaskplan(Long groupId, Long taskplanId) {
        if (groupId != null || taskplanId != null) {
            Query query = this.entityManager.createQuery("select t from Taskplan as t, Project as pg join pg.taskplans where pg.id = :targetgroupId AND t.id = :targetTaskplanId ");
            query.setParameter("targetgroupId", groupId);
            query.setParameter("targetTaskplanId", taskplanId);
            List<TaskPlan> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
            throw new IllegalArgumentException("Not found!");
        }
        throw new IllegalArgumentException("Not found!");
    }


    public Set<Task> getTasks(Long taskplanId) {
        TaskPlan targetTaskplan = this.getById(taskplanId);
        return targetTaskplan.getTasks();
    }

    @Transactional
    @Override
    public void deleteById(Long taskPlanId) {

        TaskPlan taskPlanFromDbs = this.getById(taskPlanId);
        if (taskPlanFromDbs != null) {
            taskPlanFromDbs.getTasks().stream().forEach(task -> {
                task.getBadges().stream().forEach(badge -> {
                    entityManager.remove(badge);
                });
                entityManager.remove(task);
            });
            taskPlanFromDbs.getBadges().stream().forEach(badge -> {
                entityManager.remove(badge);
            });
            entityManager.remove(taskPlanFromDbs);
            entityManager.flush();
            entityManager.clear();

        }
    }


    @Transactional
    public void updateTaskplan(TaskPlan taskplan) {
        TaskPlan taskPlanFromDbs = this.getById(taskplan.getId());
        if (taskPlanFromDbs != null) {
            taskPlanFromDbs.setTasks(taskplan.getTasks());
            entityManager.persist(taskPlanFromDbs);
        }
    }

    public ITaskDao getTaskDao() {
        return taskDao;
    }

    public void setTaskDao(ITaskDao taskDao) {
        this.taskDao = taskDao;
    }
}
