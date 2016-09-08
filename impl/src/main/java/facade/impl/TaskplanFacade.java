package facade.impl;
import converter.TaskPlanConverter;
import dao.api.IBadgeDao;
import dao.api.ITaskDao;
import dao.api.ITaskplanDao;
import facade.api.ITaskplanFacade;
import model.Badge;
import model.Task;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import view.TaskPlanView;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Transactional
public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao taskplanDao;
    @Autowired
    private ITaskDao taskDao;
    @Autowired
    private TaskPlanConverter taskPlanConverter;
    @Autowired
    private IBadgeDao badgeDao;


    public Set<TaskPlanView> getAll(){
        List<TaskPlan> taskPlans = taskplanDao.getAll();
        return taskPlans.stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());
    }

    public TaskPlanView getOne(Long taskPlanId){
        TaskPlan taskPlan = taskplanDao.getById(taskPlanId);
        return taskPlanConverter.convert(taskPlan);
    }

    public void updateOne(TaskPlan taskPlan) {
        TaskPlan taskplanFromDbs=this.taskplanDao.getById(taskPlan.getId());
        if(taskplanFromDbs!=null){
            taskplanFromDbs.setName(taskPlan.getName());
            taskplanFromDbs.setDescription(taskPlan.getDescription());
            if(taskPlan.getTasks()!=null){
                taskPlan.getTasks().stream().forEach(task->{
                    Task taskToAdd=taskDao.getById(task.getId());
                    if(taskToAdd == null){
                        taskplanFromDbs.getTasks().add(task);
                    }

                });
            }
            taskplanDao.updateTaskplan(taskplanFromDbs);
        }
    }

    public void deleteOne(Long taskPlanId) {
        taskplanDao.deleteById(taskPlanId);
    }


    @Override
    public void assignBadgeToTaskPlan(Long taskPlanId, Long badgeId) {
        TaskPlan recieverTaskPlan=taskplanDao.getById(taskPlanId);
        if(recieverTaskPlan!=null){
            Badge badgeFromDbs=this.badgeDao.getById(badgeId);
            recieverTaskPlan.getBadges().add(badgeFromDbs);
            this.badgeDao.assignBadgeToTaskPlan(recieverTaskPlan);
        }
    }

    @Override
    public void removeBadgeFromTaskPlan(Long taskPlanId, Long badgeId) {
        this.taskplanDao.removeBadgeFromTaskPlan(taskPlanId,badgeId);
    }

}
