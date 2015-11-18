import model.Badge;
import model.Group;
import model.Task;
import org.springframework.transaction.annotation.Transactional;
import dao.IGenericDao;


public class TaskFacade extends GenericFacade<Task> implements ITaskFacade {

    public TaskFacade() {
        super(Task.class);
    }

    @Autowired
    private IGenericDao item;

    public IGenericDao getItem() {
        return item;
    }


    public void setItem(IGenericDao item) {
        this.item = item;
    }

    @Transactional
    public void updateTask(Task task){
        Task taskFromDbs = this.getById(task.getTaskId());
        if (taskFromDbs != null) {
            taskFromDbs.setName(task.getName());
            taskFromDbs.setDescription(task.getDescription());
            item.add(taskFromDbs);
        }
    }

}