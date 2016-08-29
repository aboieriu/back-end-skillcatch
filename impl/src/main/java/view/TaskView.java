package view;

import domain.TaskStatus;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by icringanu on 08.06.2016.
 */
public class TaskView {

    private final Long id;
    private final String name;
    private final String description;
    private final String status;

    @JsonCreator
    public TaskView(@JsonProperty("id") Long id,
                    @JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("status") String status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
