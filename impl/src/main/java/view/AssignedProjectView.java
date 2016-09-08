package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by amusat on 6/7/2016.
 */
public class AssignedProjectView {

    private final Long id;
    private final String name;
    private final String description;
    private final List<TaskPlanView> taskPlans;

    @JsonCreator
    public AssignedProjectView(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("taskPlans") List<TaskPlanView> taskPlans) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.taskPlans = taskPlans;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<TaskPlanView> getTaskPlans() {
        return taskPlans;
    }
}
