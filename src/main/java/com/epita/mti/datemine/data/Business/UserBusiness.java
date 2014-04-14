/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.Entity.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author macbookpro
 */
@RequestScoped
@Named
public class UserBusiness extends AbstractBusiness<UserDAO, User> {

    /**
     * The user DAO (injected).
     */
    @Inject
    private UserDAO userDAO;

    @Override
    public UserDAO getDao() {
        return userDAO;
    }

    @Override
    public Error checkBeforeAdding(User entity) {

        if (entity == null) return Error.;
        if (entity.getLogin() == null 
                || entity.getLogin().length() < 5
                || entity.getLogin().length() > 45) {
            return false;
        }

        return true;
    }

}
