package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.Entity.User;
import com.epita.mti.datemine.tools.RESTError;
import com.epita.mti.datemine.tools.auth.AuthToken;
import com.google.appengine.api.datastore.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author leduc_t
 */
@RequestScoped
@Named
public class UserBusiness extends AbstractBusiness<UserDAO, User> {

    /**
     * The datastore Service. 
     */
    private static DatastoreService datastore =
            DatastoreServiceFactory.getDatastoreService();
    private static String authTokenKind = "_authToken";

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

    /**
     * 
     * @param token
     * @return 
     */
    public AuthToken getAuthToken(String token) {
        //todo use MemCache
        Entity tokenEntity;
        try {
            tokenEntity = datastore
                    .get(KeyFactory.createKey(authTokenKind, token));
        } catch (com.google.appengine.api.datastore.EntityNotFoundException ex) {
            Logger.getLogger(UserBusiness.class.getName())
                    .log(Level.SEVERE, null, ex);
            return null;
        }

        return new AuthToken(
                token,
                (Long) tokenEntity.getProperty("account"),
                (Long) tokenEntity.getProperty("time")
        );
    }
}
