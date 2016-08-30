package model;


import domain.RoleConst;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user")
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

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name="image", nullable = true)
    private String image;

    @Column(name = "addedOn", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedOn;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> userRole;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.REFRESH})
    @JoinTable(name = "user_has_task_plan",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_plan_id")})
    private Set<TaskPlan> taskPlans;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_has_project",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects;

    public User() {
        Role role=new Role();
        role.setName(RoleConst.ROLE_USER.name());
        role.setDescription("Rol Utilizator");
        this.addedOn = new Date();
        this.userRole = new HashSet<>(Arrays.asList(role));
        this.taskPlans = Collections.emptySet();
        this.projects = Collections.emptySet();
    }

    public User(String name, String surname, String username, String password, String email, String phone, String address, String image, Set<Role> userRole, Set<TaskPlan> taskPlans, Set<Project> projects) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.userRole = userRole;
        this.taskPlans = taskPlans;
        this.projects = projects;
        this.addedOn = new Date();
    }

    public User(String name, String surname, String username, String password, String email, String phone, String address, String image, Set<Role> userRole, Set<TaskPlan> taskPlans, Set<Project> projects, Date addedOn) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.userRole = userRole;
        this.taskPlans = taskPlans;
        this.projects = projects;
        this.addedOn = addedOn;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Role> getUserRole() {
        Hibernate.initialize(userRole);
        return userRole;
    }

    public void setUserRole(Set<Role> userRole) {
        this.userRole = userRole;
    }

    public Set<TaskPlan> getTaskPlans() {
        return taskPlans;
    }

    public void setTaskPlans(Set<TaskPlan> taskPlans) {
        this.taskPlans = taskPlans;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }
}
