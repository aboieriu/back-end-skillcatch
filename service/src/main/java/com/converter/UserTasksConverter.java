package com.converter;

import com.view.AssignedProjectView;
import com.view.UserTasks;
import model.ProjectGroup;
import model.Task;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by icringanu on 08.06.2016.
 */
public class UserTasksConverter {

    public UserTasks convert(Task userTasksSet){
        if(userTasksSet==null){
            return  null;
        }
        return new UserTasks(userTasksSet.getId(),userTasksSet.getName(),userTasksSet.getDescription(),userTasksSet.getStatus());
    }

    public Set<UserTasks> convert(Set<Task> userTasksSet) {
        Set<UserTasks> response = new HashSet<>();
        if (userTasksSet == null || userTasksSet.isEmpty()) {
            return response;
        }

        for (Task taskItem : userTasksSet) {
            response.add(this.convert(taskItem));
        }

        return response;
    }
}
