package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.ProjectDAO;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.tools.RESTError;
import java.util.Collection;
import javax.inject.Inject;

/**
 *
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

    public Collection<Project> searchProjectListWithPrefix(String prefix) {
        return projectDAO.searchProjectListWithPrefix(prefix);
    }
}
