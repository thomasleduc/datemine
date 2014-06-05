package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.DAO.tools.FieldAccess;
import com.epita.mti.datemine.data.Entity.User;
import com.epita.mti.datemine.tools.RESTError;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author leduc_t
 */
@RequestScoped
@Named
public class UserBusiness extends AbstractBusiness<UserDAO, User> {

    private static final Logger log = Logger.getLogger(UserBusiness.class.getName());

    /**
     * The user DAO (injected).
     */
    @Inject
    private UserDAO userDAO;

    @Override
    public UserDAO getDao() {
        return userDAO;
    }

    /**
     * The checking constrain.
     */
    public enum CheckingConstrain {
        /**
         * The login limits.
         */
        LOGIN(4, 45),
        /**
         * The password limits.
         */
        PASSWORD(5, 70);
        @Getter
        private final int min;
        @Getter
        private final int max;
        private CheckingConstrain(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    @Override
    public RESTError checkBeforeAdding(User entity) {

        if (entity == null || entity.getLogin() == null) {
            return RESTError.BAD_PARAMETER;
        }

        if (entity.getLogin().length() < CheckingConstrain.LOGIN.min) {
            return RESTError.LOGIN_TOO_SHORT;
        }

        if (entity.getLogin().length() > CheckingConstrain.LOGIN.max) {
            return RESTError.LOGIN_TOO_LONG;
        }

        return null;
    }

    /**
     * @param username The login credential.
     * @param password The password credential.
     * @return if the credentials sent through the bean match the database \
     * user informations.
     */
    public User authenticate(String username, String password) {
        // Get the user associate with the login
        User user = userDAO.getUser(username);

        // If a user match with the login
        if (user == null) {
            log.log(Level.SEVERE, "{0} : User not found in Database", username);
            return null;
        }

        // Check if his password is ok.
        if (!DatemineDigest.compare(password, user.getPasswd())) {
            return null;
        }

        // If all right, return it.
        return user;
    }

    /**
     * @param username The email to be tested
     * @return if the username exist in the base.
     */
    public Boolean usernameExist(String username) {
        return userDAO.exist(FieldAccess.USERNAME, username);
    }

    /**
     * @param email The email to be tested
     * @return if the email exist in the base.
     */
    public Boolean emailExist(String email) {
        return userDAO.exist(FieldAccess.USEREMAIL, email);
    }

    /**
     * The register method (date is default : TODAY).
     * @param username The user login.
     * @param password The user password.
     * @param email The user email.
     * @return if the user seems registered.
     */
    public Boolean register(String username, String password, String email) {
        return register(username, DatemineDigest.encode(password), email, new Date());
    }

    /**
     * The register method.
     * @param username The user login.
     * @param password The user password.
     * @param email The user email.
     * @param date The user account creation date.
     * @return if the user seems registered.
     */
    public Boolean register(String username, String password, String email, Date date) {
        User newUser = new User(null, username, password, email, date);
        if (checkBeforeAdding(newUser) == null) {
            return userDAO.persist(newUser);
        }

        log.log(Level.INFO,
                "Register({0} : {1}) : Failed Checking.",
                new String[]{username, email});
        return false;
    }

    /**
     * @param username The username.
     * @return if the username is ok.
     */
    public boolean checkUsername(String username) {
        if (username == null) {
            return false;
        }
        return username.length() >= CheckingConstrain.LOGIN.min
            && username.length() <= CheckingConstrain.LOGIN.max;
    }

    /**
     * @param password The password.
     * @return if the password is ok.
     */
    public boolean checkPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.length() >= CheckingConstrain.PASSWORD.min
            && password.length() <= CheckingConstrain.PASSWORD.max;
    }
}
