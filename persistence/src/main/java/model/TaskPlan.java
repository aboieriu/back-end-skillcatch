package model;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "task_plan_has_task",
            joinColumns = {@JoinColumn(name = "task_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private Set<Task> tasks;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name = "task_plan_has_badge",
            joinColumns = {@JoinColumn(name = "task_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "badge_id")})
    private Set<Badge> badges;


    public TaskPlan() {
        tasks = Collections.emptySet();
        badges = Collections.emptySet();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskPlan taskPlan = (TaskPlan) o;
        return Objects.equals(id, taskPlan.id) &&
                Objects.equals(name, taskPlan.name) &&
                Objects.equals(description, taskPlan.description) &&
                Objects.equals(tasks, taskPlan.tasks) &&
                Objects.equals(badges, taskPlan.badges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, tasks, badges);
    }
}
