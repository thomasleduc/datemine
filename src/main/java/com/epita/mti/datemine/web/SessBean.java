package com.epita.mti.datemine.web;

import com.epita.mti.datemine.data.Entity.User;
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
    private long id;
    @Getter @Setter
    private String username;
    private boolean loggedIn;

    /**
     * Create the bean.
     */
    public SessBean() {
        id = 0;
        username = null;
        loggedIn = false;
    }

    /**
     * @return if the user is logged in.
     */
    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    /**
     * Invalidate the session.
     */
    public void invalidate() {
        loggedIn = false;
        setUsername(null);
    }

    public void init(User user) {
        setId(user.getId());
        setUsername(user.getLogin());
        loggedIn = true;
    }
}

