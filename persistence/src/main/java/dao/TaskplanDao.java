package dao;

import model.Task;
import model.Taskplan;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;
import java.util.Set;


public class TaskplanDao extends GenericDao<Taskplan> implements ITaskplanDao {

    public TaskplanDao() {
        super(Taskplan.class);
    }




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
            throw new IllegalArgumentException("Not found!");
        }
        throw new IllegalArgumentException("Not found!");
    }

    @Transactional
    public void deleteTaskplan(Long taskplanId) {
        Taskplan itemFromDb=this.getById(taskplanId);

        if(itemFromDb!=null) {
            entityManager.remove(itemFromDb);
        }
    }


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


}
