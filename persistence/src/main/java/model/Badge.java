package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CataVlad on 05-Nov-15.
 */

@Entity
@Table(name = "badge")
public class Badge {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name ="image")
    private String image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;


    public Badge(){}

    public Badge(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    @JsonIgnore
    public Task getTask() {
        return task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
