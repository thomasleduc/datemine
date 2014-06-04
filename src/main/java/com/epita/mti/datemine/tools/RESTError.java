/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.tools;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import lombok.Getter;
import lombok.Setter;

/**
 * @author leduc_t
 */
public enum RESTError {
    BAD_PARAMETER(Status.NOT_ACCEPTABLE, "bad_parameter"),
    NOT_FOUND(Status.NOT_FOUND, "entity_not_found"),
    LOGIN_TOO_SHORT(Status.NOT_ACCEPTABLE, "login_too_short"),
    LOGIN_TOO_LONG(Status.NOT_ACCEPTABLE, "login_too_long"),
    EMAIL_BAD_FORMAT(Status.NOT_ACCEPTABLE, "email_bad_format"),
    PROJECT_NAME_LENGTH(Status.NOT_ACCEPTABLE, "project_name_length");

    /**
     * The error response builder.
     */
    @Getter @Setter private ResponseBuilder response;

    /**
     * The two parameters and only constructor
     * which normally has never to be used.
     * @param code
     * @param message
     */
    RESTError (Status code, String message) {
        this.response = Response.status(code).entity(getJsonMessage(message));
    }

    private static String getJsonMessage(String message) {
        StringBuilder ret = new StringBuilder("{\"message\":\"");
        ret.append(message);
        ret.append("\"}");

        return ret.toString();
    }
}
