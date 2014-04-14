package com.epita.mti.datemine;

import javax.faces.context.FacesContext;

/**
 *
 * @author leduc_t
 */
public class JSFUtil {
    public static void addMessage(String message) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        //ctx.addMessage(message,);
    }
}
