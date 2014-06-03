package com.epita.mti.datemine.data.DAO;

import com.epita.mti.datemine.data.Entity.User;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * The User Data Access Object.
 * @author leduc_t
 */
@RequestScoped
@Named
public class UserDAO extends AbstractDAO<User> {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    /**
     * Same as getUser but faster because we just ask for a boolean.
     * @param login
     * @return the user found or null.
     */
    public User getUser(String login) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(User.class);
        cq.where(cb.equal(e.get("login"), login));
        TypedQuery<User> query = em.createQuery(cq);
        //Query query = em.createQuery("SELECT u.id, u.email, u.login, u.passwd, u.creationDate FROM User u WHERE u.login = ?1");
        //query.setParameter(1, login);

        try {
            return (User) getSingleResult(query);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
}
