package model;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(value = {"taskPlanId" , "projectId", "taskId", "groupId", "0" , "1"}, ignoreUnknown = true)
@Entity
@Table(name="task")
public class Task {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name = "status")
    private String status;

    public Task(){}

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task",cascade = CascadeType.ALL)
    private List<Badge> badges;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_task",
            joinColumns = {@JoinColumn(name = "task_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Task> userTasks;



    public Task(String name, String description,String status) {
        this.name = name;
        this.description = description;
        this.status=status;
    }

    public Set<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<Task> userTasks) {
        this.userTasks = userTasks;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void setBadges(List<Badge> badges) {
        this.badges = badges;
    }
}
