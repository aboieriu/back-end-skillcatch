package dao;

import model.Task;
import model.Taskplan;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class TaskplanDao extends GenericDao<Taskplan> implements ITaskplanDao {

    public TaskplanDao() {
        super(Taskplan.class);
    }

    @Transactional
    public void updateTaskplan(Taskplan taskplan){
        Taskplan taskplanFromDbs = this.getById(taskplan.getTaskPlanId());
        if (taskplanFromDbs != null) {
            taskplanFromDbs.setName(taskplan.getName());
            taskplanFromDbs.setDescription(taskplan.getDescription());
            entityManager.persist(taskplanFromDbs);
        }
    }

}
