package model;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class User {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long Id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "username")
    private String username;
    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name="address")
    private String address;

    @Column
    private String image;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
    @JoinTable(name = "user_has_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> userRole;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_task",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private Set<Task> userTasks;




    public User() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(String name, String surname, String username, String password, String email, String phone,String address, String image) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password=password;
        this.email = email;
        this.phone = phone;
        this.address=address;
        this.image=image;
    }

    public Set<Task> getUserTasks() {
        return userTasks;
    }

    public void setUserTasks(Set<Task> userTasks) {
        this.userTasks = userTasks;
    }


    public Set<Role> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
