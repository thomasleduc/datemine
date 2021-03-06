/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.controller.home;

import com.epita.mti.datemine.data.Business.CheckingConstrain;
import com.epita.mti.datemine.data.Business.UserBusiness;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leduc_t
 */
@RequestScoped
@Named
public class RegisterController {
    /**
     * Business layer injected.
     */
    @Inject private UserBusiness userBusiness;
    /**
     * Error username.
     */
    @Getter private Boolean usernameAlreadyTaken;
    /**
     * Error email.
     */
    @Getter private Boolean emailAlreadyTaken;
    /**
     * Field email.
     */
    @Getter @Setter private String email;
    /**
     * Field username.
     */
    @Getter @Setter private String username;
    /**
     * Field password.
     */
    @Getter @Setter private String password;
    /**
     * Login minimum size.
     */
    @Getter private final int loginMin;
    /**
     * Login maximum size.
     */
    @Getter private final int loginMax;
    /**
     * Password minimum size.
     */
    @Getter private final int passwordMin;
     /**
     * Password maximum size.
     */
    @Getter private final int passwordMax;

    /**
     * Creates a new instance of RegisterController.
     */
    public RegisterController() {
        usernameAlreadyTaken = false;
        loginMin = CheckingConstrain.LOGIN.getMin();
        loginMax = CheckingConstrain.LOGIN.getMax();
        passwordMin = CheckingConstrain.PASSWORD.getMin();
        passwordMax = CheckingConstrain.PASSWORD.getMax();
    }

    /**
     * AJAX : Let the client knows if the username is already taken
     * by updating the bean property usernameAlreadyTaken.
     */
    public void isUsernameAlreadyTaken() {
        usernameAlreadyTaken = userBusiness.usernameExist(username);
    }

    /**
     * AJAX : Let the client knows if the email is already taken
     * by updating the bean property emailAlreadyTaken.
     */
    public void isEmailAlreadyTaken() {
        emailAlreadyTaken = userBusiness.emailExist(email);
    }

    /**
     * Register the user with properties
     * @return the url to redirect.
     */
    public String action() {

        if (userBusiness.usernameExist(email)) {
            usernameAlreadyTaken = true;
            return "register.xhtml?faces-redirect=true";
        }

        if (userBusiness.emailExist(email)) {
            emailAlreadyTaken = true;
            return "register.xhtml?faces-redirect=true";
        }
        // Register the user
        if (userBusiness.register(username, password, email) == null) {
            return "login.xhtml?faces-redirect=true";
        } else {
            return "register.xhtml?faces-redirect=true&error=true";
        }
    }
}