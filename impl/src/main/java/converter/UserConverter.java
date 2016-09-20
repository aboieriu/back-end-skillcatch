package converter;

import domain.RoleConst;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;
import view.LoggedUserView;
import view.TaskPlanView;
import view.UserView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 7/2/16.
 */
public class UserConverter {

    @Autowired
    private TaskPlanConverter taskPlanConverter;

    public UserView convert(User user) {
        if (user == null) {
            return null;
        }
        Set<TaskPlanView> taskPlanViewList=user.getTaskPlans().stream().map(taskPlan -> taskPlanConverter.convert(taskPlan)).collect(Collectors.toSet());


        return new UserView(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getImage(),
                user.getAddedOn(),
                taskPlanViewList);
    }
}
