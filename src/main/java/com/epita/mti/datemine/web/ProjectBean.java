/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web;

import com.epita.mti.datemine.data.Entity.Project;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 * The session current Project, a cache between the front and the database.
 * @author leduc_t
 */
@Named
@SessionScoped
public class ProjectBean extends Project {
    @Getter @Setter
    private Date lastUpdate;
    
    /**
     * Invalidate the project session.
     */
    public void invalidate() {
        setId(null);
        setName(null);
        setUrl(null);
        setCreationDate(null);
        setOwner(null);
    }

    public void init(Project proj) {
        setId(proj.getId());
        setName(proj.getName());
        setUrl(proj.getUrl());
        setCreationDate(proj.getCreationDate());
        setOwner(proj.getOwner());
        lastUpdate = new Date();
    }
}
