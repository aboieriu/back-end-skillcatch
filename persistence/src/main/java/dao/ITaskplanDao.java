package dao;

import model.Task;
import model.Taskplan;

/**
 * Created by CataVlad on 13-Nov-15.
 */
public interface ITaskplanDao extends IGenericDao<Taskplan> {

    void updateTaskplan(Taskplan taskplan);

}
