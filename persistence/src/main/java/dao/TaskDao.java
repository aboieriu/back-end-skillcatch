package dao;

import model.Badge;
import model.Group;
import model.Task;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class TaskDao extends GenericDao<Task> implements ITaskDao {

    public TaskDao() {
        super(Task.class);
    }



    @Transactional
    public void updateTask(Task task){
        Task taskFromDbs = this.getById(task.getId());
        if (taskFromDbs != null) {
            taskFromDbs.setName(task.getName());
            taskFromDbs.setDescription(task.getDescription());
            entityManager.persist(taskFromDbs);
        }
    }
}
