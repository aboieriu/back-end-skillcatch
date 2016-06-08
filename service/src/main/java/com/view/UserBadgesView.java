package com.view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by amusat on 6/8/2016.
 */
public class UserBadgesView {
    private final Long id;
    private final String name;
    private final String description;
    private final Long points;
    private final String image;

    @JsonCreator
    public UserBadgesView(@JsonProperty("id") Long id,
                     @JsonProperty("name") String name,
                     @JsonProperty("description") String description,
                     @JsonProperty("points") Long points,
                     @JsonProperty("image") String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.points = points;
        this.image=image;
    }

    public String getImage() {
        return image;
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
}
