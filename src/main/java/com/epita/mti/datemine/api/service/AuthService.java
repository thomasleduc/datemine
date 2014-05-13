/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.api.service;

import com.epita.mti.datemine.data.Business.UserBusiness;
import com.epita.mti.datemine.data.DAO.UserDAO;
import com.epita.mti.datemine.data.Entity.User;
import com.epita.mti.datemine.tools.auth.AuthToken;
import com.epita.mti.datemine.tools.auth.AuthUtils;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 *
 * @author macbookpro
 */
@Path("/auth")
public class AuthService extends AbstractRESTService<UserBusiness, UserDAO, User> {
    
    private static final Logger log = Logger.getLogger(AuthService.class.getName());
    
    @Inject
    private UserBusiness userBusiness;
    
    @Override
    public UserBusiness getBusiness() {
        return userBusiness;
    }

    @GET
    @Path("/handshake")
    public String handshake() {
        return null;
    }

    @GET
    @Path("/token")
    public Boolean getTokenValid(@QueryParam("token") final String token) {
        return null;
    }

    @DELETE
    @Path("/token")
    public Boolean deleteToken(@QueryParam("token") final String token) {
        return null;
    }

    @POST
    @Path("/token")
    public String createToken(@FormParam("salt") final String salt,
            @FormParam("login") final String login,
            @FormParam("hash") final String hash) {
        return null;
    }
    
    private User getAccountByToken(String authToken) {

        //todo Use MemCache to cache this
        AuthToken savedToken = getBusiness().getAuthToken(authToken);
        if (savedToken == null) return null;
        User user = getBusiness().findById(savedToken.getAccountID());
        if (user == null) return null;

        return user;
    }
}

/**
 * private static final Logger log = Logger.getLogger(AuthService.class.getName());

    private static ThreadLocal<String> tlAuthToken = new ThreadLocal<String>();
    private static ThreadLocal<LeanAccount> tlLeanAccount = new ThreadLocal<LeanAccount>();

    public static void startAuthSession(String token) {
        LeanAccount user = getAccountByToken(token);
        tlAuthToken.set(token);
        tlLeanAccount.set(user);
    }

    public static void finishAuthSession() {
        tlLeanAccount.remove();
        tlAuthToken.remove();
    }

    public static AuthToken createMockFacebookAccount(String email) {
        if(!ServerUtils.isDevServer()){
            throw new IllegalStateException("Method 'createMockFacebookAccount(email)' should only be called while running Dev Server.");
        }

        LeanAccount account = AccountUtils.findAccountByEmail(email, "fb-oauth");
        if (account == null) {
            //todo this is one-to-one mapping between Account and User
            //change this in the future

            Map<String, Object> props = new HashMap<String, Object>(1);
            props.put("email", email);

            // account does not yet exist - create it
            account = new LeanAccount(
                    0,
                    email,
                    UUID.randomUUID().toString(),
                    "fb-oauth",
                    props);
            AccountUtils.saveAccount(account);
        }

        // create our own authentication token
        // todo retrieve existing token if not expired
        return AuthService.createAuthToken(account.id);
    }

    private static LeanAccount getAccountByToken(String authToken) {

        //todo Use MemCache to cache this
        AuthToken savedToken = AccountUtils.getAuthToken(authToken);
        if (savedToken == null) return null;
        LeanAccount user = AccountUtils.getAccount(savedToken.accountID);
        if (user == null) return null;

        return user;
    }

    public static void resetCurrentAuthData() {
        String token = tlAuthToken.get();
        if (token != null) AccountUtils.removeAuthToken(token);
        tlLeanAccount.remove();
        tlAuthToken.remove();
    }

    public static AuthToken createAuthToken(long accountID) {
        AuthToken authToken = new AuthToken(accountID);
        AccountUtils.saveAuthToken(authToken);
        return authToken;
    }

    public static LeanAccount getCurrentAccount() {
        return tlLeanAccount.get();
    }

    public static boolean isUserLoggedIn() {
        return tlAuthToken.get() != null;
    }
 */