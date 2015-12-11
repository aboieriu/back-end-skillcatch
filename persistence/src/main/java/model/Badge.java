package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
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
    private Long badgeId;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    public Badge(){}

    public Badge(String name, String description) {
        this.name = name;
        this.description = description;
    }



    // setare Group
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Group> group = new HashSet<Group>(0);

    public Set<Group> getGroup() {

        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }





    public Long getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(Long badgeId) {
        this.badgeId = badgeId;
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

}
