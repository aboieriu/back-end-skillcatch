package model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by CataVlad on 05-Nov-15.
 */
@Entity
@Table(name="task")
public class Taskplan {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long taskPlanId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Taskplan(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getTaskPlanId() {
        return taskPlanId;
    }

    public void setTaskPlanId(Long taskPlanId) {
        this.taskPlanId = taskPlanId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}