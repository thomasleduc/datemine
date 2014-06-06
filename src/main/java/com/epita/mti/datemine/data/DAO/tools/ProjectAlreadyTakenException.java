/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine.data.DAO.tools;

/**
 *
 * @author leduc_t
 */
public class ProjectAlreadyTakenException extends Exception {
    
    public ProjectAlreadyTakenException() {
        super("The project is already taken by the user.");
    };
    
    public ProjectAlreadyTakenException(String message) {
        super(message);
    };
    
}
