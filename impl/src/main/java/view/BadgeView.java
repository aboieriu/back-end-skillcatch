package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by amusat on 6/8/2016.
 */
public class BadgeView {
    private final Long id;
    private final String name;
    private final String description;
    private final Long points;
    private final String image;
    private final Boolean gained;

    @JsonCreator
    public BadgeView(@JsonProperty("id") Long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("points") Long points,
                     @JsonProperty("image") String image,
                     @JsonProperty("gained") Boolean gained) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.points = points;
        this.image= image;
        this.gained = gained;
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

    public Long getPoints() {
        return points;
    }

    public String getImage() {
        return image;
    }

    public Boolean getGained() {
        return gained;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BadgeView badgeView = (BadgeView) o;

        if (description != null ? !description.equals(badgeView.description) : badgeView.description != null)
            return false;
        if (gained != null ? !gained.equals(badgeView.gained) : badgeView.gained != null) return false;
        if (id != null ? !id.equals(badgeView.id) : badgeView.id != null) return false;
        if (image != null ? !image.equals(badgeView.image) : badgeView.image != null) return false;
        if (name != null ? !name.equals(badgeView.name) : badgeView.name != null) return false;
        if (points != null ? !points.equals(badgeView.points) : badgeView.points != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (gained != null ? gained.hashCode() : 0);
        return result;
    }
}
