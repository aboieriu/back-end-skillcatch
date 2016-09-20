package view;

import java.util.Date;
import java.util.Set;

/**
 * Created by aboieriu on 7/2/16.
 */
public class UserView {
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

    public UserView(Long id, String name, String surname, String username, String email, String phone, String address, String image, Date addedOn,Set<TaskPlanView> taskPlans) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.addedOn = addedOn;
        this.taskPlans=taskPlans;
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

    public Date getAddedOn() {
        return addedOn;
    }

    public Set<TaskPlanView> getTaskPlans() {
        return taskPlans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserView userView = (UserView) o;

        if (Id != null ? !Id.equals(userView.Id) : userView.Id != null) return false;
        if (addedOn != null ? !addedOn.equals(userView.addedOn) : userView.addedOn != null) return false;
        if (address != null ? !address.equals(userView.address) : userView.address != null) return false;
        if (email != null ? !email.equals(userView.email) : userView.email != null) return false;
        if (image != null ? !image.equals(userView.image) : userView.image != null) return false;
        if (name != null ? !name.equals(userView.name) : userView.name != null) return false;
        if (phone != null ? !phone.equals(userView.phone) : userView.phone != null) return false;
        if (surname != null ? !surname.equals(userView.surname) : userView.surname != null) return false;
        if (username != null ? !username.equals(userView.username) : userView.username != null) return false;
        if (taskPlans != null ? !taskPlans.equals(userView.taskPlans) : userView.taskPlans != null) return false;

        return true;
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
        return result;
    }
}
