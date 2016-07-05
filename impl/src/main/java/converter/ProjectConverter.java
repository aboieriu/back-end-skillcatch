package converter;

import model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import view.AssignedProjectView;
import view.ProjectView;
import view.TaskPlanView;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/2/16.
 */
public class ProjectConverter {
    @Autowired
    private TaskPlanConverter taskPlanConverter;

    public ProjectView convert(Project project) {
        if (project == null) {
            return null;
        }
        Set<TaskPlanView> taskPlanViewSet = new HashSet<>();
        if (project.getTaskPlans() != null) {
            taskPlanViewSet = project.getTaskPlans().stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());
        }

        return new ProjectView(
                project.getId(),
                project.getName(),
                project.getDescriptions(),
                project.getCreatedOn(),
                taskPlanViewSet
        );
    }

    public TaskPlanConverter getTaskPlanConverter() {
        return taskPlanConverter;
    }

    public void setTaskPlanConverter(TaskPlanConverter taskPlanConverter) {
        this.taskPlanConverter = taskPlanConverter;
    }
}
