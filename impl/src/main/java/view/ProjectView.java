package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

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
    private final Set<UserView> users;

    @JsonCreator
    public ProjectView(@JsonProperty("id") Long id,
                       @JsonProperty("name")String name,
                       @JsonProperty("descriptions")String descriptions,
                       @JsonProperty("users")Set<UserView> users,
                       @JsonProperty("createdOn")Date createdOn,
                       @JsonProperty("taskPlans")Set<TaskPlanView> taskPlans) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
        this.users=users;
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

    public Set<UserView> getUsers() {
        return users;
    }
}
