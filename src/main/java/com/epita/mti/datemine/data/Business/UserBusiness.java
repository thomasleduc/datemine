/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.Entity.User;
import com.epita.mti.datemine.tools.RESTError;
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
    public RESTError checkBeforeAdding(User entity) {

        if (entity == null) return RESTError.BAD_PARAMETER;
        if (entity.getLogin() == null ) return RESTError.BAD_PARAMETER;
        if (entity.getLogin().length() < 5) return RESTError.LOGIN_TOO_SHORT;
        if (entity.getLogin().length() > 45) return RESTError.LOGIN_TOO_LONG;

        return null;
    }
}
