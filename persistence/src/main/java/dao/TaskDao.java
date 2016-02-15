package dao;

import model.Task;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class TaskDao extends GenericDao<Task> implements ITaskDao {

    public TaskDao() {
        super(Task.class);
    }

    @Transactional
    public Task getTask(Long taskId,Long taskplanId,Long groupId) {
        if(taskId !=null || taskplanId != null )
        {
            Query query = this.entityManager.createQuery("select t from ProjectGroup as pg join pg.taskplans as tp join tp.tasks as t where tp.id = :targetTaskplanId AND t.id = :targettaskId AND pg.id =:targetprojectgroupId ");
            query.setParameter("targettaskId", taskId);
            query.setParameter("targetTaskplanId", taskplanId);
            query.setParameter("targetprojectgroupId", groupId);
            List<Task> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }
        return null;
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
