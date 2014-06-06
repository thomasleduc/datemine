/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.controller.project;

import com.epita.mti.datemine.data.Business.CheckingConstrain;
import com.epita.mti.datemine.data.Business.ProjectBusiness;
import com.epita.mti.datemine.data.DAO.tools.ProjectAlreadyTakenException;
import com.epita.mti.datemine.data.DAO.tools.UserNotFoundException;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.web.ProjectBean;
import com.epita.mti.datemine.web.SessBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author leduc_t
 */
@Named
@RequestScoped
public class NewProjectController {
    @Inject private SessBean sessBean;
    @Inject private ProjectBean projBean;
    @Inject private ProjectBusiness business;
    @Getter @Setter private String name;
    @Getter private final int nameMin;
    @Getter private final int nameMax;
    @Getter private Boolean projectNameAlreadyTaken;
    private final static Logger log =
            Logger.getLogger(NewProjectController.class.getName());

    public NewProjectController() {
        nameMin = CheckingConstrain.PROJECT_NAME.getMin();
        nameMax = CheckingConstrain.PROJECT_NAME.getMax();
        projectNameAlreadyTaken = false;
    }

    public String createProject() {
        try {
            Project proj = business.createProject(name, sessBean.getId());
            if (proj != null) {
                projBean.init(proj);
                return "project.xhtml?faces-redirect=true";
            }
        } catch(ProjectAlreadyTakenException pate) {
            log.log(Level.INFO, "Fail to add project : {0}", name);
            projectNameAlreadyTaken = true;
        } catch (UserNotFoundException unfe) {
            sessBean.invalidate();
            return "login.xhtml?faces-redirect=true&error=1505";
        }
        return "main.xhtml?faces-redirect=true&error=1001";
    }
}
