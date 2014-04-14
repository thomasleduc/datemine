/*
 * This project was made in school by Thomas LEDUC.
 * To resuse it you have to get the Antoine Dumeige's permission
 * his professor in this project.
 */

package com.epita.mti.datemine.Business;

import com.epita.mti.datemine.DAO.AbstractDAO;
import com.epita.mti.datemine.Entity.AbstractEntity;
import java.util.Collection;

/**
 * The Abstract class which defined the Business level.
 * @author leduc_t
 * @param <D> DAO used
 * @param <T> Entity used
 */
public abstract class AbstractBusiness
<D extends AbstractDAO<T>, T extends AbstractEntity> {

    /**
     * Get the DAO according to the Business class.
     * @return The DAO.
     */
    public abstract D getDao();

    /**
     * Find all the entities managed by the instance of the business class.
     * @return all the entities managed by the instance of the business class.
     */
    public Collection<T> findAll() {
        return getDao().findAll();
    }

    /**
     * Find the entity managed by the instance of the business class,
     * according to the <code>id</code>.
     * @param id The id of the entity
     * @return The entity.
     */
    public T findById(final Integer id) {
        return getDao().findById(id);
    }

    /**
     * Push the entity.
     * @param entity The entity to push.
     */
    public void persist(final T entity) {
        getDao().persist(entity);
    }

}
