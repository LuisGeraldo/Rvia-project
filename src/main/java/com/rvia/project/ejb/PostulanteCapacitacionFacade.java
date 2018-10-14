package com.rvia.project.ejb;


import com.rvia.project.entities.Postulante;
import com.rvia.project.entities.PostulanteCapacitacion;
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
public class PostulanteCapacitacionFacade extends AbstractFacade<PostulanteCapacitacion> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostulanteCapacitacionFacade() {
        super(PostulanteCapacitacion.class);
    }
     
    public PostulanteCapacitacion postulanteCapacitacion(int id){
        PostulanteCapacitacion userCap = null;
        String consulta;
        
        try {
            
            consulta = "FROM PostulanteCapacitacion u WHERE u.idPostulante = ?1";
            Query query = em.createQuery(consulta);
            
            query.setParameter(1, new Postulante(id));
            
            List<PostulanteCapacitacion> listUserCap = query.getResultList();
            
            if(!listUserCap.isEmpty()){
                userCap = listUserCap.get(0);
            }
            
        } catch (Exception e) {
            throw  e;   
        }
         return userCap;
    }
    
}
