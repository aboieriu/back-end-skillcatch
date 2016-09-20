package view;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by aboieriu on 6/30/16.
 */
public class TaskPlanView {
    private final Long id;
    private final String name;
    private final String description;
    private final List<TaskView> tasks;
    private final List<BadgeView> badges;

    @JsonCreator
    public TaskPlanView(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("tasks") List<TaskView> tasks,
            @JsonProperty("badges") List<BadgeView> badges) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.badges = badges;
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

    public List<TaskView> getTasks() {
        return tasks;
    }

    public List<BadgeView> getBadges() {
        return badges;
    }



}
