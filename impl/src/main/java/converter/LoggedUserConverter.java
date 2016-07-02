package converter;

import domain.RoleConst;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;
import view.LoggedUserView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
public class LoggedUserConverter {
    @Autowired
    private BadgeConverter badgeConverter;

    public LoggedUserView convert(User user) {
        if (user == null) {
            return null;
        }

        Set<BadgeView> badges = new HashSet<>();

        user.getTaskPlans().stream().forEach(taskPlan -> {
            badges.addAll(taskPlan.getBadges().stream().map(badge -> badgeConverter.convert(badge, taskPlan)).collect(Collectors.toSet()));
            taskPlan.getTasks().stream().forEach(task -> {
                badges.addAll(task.getBadges().stream().map(badge -> badgeConverter.convert(badge, task)).collect(Collectors.toSet()));
            });
        });

        user.getProjects().stream().forEach(project -> {
            project.getTaskPlans().stream().forEach(taskPlan -> {
                badges.addAll(taskPlan.getBadges().stream().map(badge -> badgeConverter.convert(badge, taskPlan)).collect(Collectors.toSet()));
                taskPlan.getTasks().stream().forEach(task -> {
                    badges.addAll(task.getBadges().stream().map(badge -> badgeConverter.convert(badge, task)).collect(Collectors.toSet()));
                });
            });
        });

        // Check if user is admin
        Boolean admin = false;
        for (Role role : user.getUserRole()) {
           if (RoleConst.ROLE_ADMIN.name().equals(role.getName())){
               admin = true;
           }
        }

        return new LoggedUserView(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getImage(),
                badges,
                admin);
    }

    public BadgeConverter getBadgeConverter() {
        return badgeConverter;
    }

    public void setBadgeConverter(BadgeConverter badgeConverter) {
        this.badgeConverter = badgeConverter;
    }
}
