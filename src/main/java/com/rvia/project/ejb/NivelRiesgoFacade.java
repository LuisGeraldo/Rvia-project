package com.rvia.project.ejb;

import com.rvia.project.entities.NivelRiesgo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author clear
 */
@Stateless
public class NivelRiesgoFacade extends AbstractFacade<NivelRiesgo> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NivelRiesgoFacade() {
        super(NivelRiesgo.class);
    }
    
}
