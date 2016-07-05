package dao.impl;

import dao.api.IProjectDao;
import dao.api.ITaskplanDao;
import model.Project;
import model.TaskPlan;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

public class ProjectDao extends GenericDao<Project> implements IProjectDao {

    @Autowired
    private ITaskplanDao taskplanDao;

    public ProjectDao() {
        super(Project.class);
    }

    public Set<User> getUsers(Long groupId){
        Project targetGroup = this.getById(groupId);
        return targetGroup.getUsers();
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
            itemFromDbs.setUsers(new HashSet<>());
            entityManager.persist(itemFromDbs);
            entityManager.remove(itemFromDbs);
        }
    }

    public Set<TaskPlan> getTaskplans(Long groupId) {
        Project targetGroup = this.getById(groupId);
        return targetGroup.getTaskPlans();
    }

    @Transactional
    public void updateProject(Project project) {
        Project itemFromDbs = this.getById(project.getId());
        if (itemFromDbs != null) {
            itemFromDbs.setTaskPlans(project.getTaskPlans());
            entityManager.persist(itemFromDbs);
        }
    }

    public ITaskplanDao getTaskplanDao() {
        return taskplanDao;
    }

    public void setTaskplanDao(ITaskplanDao taskplanDao) {
        this.taskplanDao = taskplanDao;
    }
}

