package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "project_group")
public class Group {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "descriptions")
    private String descriptions;

    @Column(name = "status")
    private Long status;

    public Group() {}

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="user_has_project_group",
            joinColumns={@JoinColumn(name="project_group_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")})
    private Set<User> users;

    @ManyToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinTable(name="task_plan_has_project_group",
            joinColumns={@JoinColumn(name="project_group_id")},
            inverseJoinColumns = {@JoinColumn(name="task_plan_id")})
    private Set<Taskplan> taskplans;

    public Set<Taskplan> getTaskplans() {
        return taskplans;
    }

    public void setTaskplans(Set<Taskplan> taskplans) {
        this.taskplans = taskplans;
    }

    public Group(String name, String descriptions, Long status, Set<User> users, Set<Taskplan> taskplans) {
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

}
