package com.epita.mti.datemine.data.DAO.tools;

/**
 *
 * @author leduc_t
 */
public class UserNotFoundException extends Exception {
    
    public UserNotFoundException() {
        super("User not found in JPA request.");
    }
    
    public UserNotFoundException(String message) {
        super(message);
    }
}
