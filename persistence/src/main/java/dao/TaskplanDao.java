package dao;

import com.sun.javafx.tk.Toolkit;
import model.Task;
import model.Taskplan;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public class TaskplanDao extends GenericDao<Taskplan> implements ITaskplanDao {

    public TaskplanDao() {
        super(Taskplan.class);
    }

    @Transactional
    public void updateTaskplan(Taskplan taskplan){
        Taskplan taskplanFromDbs = this.getById(taskplan.getId());
        if (taskplanFromDbs != null) {
            taskplanFromDbs.setName(taskplan.getName());
            taskplanFromDbs.setDescription(taskplan.getDescription());
            entityManager.persist(taskplanFromDbs);
        }
    }

    @Transactional
    public Taskplan getTaskplan(Long groupId,Long taskplanId) {
        if(groupId !=null || taskplanId != null)
        {
            Query query = this.entityManager.createQuery("from Taskplan WHERE groupId = :targetgroupId AND id = :targetTaskplanId ");
            query.setParameter("targetgroupId", groupId);
            query.setParameter("targetTaskplanId", taskplanId);
            List<Taskplan> result = query.getResultList();
            if (!result.isEmpty()) {
                return result.get(0);
            }
        }
        return null;
    }

    @Transactional
    public void deleteTaskplan(Long groupId , Long taskplanId) {
        Taskplan itemFromDbs = this.getTaskplan(groupId, taskplanId);

        if (itemFromDbs != null) {
            entityManager.remove(itemFromDbs);
        }
    }

    @Transactional
    public Set<Task> getTasks(Long taskplanId){
        Taskplan targetTaskplan = this.getById(taskplanId);
        return targetTaskplan.getTasks();
    }
}
