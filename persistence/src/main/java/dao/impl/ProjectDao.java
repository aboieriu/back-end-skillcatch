package dao.impl;

import dao.api.IProjectDao;
import dao.api.ITaskplanDao;
import model.Project;
import model.TaskPlan;
import model.User;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectDao extends GenericDao<Project> implements IProjectDao {

    public ProjectDao() {
        super(Project.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Project itemFromDbs = this.getById(id);
        if (itemFromDbs != null) {
            itemFromDbs.getTaskPlans().stream().forEach(taskPlan -> {
                taskPlan.getTasks().stream().forEach(task -> {
                    task.getBadges().stream().forEach(badge -> {
                        entityManager.remove(badge);
                    });
                    entityManager.remove(task);
                });
                taskPlan.getBadges().stream().forEach(badge -> {
                    entityManager.remove(badge);
                });
                entityManager.remove(taskPlan);

            });
            itemFromDbs.getUsers().stream().forEach(user -> {
                user.getProjects().removeIf(project -> project.getId().equals(id));
                entityManager.remove(user);
            });
            entityManager.remove(itemFromDbs);
        }
    }
    @Transactional
    @Override
    public void removeUserFromProject(Long projectId, User userFromDbs) {
        Project projectFromDbs=this.getById(projectId);
        if(projectFromDbs!=null){
            projectFromDbs.getUsers().removeIf(user -> user.getId().equals(userFromDbs.getId()));
            entityManager.merge(projectFromDbs);
            entityManager.flush();
        }
    }



    @Transactional
    public void updateProject(Project project) {
        Project itemFromDbs = this.getById(project.getId());
        if (itemFromDbs != null) {
            itemFromDbs.setTaskPlans(project.getTaskPlans());
            itemFromDbs.setUsers(project.getUsers());
            entityManager.merge(itemFromDbs);
            entityManager.flush();
        }
    }


}

