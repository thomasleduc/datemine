/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.controller.project;

import com.epita.mti.datemine.data.Business.CheckingConstrain;
import com.epita.mti.datemine.data.Business.ProjectBusiness;
import com.epita.mti.datemine.data.Entity.Project;
import com.epita.mti.datemine.web.ProjectBean;
import com.epita.mti.datemine.web.SessBean;
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
    
    public NewProjectController() {
        nameMin = CheckingConstrain.PROJECT_NAME.getMin();
        nameMax = CheckingConstrain.PROJECT_NAME.getMax();
    }
    
    public String createProject() {
        Project proj = business.createProject(name);
        if (proj != null) {
            projBean.init(proj);
            return "project.xhtml?faces-redirect=true";
        }
        return "main.xhtml?faces-redirect=true&error=true";
    }
}
