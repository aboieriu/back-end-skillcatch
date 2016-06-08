package model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@JsonIgnoreProperties(value = {"taskPlanId", "projectId", "groupId", "0", "1"}, ignoreUnknown = true)
@Entity
@Table(name = "badge")
public class Badge {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    @Column(name="points")
    private  Long points;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_badge",
            joinColumns = {@JoinColumn(name = "badge_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<Badge> userBadges;

    public Set<Badge> getUserBadges() {
        return userBadges;
    }

    public void setUserBadges(Set<Badge> userBadges) {
        this.userBadges = userBadges;
    }

    public Badge() {
    }

    public Badge(String name, String description,String image,Long points) {
        this.name = name;
        this.description = description;
        this.image=image;
        this.points=points;

    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
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
