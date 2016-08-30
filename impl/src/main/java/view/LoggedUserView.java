package view;

import org.codehaus.jackson.annotate.JsonCreator;

import java.util.List;
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

    private final Set<BadgeView> badges;

    private final Boolean admin;

    @JsonCreator
    public LoggedUserView(Long id, String name, String surname, String username, String email, String phone, String address, String image, Set<BadgeView> badges, Boolean admin) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.badges = badges;
        this.admin = admin;
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

    public Set<BadgeView> getBadges() {
        return badges;
    }

    public Boolean getAdmin() {
        return admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoggedUserView that = (LoggedUserView) o;

        if (Id != null ? !Id.equals(that.Id) : that.Id != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (admin != null ? !admin.equals(that.admin) : that.admin != null) return false;
        if (badges != null ? !badges.equals(that.badges) : that.badges != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

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
        result = 31 * result + (badges != null ? badges.hashCode() : 0);
        result = 31 * result + (admin != null ? admin.hashCode() : 0);
        return result;
    }
}
