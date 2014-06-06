package com.epita.mti.datemine.web.controller.project;

import com.epita.mti.datemine.data.Business.ProjectBusiness;
import com.epita.mti.datemine.data.Business.SharingBusiness;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.web.SessBean;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 * The Project Controller for the dashboard page.
 * @author leduc_t
 */
@Named
@RequestScoped
public class ProjectController {
    @Inject private SessBean sessBean;
    @Inject private ProjectBusiness business;
    @Getter private List<Project> projectsList;

    Logger log = Logger.getLogger(ProjectController.class.getName());

    @PostConstruct
    public void init() {
        refreshProjects();
    }

    private void refreshProjects() {
        projectsList = business.getProjects(sessBean.getId(), SharingBusiness.SharingRight.MODIFY);
    }
}
