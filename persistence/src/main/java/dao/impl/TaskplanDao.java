package dao.impl;


import dao.api.ITaskplanDao;
import model.Task;
import model.TaskPlan;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<TaskPlan> getProjectUnAssignedTaskPlans(Long userId) {
/*
        Query query=this.entityManager.createQuery("FROM TaskPlan taskPlan WHERE taskPlan.id NOT IN(SELECT taskPlan.id from TaskPlan taskPlan,Project project JOIN project.taskPlans AS projectTaskPlans, User user JOIN user.taskPlans AS userTaskPlans WHERE taskPlan.id=projectTaskPlans.id AND taskPlan.id=userTaskPlans.id) AND taskPlan.id NOT IN(SELECT taskPlan.id from TaskPlan taskPlan,User user JOIN user.taskPlans AS userTaskPlans WHERE taskPlan.id=userTaskPlans.id AND userTaskPlans.userId=:targetUserId) GROUP BY taskPlan.id");
*/
        Query query=this.entityManager.createNativeQuery("select t.id,t.name,t.description from task_plan t where t.id not in(select t.id from task_plan t, project_has_task_plan pht where t.id=pht.task_plan_id ) and t.id NOT in (SELECT t.id from task_plan t, user_has_task_plan utp, user u where t.id=utp.task_plan_id and utp.user_id=:targetUserId) GROUP BY t.id",TaskPlan.class);
        query.setParameter("targetUserId", userId);
        List<TaskPlan> result=(List<TaskPlan>) query.getResultList();
        if (!result.isEmpty()){
            return result;
        }
        return new ArrayList<>();
    }


    @Transactional
    public void updateTaskplan(TaskPlan taskplan) {
        TaskPlan taskPlanFromDbs = this.getById(taskplan.getId());
        if (taskPlanFromDbs != null) {
            taskPlanFromDbs.setTasks(taskplan.getTasks());
            entityManager.merge(taskPlanFromDbs);
            entityManager.flush();
            entityManager.clear();
        }
    }


}
