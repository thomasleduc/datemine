package com.epita.mti.datemine.api.service;

import com.epita.mti.datemine.data.Business.AbstractBusiness;
import com.epita.mti.datemine.data.DAO.AbstractDAO;
import com.epita.mti.datemine.data.Entity.AbstractEntity;
import com.epita.mti.datemine.tools.RESTError;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

/**
 *
 * @author leduc_t
 * @param <S> The Business
 * @param <D> The DAO
 * @param <T> The Entity
 */
public abstract class AbstractRESTService<S extends AbstractBusiness<D, T>,
 D extends AbstractDAO<T>,
 T extends AbstractEntity> {

    /**
     * Get the service used by this provider.
     * @return The service used by this provider ...
     */
    public abstract S getBusiness();

    /**
     * Get the entity class name in String format for the command parsing.
     * @return The Element Name in String format.
     */
    public String getElementName() {
        return getBusiness().getDao().getEntityClass().getSimpleName().toLowerCase();
    }

    /**
     * Get the entity into a JSON String.
     * @param <T> The type of the entity.
     * @param entity The entity to transform in JSON String.
     * @return A String containing the entity in JSON Format.
     */
    public static <T> String entityToJson(T entity) {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String result = "Failed in entityToJson";
        try {
            result = ow.writeValueAsString(entity);
        } catch (IOException ex) {
            Logger.getLogger(AbstractRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    /**
     * @return All the entity in toString mode.
     */
    public String getListString() {
        StringBuilder strB = new StringBuilder();
        for(T entity : getBusiness().findAll()) {
            strB.append(entity.asCSV());
        }
        return strB.toString();
    }

    /**
     * @return All the entity in JSON list.
     */
    public String getJsonListString() {
        StringBuilder strB = new StringBuilder("[");
        String separator = "";
        for (T entity : getBusiness().findAll()) {
            strB.append(separator);
            strB.append(entityToJson(entity));
            separator = ",";
        }
        strB.append("]");
        return strB.toString();
    }
    
    @GET
    @Path("/list")
    public String list() {
        Logger.getLogger(getElementName()).log(Level.INFO, null, "list acess");
        return getListString();
    }
    
    @GET
    @Path("/list-json")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<T> findAll() {
        Logger.getLogger(getElementName()).log(Level.INFO, null, "list json");
        return getBusiness().findAll();
    }

    @PUT
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(T entity) {
        Logger.getLogger(getElementName()).log(Level.INFO, null, "add");
        
        RESTError err = getBusiness().checkBeforeAdding(entity);
        
        if (err != null)
            return err.getResponse().build();
        
        return Response.ok(entity, MediaType.APPLICATION_JSON).build();
    }

}
