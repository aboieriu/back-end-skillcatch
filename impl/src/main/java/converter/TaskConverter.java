package converter;

import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;
import view.TaskView;
import model.Task;
import view.TaskWithBadgesView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by icringanu on 08.06.2016.
 */
public class TaskConverter {

    @Autowired
    private BadgeConverter badgeConverter;

    public TaskView convert(Task task){
        if(task==null){
            return  null;
        }
        return new TaskView(task.getId(), task.getName(), task.getDescription(), task.getStatus());
    }

    public TaskWithBadgesView convertWithBadges(Task task) {
        if(task==null){
            return  null;
        }
        List<BadgeView> badgeViewList = task.getBadges().stream().map(badge -> badgeConverter.convert(badge, task)).collect(Collectors.toList());
        return new TaskWithBadgesView(task.getId(), task.getName(), task.getDescription(), task.getStatus(), badgeViewList);
    }

    public Set<TaskView> convert(Set<Task> userTasksSet) {
        Set<TaskView> response = new HashSet<>();
        if (userTasksSet == null || userTasksSet.isEmpty()) {
            return response;
        }

        for (Task taskItem : userTasksSet) {
            response.add(this.convert(taskItem));
        }

        return response;
    }

    public BadgeConverter getBadgeConverter() {
        return badgeConverter;
    }

    public void setBadgeConverter(BadgeConverter badgeConverter) {
        this.badgeConverter = badgeConverter;
    }
}
