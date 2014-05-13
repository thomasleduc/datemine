/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.tools.auth;

import java.util.UUID;

/**
 * @author leduc_t
 */
public class AuthToken {

    /**
     * The token string.
     */
    private String token;
    /**
     * The account id.
     */
    private long accountID = 0;
    /**
     * The creation time in millisecond.
     */
    private long timeCreated;

    public AuthToken(long accountID) {
        this.accountID = accountID;
        this.token = UUID.randomUUID().toString();
        this.timeCreated = System.currentTimeMillis();
    }

    public AuthToken(String token, long accountID, long timeCreated) {
        this.token = token;
        this.accountID = accountID;
        this.timeCreated = timeCreated;
    }
    
    public String getToken() {
        return token;
    }
    
    public long getAccountID() {
        return accountID;
    }
    
    public long getTimeCreated() {
        return timeCreated;
    }
}
