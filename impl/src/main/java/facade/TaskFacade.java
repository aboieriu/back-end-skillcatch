package facade;
import dao.ITaskDao;
import facade.ITaskFacade;
import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class TaskFacade implements ITaskFacade {

    @Autowired
    private ITaskDao TaskDao;

    public List<Task> getAllTask(){
        return this.TaskDao.getAll();
    }

    public Task getTaskById(Long taskId){
        return this.TaskDao.getById(taskId);}

    public void addTask(Task task){
        this.TaskDao.add(task);
    }

    public void deleteTask(Long groupId){
        this.TaskDao.deleteById(groupId);
    }

    public void updateTask(Task task){
        this.TaskDao.updateTask(task);
    }

}