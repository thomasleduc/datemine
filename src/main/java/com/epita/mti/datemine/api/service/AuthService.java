/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.api.service;

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
public class AuthService {

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
}
