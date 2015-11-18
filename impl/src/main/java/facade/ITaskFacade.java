import model.Badge;
import model.Task;


public interface ITaskFacade extends IGenericFacade<Task>  {

    void updateTask(Task task);

}