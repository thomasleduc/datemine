package com.epita.mti.datemine;

import com.epita.mti.datemine.api.service.AbstractRESTService;
import com.epita.mti.datemine.api.service.UserRESTService;
import com.epita.mti.datemine.tools.ResponseCorsFilter;
import java.util.HashSet;
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
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(AbstractRESTService.class);
        resources.add(UserRESTService.class);
        resources.add(ResponseCorsFilter.class);
        return resources;
    }
}
