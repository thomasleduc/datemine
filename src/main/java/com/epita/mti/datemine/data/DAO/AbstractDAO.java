package com.epita.mti.datemine.data.DAO;

import com.epita.mti.datemine.data.DAO.tools.FieldAccess;
import com.epita.mti.datemine.data.Entity.AbstractEntity;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 * The abstract class which defined the DAO level.
 * @author leduc_t
 * @param <T> The entity
 */
public abstract class AbstractDAO<T extends AbstractEntity> {

    /**
     * EntityManager inject by the CDI
     */
    @PersistenceContext(unitName = "com.epita.JPAUNIT")
    protected EntityManager em;

    /**
     * @return the class of Entity managed by this DAO
     */
    public abstract Class<T> getEntityClass();

    /**
     * @param id of the searched entity
     * @return the entity according the id
     */
    public T findById(final Long id) {
        return (T) em.find(getEntityClass(), id);
    }

    /**
     * @return a collection of all entity managed by the DAO.
     */
    public Collection<T> findAll() {

        // Construct the criteria query
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(getEntityClass());
        Root<T> rootEntry = cq.from(getEntityClass());
        CriteriaQuery<T> all = cq.select(rootEntry);
        TypedQuery<T> allQuery = em.createQuery(all);

        // get all entities
        return allQuery.getResultList();
    }

    /**
     * Push the entity.
     * @param entity The entity to push.
     * @return if everything all right.
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Boolean persist(final T entity) {
        try {
            em.persist(entity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    /**
     * Same as getUser but faster because we just ask for a boolean.
     * @param column The SQL column to test
     * @param value The value to test
     * @return if a user exist in database with the login.
     */
    public Boolean exist(FieldAccess column, String value) {
        StringBuilder q = new StringBuilder("SELECT TRUE FROM ");
        q.append(getEntityClass().getName());
        q.append(" t WHERE t.");
        q.append(column);
        q.append(" = ?1");

        Query query = em.createQuery(q.toString());
        query.setParameter(1, value);

        return !query.getResultList().isEmpty();
    }
    
    /**
     * Return an entity of a query, to avoid the NoResultException of
     * query.getSingleResult that is easy to catch.
     * @param query The sql query that return an entity or null.
     * @return The entity.
     */
    public T getSingleResult(TypedQuery<T> query) {
        List<T> results = query.getResultList();
        if(!results.isEmpty()){
            // ignores multiple results
            return (T) results.get(0);
        }
        return null;
    }
}
