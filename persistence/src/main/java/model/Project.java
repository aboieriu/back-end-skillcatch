package model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Table;
import java.util.Collections;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "project")
public class Project {
    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinTable(name = "user_has_project",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "project_has_task_plan",
            joinColumns = {@JoinColumn(name = "project_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_plan_id")})
    private Set<TaskPlan> taskPlans;

    @Column(name = "createdOn", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    public Project() {
        this.createdOn = new Date();
        this.taskPlans = Collections.emptySet();
        this.users=Collections.emptySet();
    }

    public Project(String name, String descriptions, Set<User> users, Set<TaskPlan> taskPlans) {
        this.name = name;
        this.descriptions = descriptions;
        this.users = users;
        this.taskPlans = taskPlans;
        this.createdOn = new Date();
    }

    public Project(String name, String descriptions, Set<User> users, Set<TaskPlan> taskPlans, Date createdOn) {
        this.name = name;
        this.descriptions = descriptions;
        this.users = users;
        this.taskPlans = taskPlans;
        this.createdOn = createdOn;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<TaskPlan> getTaskPlans() {
        return taskPlans;
    }

    public void setTaskPlans(Set<TaskPlan> taskPlans) {
        this.taskPlans = taskPlans;
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

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }


    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != null ? !id.equals(project.id) : project.id != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (descriptions != null ? !descriptions.equals(project.descriptions) : project.descriptions != null)
            return false;
        return createdOn != null ? createdOn.equals(project.createdOn) : project.createdOn == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (descriptions != null ? descriptions.hashCode() : 0);
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        return result;
    }
}
