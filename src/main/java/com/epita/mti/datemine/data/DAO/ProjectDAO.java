package com.epita.mti.datemine.data.DAO;

import com.epita.mti.datemine.data.Entity.Project;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author leduc_t
 */
public class ProjectDAO extends AbstractDAO<Project> {

    @Override
    public Class<Project> getEntityClass() {
        return Project.class;
    }
    
    public List<Project> searchProjectListWithPrefix(String prefix) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root e = cq.from(Project.class);
        cq.where(cb.equal(e.get("name"), createPrefix(prefix)));

        TypedQuery<Project> query = em.createQuery(cq);
        return query.getResultList();
    }
    
    private String createPrefix(String prefix) {
        StringBuilder strB = new StringBuilder(prefix);
        return strB.append("%").toString();
    }

    public List<Project> getProjects(long userId, int minRight) {

        Query query = em.createNativeQuery("{call getProjectsFromUser(?,?)}",
                                   Project.class)
                                   .setParameter(1, userId)
                                   .setParameter(2, minRight);
        return query.getResultList();
    }
}
