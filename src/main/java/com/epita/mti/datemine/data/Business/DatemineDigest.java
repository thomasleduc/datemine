/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.Business;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbookpro
 */
public class DatemineDigest {
    /**
     * The class logger.
     */
    private final static Logger log = Logger.getLogger(DatemineDigest.class.getName());
    /**
     * The hash salt.
     */
    private final static String SALT = "MoNpApAaMoIeStUnGaNgStEr";

    public static Boolean compare(final String str, final String encodedStr) {
        try {
            return (pencode(str).equals(encodedStr));
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(DatemineDigest.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * The public encoder (see the private for more informations).
     * @param str ...
     * @return  ...
     */
    public static String encode(final String str) {
        try {
            return pencode(str);
        } catch (NoSuchAlgorithmException ex) {
            log.log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Return a SHA256(str + salt).
     * @param str The source string.
     * @return The string encoded.
     * @throws NoSuchAlgorithmException 
     */
    private static String pencode(final String str) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update((SALT + str).getBytes());
        byte messageDigest[] = sha.digest();

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < messageDigest.length; i++) {
                buffer.append(Integer.toHexString(0xFF & messageDigest[i]));
        }
        return buffer.toString();
    }
}
