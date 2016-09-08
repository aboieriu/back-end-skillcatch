package converter;

import model.Badge;
import model.Task;
import model.TaskPlan;
import org.springframework.beans.factory.annotation.Autowired;
import view.AssignedProjectView;
import model.Project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by amusat on 6/7/2016.
 */
public class AssignedProjectConverter {
    @Autowired
    private TaskPlanConverter taskPlanConverter;

    public AssignedProjectView convert(Project project) {
        if (project == null) {
            return null;
        }

        return new AssignedProjectView(
                project.getId(),
                project.getName(),
                project.getDescriptions(),
                project.getTaskPlans().stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toList())
        );
    }

    public Set<AssignedProjectView> convert(Set<Project> projectGroup) {
        Set<AssignedProjectView> response = new HashSet<>();
       if (projectGroup == null || projectGroup.isEmpty()) {
           return response;
       }

        for (Project projectGroupItem : projectGroup) {
            response.add(this.convert(projectGroupItem));
        }

        return response;
    }

    public TaskPlanConverter getTaskPlanConverter() {
        return taskPlanConverter;
    }

    public void setTaskPlanConverter(TaskPlanConverter taskPlanConverter) {
        this.taskPlanConverter = taskPlanConverter;
    }
}
