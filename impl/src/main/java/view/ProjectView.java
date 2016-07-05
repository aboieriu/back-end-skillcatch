package view;

import java.util.Date;
import java.util.Set;

/**
 * Created by aboieriu on 7/2/16.
 */
public class ProjectView {
    private final Long id;
    private final String name;
    private final String descriptions;
    private final Date createdOn;
    private final Set<TaskPlanView> taskPlans;

    public ProjectView(Long id, String name, String descriptions, Date createdOn, Set<TaskPlanView> taskPlans) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.createdOn = createdOn;
        this.taskPlans = taskPlans;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Set<TaskPlanView> getTaskPlans() {
        return taskPlans;
    }
}
