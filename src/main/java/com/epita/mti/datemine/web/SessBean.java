package com.epita.mti.datemine.web;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author leduc_t
 */
@SessionScoped
@Named
public class SessBean implements Serializable {
    @Getter @Setter
    private String username;
    private boolean loggedIn;

    /**
     * Create the bean.
     */
    public SessBean() {
    
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

    public void invalidate() {
        setLoggedIn(false);
        setUsername(null);
    }
}

