package com.epita.mti.datemine.tools.auth;

import com.epita.mti.datemine.tools.Role;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * @author leduc_t
 */
@Target(value = { TYPE, METHOD })
@Retention(value = RUNTIME)
public @interface AuthRequire {
    /**
     * @return The Minimum authorization level.
     */
    Role minLevel();
}
