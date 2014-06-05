package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.ProjectDAO;
import com.epita.mti.datemine.data.DAO.tools.FieldAccess;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.tools.RESTError;
import java.util.List;
import javax.inject.Inject;

/**
 * The project Business class.
 * @author leduc_t
 */
public class ProjectBusiness extends AbstractBusiness<ProjectDAO, Project> {

    @Inject
    private ProjectDAO projectDAO;

    @Override
    public ProjectDAO getDao() {
        return projectDAO;
    }

    @Override
    public RESTError checkBeforeAdding(Project project) {
        if (lenghtBetween(project.getName(), 2, 80)) {
            return RESTError.PROJECT_NAME_LENGTH;
        }
        return null;
    }

    public List<Project> searchProjectListWithPrefix(String prefix) {
        return projectDAO.searchProjectListWithPrefix(prefix);
    }
    
    public List<Project> getProjects(long userid, SharingBusiness.SharingRight right) {
        return projectDAO.getProjects(userid, right.getValue());
    }

    public Project createProject(String name) {

        if (checkProjectAlreadyTaken(name)) {
            Project proj = new Project(name);
            return persist(proj);
        }

        return null;
    }

    private boolean checkProjectAlreadyTaken(String name) {
        return getDao().exist(FieldAccess.PROJECTNAME, name);
    }
}
