package com.epita.mti.datemine;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author macbookpro
 */
@ApplicationPath("/api")
public class API extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return getRestResourceClasses();
    }

    /**
     * Get the Rest resource classes.
     * @return the rest resource classes
     */
    private Set<Class<?>> getRestResourceClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        return resources;
    }
}
