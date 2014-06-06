package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.ProjectDAO;
import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.DAO.tools.ProjectAlreadyTakenException;
import com.epita.mti.datemine.data.DAO.tools.UserNotFoundException;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.data.Entity.User;
import com.epita.mti.datemine.tools.RESTError;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * The project Business class.
 * @author leduc_t
 */
public class ProjectBusiness extends AbstractBusiness<ProjectDAO, Project> {

    private static final Logger log = Logger.getLogger(ProjectBusiness.class.getName());

    @Inject private ProjectDAO projectDAO;
    @Inject private UserDAO userDAO;

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
        List<Project> projects = projectDAO.getProjects(userid, right.getValue());
        if (projects == null || projects.isEmpty()) {
            log.log(Level.INFO, "No projects found for user {0}", userid);
        }
        return projects;
    }

    public Project createProject(String name, long user_id)
            throws UserNotFoundException, ProjectAlreadyTakenException {

        Project proj;
        User user;

        if (!checkProjectAlreadyTaken(name)) {
            throw new ProjectAlreadyTakenException();
        }
        user = userDAO.findById(user_id);
        if (user == null) {
            throw new UserNotFoundException("No user found for the given id");
        }
        proj = new Project(name);
        proj.setOwner(user);
        proj.setCreationDate(new Date());
        return persist(proj);
    }

    /**
     * @param name The project name.
     * @return If the project name in parameter isn't already taken for the \
     * current User.
     */
    public Boolean checkProjectAlreadyTaken(String name) {
        // TODO
        return true;
    }
}
