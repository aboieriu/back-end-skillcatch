package converter;

import model.Project;
import view.ProjectView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by icringanu on 01.07.2016.
 */
public class ProjectConverter {

    public ProjectView convert(Project project){
        if(project==null){
            return null;
        }
        return new ProjectView(project.getId(),project.getName(),project.getDescriptions());
    }

    public Set<ProjectView> convert(Set<Project> projectSet){
        Set<ProjectView> response=new HashSet<>();
        if(projectSet==null||projectSet.isEmpty()){
            return response;
        }
        for(Project projectItem:projectSet){
            response.add(this.convert(projectItem));
        }
        return response;
    }
}
