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
public enum Error {
    USER_LOGIN_TOO_SHORT("user_login_too_short", "The user login is too short"),
    USER_LOGIN_TOO_LONG("user_login_too_long", "The user login is too long"),
    USER_EMAIL_BAD_FORMAT("user_email_bad_format", "The user email is not correct");

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
    Error (String name, String description) {
        this.name = name;
        this.description = description;
    }
}
