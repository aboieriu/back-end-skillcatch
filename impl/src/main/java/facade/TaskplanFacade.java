import model.Task;
import model.Taskplan;
import org.springframework.transaction.annotation.Transactional;
import dao.IGenericDao;


public class TaskplanFacade extends GenericFacade<Taskplan> implements ITaskplanFacade {

    public TaskplanFacade() {
        super(Taskplan.class);
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
    public void updateTaskplan(Taskplan taskplan){
        Taskplan taskplanFromDbs = this.getById(taskplan.getTaskPlanId());
        if (taskplanFromDbs != null) {
            taskplanFromDbs.setName(taskplan.getName());
            taskplanFromDbs.setDescription(taskplan.getDescription());
            item.add(taskplanFromDbs);
        }
    }

}
