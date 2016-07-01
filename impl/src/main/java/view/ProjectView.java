package view;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by icringanu on 01.07.2016.
 */
public class ProjectView {

    private final Long id;
    private final String name;
    private final String descriptions;


    @JsonCreator
    public ProjectView(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("descriptions") String descriptions) {
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;

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
}
