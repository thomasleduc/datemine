package com.epita.mti.datemine.DAO;

import com.epita.mti.datemine.Entity.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * The User Data Access Object
 * @author leduc_t
 */
@RequestScoped
@Named
public class UserDAO extends AbstractDAO<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
