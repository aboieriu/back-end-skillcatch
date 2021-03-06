package model;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Table;
import java.util.Set;


@Entity
@Table(name = "project_group")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class ProjectGroup {


    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinTable(name = "project_group_has_user",
            joinColumns = {@JoinColumn(name = "project_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> users;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "project_group_has_task_plan",
            joinColumns = {@JoinColumn(name = "project_group_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_plan_id")})
    private Set<Taskplan> taskplans;

    public ProjectGroup() {
    }

    public ProjectGroup(String name, String descriptions, String status, Set<User> users, Set<Taskplan> taskplans) {
        this.name = name;
        this.descriptions = descriptions;
        this.status = status;
        this.users = users;
        this.taskplans = taskplans;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Taskplan> getTaskplans() {
        return taskplans;
    }

    public void setTaskplans(Set<Taskplan> taskplans) {
        this.taskplans = taskplans;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
