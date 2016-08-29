package converter;

import domain.RoleConst;
import model.Role;
import model.User;
import view.BadgeView;
import view.LoggedUserView;
import view.UserView;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/2/16.
 */
public class UserConverter {

    public UserView convert(User user) {
        if (user == null) {
            return null;
        }

        return new UserView(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getImage(),
                user.getAddedOn());
    }
}
