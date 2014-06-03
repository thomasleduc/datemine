/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.controller;

import com.epita.mti.datemine.data.Business.UserBusiness;
import com.epita.mti.datemine.data.Entity.User;
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
 * @author macbookpro
 */
@Named
@RequestScoped
public class LoginController {

    private final static Logger log =
            Logger.getLogger(LoginController.class.getName());

    @Inject
    private SessBean session;
    @Inject
    private UserBusiness userBusiness;
    @Getter @Setter
    private String username;
    @Getter @Setter
    private String password;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {

    }

    /**
     * @return the isLoggedIn
     */
    public String action() {

        // CHECKING
        if (!userBusiness.checkUsername(username)) {
            log.log(Level.SEVERE,
                    "{0} : Login : Possible username attack", username);
            return "login.xhtml?faces-redirect=true";
        }

        if (!userBusiness.checkPassword(password)) {
            log.log(Level.SEVERE,
                    "{0} : Login : Possible password attack", password);
            return "login.xhtml?faces-redirect=true";
        }

        // AUTHENTICATE
        User user = userBusiness.authenticate(username, password);
        if (user == null) {
            log.log(Level.SEVERE,
                    "{0} : Login : Failed authenticate", password);
            session.invalidate();
            return "login.xhtml?faces-redirect=true";
        }

        // SESSION FILLING
        session.setUsername(user.getLogin());
        session.setLoggedIn(true);
        return "main.xhtml?faces-redirect=true";
    }
}
