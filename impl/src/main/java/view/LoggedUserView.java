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

    private final String password;

    private final String email;

    private final String phone;

    private final String address;

    private final String image;

    private final Set<BadgeView> badges;

    @JsonCreator
    public LoggedUserView(Long id, String name, String surname, String username, String password, String email, String phone, String address, String image, Set<BadgeView> badges) {
        Id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.badges = badges;
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

    public String getPassword() {
        return password;
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
}
