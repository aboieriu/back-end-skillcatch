package dao;

import com.sun.javafx.tk.Toolkit;
import model.ProjectGroup;
import model.Task;
import model.Taskplan;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.Collection;
import java.util.Iterator;
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
    public Taskplan getTaskplan(Long groupId,Long taskplanId) {
        if(groupId !=null || taskplanId != null)
        {
            Query query = this.entityManager.createQuery("select t from Taskplan as t, ProjectGroup as pg join pg.taskplans where pg.id = :targetgroupId AND t.id = :targetTaskplanId ");
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
    public void deleteTaskplan(Long taskplanId) {
        Taskplan itemFromDb=this.getById(taskplanId);

        if(itemFromDb!=null) {
            entityManager.remove(itemFromDb);
        }
    }

    @Transactional
    public Set<Task> getTasks(Long taskplanId){
        Taskplan targetTaskplan = this.getById(taskplanId);
        return targetTaskplan.getTasks();
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
    public void addTaskplan(Taskplan taskplan){
        Taskplan taskplanFromDbs=this.getById(taskplan.getId());

        if (taskplanFromDbs!=null)
        {


            taskplanFromDbs.setDescription(taskplan.getDescription());
            taskplanFromDbs.setName(taskplan.getName());
        }

        entityManager.persist(taskplan);

    }
}
