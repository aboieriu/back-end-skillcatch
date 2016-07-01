package converter;

import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;
import view.TaskPlanView;
import view.TaskView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/30/16.
 */
public class TaskPlanConverter {
    @Autowired
    private BadgeConverter badgeConverter;

    @Autowired
    private TaskConverter taskConverter;

    public TaskPlanView convert(TaskPlan taskPlan) {
        if (taskPlan == null) {
            return null;
        }

        List<TaskView> taskViewList = taskPlan.getTasks().stream().map(task -> taskConverter.convertWithBadges(task)).collect(Collectors.toList());
        List<BadgeView> badgeViewList = taskPlan.getBadges().stream().map(badge -> badgeConverter.convert(badge, taskPlan)).collect(Collectors.toList());

        return new TaskPlanView(taskPlan.getName(), taskPlan.getDescription(), taskViewList, badgeViewList);
    }

    public BadgeConverter getBadgeConverter() {
        return badgeConverter;
    }

    public void setBadgeConverter(BadgeConverter badgeConverter) {
        this.badgeConverter = badgeConverter;
    }

    public TaskConverter getTaskConverter() {
        return taskConverter;
    }

    public void setTaskConverter(TaskConverter taskConverter) {
        this.taskConverter = taskConverter;
    }
}
