package com.epita.mti.datemine.web.controller.home;

import com.epita.mti.datemine.data.Business.CheckingConstrain;
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
 * @author leduc_t
 */
@Named
@RequestScoped
public class LoginController {

    private final static Logger log =
            Logger.getLogger(LoginController.class.getName());

    @Inject private SessBean session;
    @Inject private UserBusiness userBusiness;
    @Getter @Setter private String username;
    @Getter @Setter private String password;
    
    /**
     * Validation stuff
     */
    @Getter private final int loginMin;
    @Getter private final int loginMax;
    @Getter private final int passwordMin;
    @Getter private final int passwordMax;

    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        username = null;
        password = null;
        loginMin = CheckingConstrain.LOGIN.getMin();
        loginMax = CheckingConstrain.LOGIN.getMax();
        passwordMin = CheckingConstrain.PASSWORD.getMin();
        passwordMax = CheckingConstrain.PASSWORD.getMax();
    }

    /**
     * @return the isLoggedIn
     */
    public String action() {

        // CHECKING
        if (!userBusiness.checkUsername(username)) {
            log.log(Level.SEVERE,
                    "{0} : Login : Possible username attack", username);
            return "login.xhtml?faces-redirect=true&error=true";
        }

        if (!userBusiness.checkPassword(password)) {
            log.log(Level.SEVERE,
                    "{0} : Login : Possible password attack", password);
            return "login.xhtml?faces-redirect=true&error=true";
        }

        // AUTHENTICATE
        User user = userBusiness.authenticate(username, password);
        if (user == null) {
            log.log(Level.SEVERE,
                    "Login({0} : {1}) : Failed authenticate",
                    new Object[]{username, password});
            session.invalidate();
            return "login.xhtml?faces-redirect=true";
        }

        // SESSION FILLING
        session.init(user);
        return "main.xhtml?faces-redirect=true";
    }
}