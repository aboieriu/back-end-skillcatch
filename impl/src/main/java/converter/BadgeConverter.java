package converter;

import domain.TaskStatus;
import model.Task;
import model.TaskPlan;
import view.BadgeView;
import model.Badge;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by amusat on 6/8/2016.
 */
public class BadgeConverter {
    public BadgeView convert(Badge badge, Task task){
        if(badge==null){
            return  null;
        }
        boolean gained = task != null ?  TaskStatus.DONE.name().equals(task.getStatus()) : false;
        return convertRaw(badge.getId(), badge.getName(), badge.getDescription(), badge.getPoints(), badge.getImage(), gained);
    }

    public BadgeView convert(Badge badge, TaskPlan taskPlan){
        if(badge==null){
            return  null;
        }
        boolean gained = true;
        if (taskPlan != null && taskPlan.getTasks() != null) {
            for (Task task : taskPlan.getTasks()){
                if (!TaskStatus.DONE.name().equals(task.getStatus())) {
                    gained = false;
                }
            }
        }
        return convertRaw(badge.getId(), badge.getName(), badge.getDescription(), badge.getPoints(), badge.getImage(), gained);
    }

    public BadgeView convert(Badge badgeSet){
        if(badgeSet==null){
            return  null;
        }
        return convertRaw(badgeSet.getId(),badgeSet.getName(),badgeSet.getDescription(),badgeSet.getPoints(),badgeSet.getImage(), false);
    }

    public Set<BadgeView> convert(Set<Badge> badgeSet) {
        Set<BadgeView> response = new HashSet<>();
        if (badgeSet == null || badgeSet.isEmpty()) {
            return response;
        }

        for (Badge badgeItem : badgeSet) {
            response.add(this.convert(badgeItem));
        }

        return response;
    }

    private BadgeView convertRaw(Long id, String name, String description, Long points, String image, boolean gained) {
        return new BadgeView(id, name, description, points, image, gained);
    }
}
