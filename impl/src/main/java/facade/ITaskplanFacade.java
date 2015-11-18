import model.Task;
import model.Taskplan;


public interface ITaskplanFacade extends IGenericFacade<Taskplan> {

    void updateTaskplan(Taskplan taskplan);

}