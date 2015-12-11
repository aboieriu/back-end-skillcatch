package model;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by CataVlad on 05-Nov-15.
 */
@Entity
@Table(name="task")
public class Task {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long taskId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="badge_has_task",
        joinColumns={@JoinColumn(name="task_id")},
        inverseJoinColumns = {@JoinColumn(name="badge_id")})
    private Set<Badge> badges;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
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

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }
}
