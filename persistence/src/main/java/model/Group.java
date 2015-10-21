package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;



@Entity
@Table(name = "login_group")
public class Group {

    @GeneratedValue(generator = "idIncrementor")
    @GenericGenerator(name = "idIncrementor", strategy = "increment")
    @Id
    private Long id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private String password;



    public Group() {}

    public Group(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
