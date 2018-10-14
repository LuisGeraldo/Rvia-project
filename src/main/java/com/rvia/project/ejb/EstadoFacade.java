package com.rvia.project.ejb;

import com.rvia.project.entities.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clear
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoFacade() {
        super(Estado.class);
    }
    
}
