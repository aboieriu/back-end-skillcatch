package view;


import org.codehaus.jackson.annotate.JsonCreator;

import java.util.Date;
import java.util.Set;

/**
 * Created by aboieriu on 6/29/16.
 */
public class LoggedUserView {
    private final Long Id;

    private final String name;

    private final String surname;

    private final String username;

    private final String email;

    private final String phone;

    private final String address;

    private final String image;

    private final Date addedOn;

    private final Set<TaskPlanView> taskPlans;

    private final Boolean admin;

    @JsonCreator
    public LoggedUserView(Long id, String name, String surname, String username, String email, String phone, String address, String image,Set<TaskPlanView> taskPlans, Boolean admin,Date addedOn) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.taskPlans = taskPlans;
        this.admin = admin;
        this.addedOn=addedOn;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public Set<TaskPlanView> getTaskPlans() {
        return taskPlans;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggedUserView that = (LoggedUserView) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (addedOn != null ? !addedOn.equals(that.addedOn) : that.addedOn != null) return false;
        if (taskPlans != null ? !taskPlans.equals(that.taskPlans) : that.taskPlans != null) return false;
        return admin != null ? admin.equals(that.admin) : that.admin == null;

    }

    @Override
    public int hashCode() {
        int result = Id != null ? Id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (addedOn != null ? addedOn.hashCode() : 0);
        result = 31 * result + (taskPlans != null ? taskPlans.hashCode() : 0);
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        return result;
    }
}
