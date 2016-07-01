package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by aboieriu on 6/30/16.
 */
public class TaskPlanView {
    private final String name;
    private final String description;
    private final List<TaskView> tasks;
    private final List<BadgeView> badges;

    @JsonCreator
    public TaskPlanView(
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("tasks") List<TaskView> tasks,
            @JsonProperty("badges") List<BadgeView> badges) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
        this.badges = badges;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskPlanView that = (TaskPlanView) o;

        if (badges != null ? !badges.equals(that.badges) : that.badges != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (tasks != null ? !tasks.equals(that.tasks) : that.tasks != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tasks != null ? tasks.hashCode() : 0);
        result = 31 * result + (badges != null ? badges.hashCode() : 0);
        return result;
    }
}
