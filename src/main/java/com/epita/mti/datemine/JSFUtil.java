/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.epita.mti.datemine;

import javax.faces.context.FacesContext;

/**
 *
 * @author macbookpro
 */
public class JSFUtil {
    public static void addMessage(String message) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        //ctx.addMessage(message,);
    }
}
