package facade;
import dao.ITaskplanDao;
import model.Taskplan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import dao.IGenericDao;

import java.util.List;


public class TaskplanFacade implements ITaskplanFacade {

    @Autowired
    private ITaskplanDao TaskplanDao;

    public List<Taskplan> getAllTaskplan(){
        return this.TaskplanDao.getAll();
    }
    public Taskplan getTaskplan(Long groupId , Long taskplanId){ return this.TaskplanDao.getTaskplan(groupId, taskplanId);}

    public Taskplan getTaskplanById(Long taskplanId){
        return this.TaskplanDao.getById(taskplanId);}

    public void addTaskplan(Taskplan taskplan){
        this.TaskplanDao.add(taskplan);
    }

    public void deleteTaskplanById(Long taskplanId){
        this.TaskplanDao.deleteById(taskplanId);
    }

    public void updateTaskplan(Taskplan taskplan){
        this.TaskplanDao.updateTaskplan(taskplan);
    }
    public void deleteTaskplan(Long groupId , Long taskplanId){this.TaskplanDao.deleteTaskplan(groupId, taskplanId);}

}
