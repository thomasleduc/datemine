/*
 * This project was made in school by Thomas LEDUC.
 * To resuse it you have to get the Antoine Dumeige's permission
 * his professor in this project.
 */

package com.epita.mti.datemine.data.Business;

import com.epita.mti.datemine.data.DAO.AbstractDAO;
import com.epita.mti.datemine.data.Entity.AbstractEntity;
import com.epita.mti.datemine.tools.RESTError;
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
     * Check if the entity is OK to add in database
     * Caution it doesn't check the persist error like constrains.
     * @param entity
     * @return null if it's OK, else a rest error.
     */
    public abstract RESTError checkBeforeAdding(T entity);

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
    public T findById(final Long id) {
        return getDao().findById(id);
    }

    /**
     * Push the entity.
     * @param entity The entity to push.
     * @return If the user 
     */
    public T persist(final T entity) {
        return getDao().persist(entity);
    }

    /**
     * @param str The string to test.
     * @param min The minimum length.
     * @param max The maximum length.
     * @return if the length of the string is between min and max parameter.
     */
    protected static Boolean lenghtBetween(final String str, int min, int max) {
        return (str.length() >= min) && (str.length() <= max);
    }
}