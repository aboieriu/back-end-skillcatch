package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by CataVlad on 05-Nov-15.
 */
@Entity
@Table(name ="role")
public class Role {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long roleId;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    public Role (){}

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getRoleId() {

        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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