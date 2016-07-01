package model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties({"taskPlanId", "projectId"})
@Entity
@Table(name = "task_plan")
public class TaskPlan {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "task_plan_has_task",
            joinColumns = {@JoinColumn(name = "task_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private Set<Task> tasks;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "task_plan_has_badge",
            joinColumns = {@JoinColumn(name = "task_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "badge_id")})
    private Set<Badge> badges;


    public TaskPlan() {
    }

    public Long getId() {
        return id;
    }

    public TaskPlan(String name, String description, Set<Task> tasks) {
        this.name = name;
        this.description = description;
        this.tasks = tasks;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
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

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }
}
