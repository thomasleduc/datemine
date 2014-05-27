package com.epita.mti.datemine;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author leduc_t
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
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        //resources.add(com.epita.mti.datemine.api.service.AbstractRESTService.class);
        resources.add(com.epita.mti.datemine.api.service.AbstractRESTService.class);
        resources.add(com.epita.mti.datemine.api.service.AuthService.class);
        resources.add(com.epita.mti.datemine.api.service.UserRESTService.class);
        resources.add(com.epita.mti.datemine.tools.ResponseCorsFilter.class);
        return resources;
    }
}
