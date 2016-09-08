package dao.api;

import model.Task;



public interface ITaskDao extends IGenericDao<Task>  {

    void updateTask(Task task);
    void add(Task task);
    void deleteById(Long taskId);
    void removeBadgeFromTask(Long taskId, Long badgeId);
}
