package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * Created by aboieriu on 6/30/16.
 */
public class TaskWithBadgesView extends TaskView {
    private final List<BadgeView> badges;

    @JsonCreator
    public TaskWithBadgesView(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("status") String status,
            @JsonProperty("badges") List<BadgeView> badges) {
        super(id, name, description, status);
        this.badges = badges;
    }

    public List<BadgeView> getBadges() {
        return badges;
    }
}
