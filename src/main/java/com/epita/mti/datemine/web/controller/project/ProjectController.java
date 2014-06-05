package com.epita.mti.datemine.web.controller.project;

import com.epita.mti.datemine.data.Business.ProjectBusiness;
import com.epita.mti.datemine.data.Business.SharingBusiness;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.web.SessBean;
import java.util.List;
import javax.inject.Inject;

/**
 * The Project Controller for the dashboard page.
 * @author leduc_t
 */
public abstract class ProjectController {
    @Inject
    private SessBean sessBean;
    @Inject
    private ProjectBusiness business;

    private List<Project> projectsList;

    public List<Project> getProjects() {
        return business.getProjects(sessBean.getId(), SharingBusiness.SharingRight.MODIFY);
    }
}
