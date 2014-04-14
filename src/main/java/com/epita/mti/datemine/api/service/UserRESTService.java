/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.api.service;

import com.epita.mti.datemine.data.Business.UserBusiness;
import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.Entity.User;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author leduc_t
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class UserRESTService
extends AbstractRESTService<UserBusiness, UserDAO, User> {

    /**
     * The User Business.
     */
    @Inject
    private UserBusiness business;

    @Override
    public UserBusiness getBusiness() {
        return business;
    }
}
