package com.epita.mti.datemine.DAO;

import com.epita.mti.datemine.Entity.AbstractEntity;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * The abstract class which defined the DAO level.
 * @author leduc_t
 * @param <T> The entity
 */
public abstract class AbstractDAO<T extends AbstractEntity> {

    /**
     * Create an entity manager and return it.
     * @return The entityManager.
     */
    @PersistenceContext(unitName = "com.epita.JPAUNIT")
    private EntityManager em;

    /**
     * @return The entity manager property.
     */
    public final EntityManager getEntityManager() {
        return em;
    }

    /**
     * @return the class of Entity managed by this DAO
     */
    public abstract Class<T> getEntityClass();

    /**
     * @param id of the searched entity
     * @return the entity according the id
     */
    public T findById(final Integer id) {
        return (T) getEntityManager().find(getEntityClass(), id);
    }

    /**
     * @return a collection of all entity managed by the DAO.
     */
    public Collection<T> findAll() {

        // construct the criteria query
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
     */
    public void persist(final T entity) {
        EntityManager eM = getEntityManager();
        eM.getTransaction().begin();
        eM.persist(entity);
        eM.getTransaction().commit();
    }
}
