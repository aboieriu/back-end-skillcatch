package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by CataVlad on 05-Nov-15.
 */

@Entity
@Table(name = "badge")
public class Badge {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    public Badge(){}

    public Badge(String name, String description) {
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

}
