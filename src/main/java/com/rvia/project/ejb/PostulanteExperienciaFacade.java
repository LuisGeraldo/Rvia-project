package com.rvia.project.ejb;

import com.rvia.project.entities.Postulante;
import com.rvia.project.entities.PostulanteExperiencia;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author clear
 */
@Stateless
public class PostulanteExperienciaFacade extends AbstractFacade<PostulanteExperiencia> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostulanteExperienciaFacade() {
        super(PostulanteExperiencia.class);
    }
    
    public PostulanteExperiencia postulanteExperienciaLaboral(int id){
        PostulanteExperiencia userEx = null;
        String consulta;
        
        try {
            
            consulta = "FROM PostulanteExperiencia u WHERE u.idPostulante = ?1";
            Query query = em.createQuery(consulta);
            
            query.setParameter(1, new Postulante(id));
            
            List<PostulanteExperiencia> listUserExp = query.getResultList();
            
            if(!listUserExp.isEmpty()){
                userEx = listUserExp.get(0);
            }
            
        } catch (Exception e) {
            throw  e;   
        }
         return userEx;
    }
}