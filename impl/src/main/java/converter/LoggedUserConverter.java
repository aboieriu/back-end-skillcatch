package converter;

import domain.RoleConst;
import model.Role;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import view.BadgeView;
import view.LoggedUserView;
import view.TaskPlanView;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by aboieriu on 6/29/16.
 */
public class LoggedUserConverter {
    @Autowired
    private BadgeConverter badgeConverter;
    @Autowired
    private TaskPlanConverter taskPlanConverter;


    public LoggedUserView convert(User user) {
        if (user == null) {
            return null;
        }

        Set<TaskPlanView> taskplans=new HashSet<>();
        Set<BadgeView> badges = new HashSet<>();

        taskplans.addAll(user.getTaskPlans().stream().map(taskPlan2 -> taskPlanConverter.convert(taskPlan2)).collect(Collectors.toSet()));
        user.getTaskPlans().stream().forEach(taskPlan -> {
            badges.addAll(taskPlan.getBadges().stream().map(badge -> badgeConverter.convert(badge, taskPlan)).collect(Collectors.toSet()));
            taskPlan.getTasks().stream().forEach(task -> {
                badges.addAll(task.getBadges().stream().map(badge -> badgeConverter.convert(badge, task)).collect(Collectors.toSet()));
            });
        });

        user.getProjects().stream().forEach(project -> {
            taskplans.addAll(project.getTaskPlans().stream().map(taskPlan1 ->taskPlanConverter.convert(taskPlan1) ).collect(Collectors.toSet()));
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
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getImage(),
                taskplans,
                admin,
                user.getAddedOn());
    }

    public BadgeConverter getBadgeConverter() {
        return badgeConverter;
    }

    public void setBadgeConverter(BadgeConverter badgeConverter) {
        this.badgeConverter = badgeConverter;
    }



}
