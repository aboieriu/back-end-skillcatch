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
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @OneToMany(cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER, mappedBy = "task")
    private Set<Badge> badges;

    public Task(){}

    public Set<Badge> getBadge() {
        return badges;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
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

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }
}
