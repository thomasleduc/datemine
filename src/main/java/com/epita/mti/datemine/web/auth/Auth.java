/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.web.auth;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author leduc_t
 */
@ManagedBean
@SessionScoped
public class Auth implements Serializable {
    
    private static final long serialVersionUID = 7765876811740798583L;
    
    private String username;
    private String password;
    private boolean loggedIn;

    /**
     * Create the bean
     */
    public Auth() {
    
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isLoggedIn
     */
    public String action() {
        System.out.println("-----------------------------action()-----------------------");
        loggedIn = true; // TODO check if the User is logged
        return "main.xhtml?faces-redirect=true";
    }
    
    /**
     * @return if the user is logged in
     */
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    /**
     * @param loggedIn the isLoggedIn to set
     */
    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

}

