/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.tools;

import lombok.Getter;
import lombok.Setter;

/**
 * @author leduc_t
 */
public enum RESTError {
    BAD_PARAMETER(405, "bad_parameter", "The parameter are malformated"),
    LOGIN_TOO_SHORT(405, "login_too_short", "The login is too short"),
    LOGIN_TOO_LONG(405, "login_too_long", "The login is too long"),
    EMAIL_BAD_FORMAT(405, "email_bad_format", "The email is not correct");

    /**
     * The HTTP Error code.
     */
    @Getter @Setter private int HTTPErrorCode;
    /**
     * The error short name (for JAVASCRIPT management).
     */
    @Getter @Setter private String name;
    /**
     * The full description of the error.
     */
    @Getter @Setter private String description;
    
    /**
     * The two parameters and only constructor
     * which normally has never to be used.
     * @param name
     * @param description 
     */
    RESTError (int code, String name, String description) {
        this.HTTPErrorCode = code;
        this.name = name;
        this.description = description;
    }
}
