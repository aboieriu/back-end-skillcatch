package dao.impl;


import dao.api.ITaskplanDao;
import model.Task;
import model.TaskPlan;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

public class TaskplanDao extends GenericDao<TaskPlan> implements ITaskplanDao {

    public TaskplanDao() {
        super(TaskPlan.class);
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
    @Override
    public void removeBadgeFromTaskPlan(Long taskPlanId, Long badgeId) {
        TaskPlan taskPlanFromDbs=this.getById(taskPlanId);
        if(taskPlanFromDbs!=null){
            taskPlanFromDbs.getBadges().removeIf(badge -> badge.getId().equals(badgeId));
            entityManager.merge(taskPlanFromDbs);
            entityManager.flush();

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


}
