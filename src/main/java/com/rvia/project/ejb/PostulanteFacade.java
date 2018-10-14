package com.rvia.project.ejb;

import com.rvia.project.entities.Postulante;
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
public class PostulanteFacade extends AbstractFacade<Postulante> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostulanteFacade() {
        super(Postulante.class);
    }
    
    public Postulante userIdEmail(String email){
        Postulante postulante = null;
        String consulta;
        try {
            consulta = "FROM Postulante u WHERE u.email = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, email);
            
            List<Postulante> listPostulante = query.getResultList();
            
            if(!listPostulante.isEmpty()){
                postulante = listPostulante.get(0);
            }   
        } catch (Exception e) {
            throw  e;
        }
        return postulante;
    }  
    
    public boolean cedula(String cedula){
        String consulta;
        try {
            consulta = "FROM Postulante u WHERE u.cedula = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, cedula);
            
            List<Postulante> listPostulante = query.getResultList();
            
            if(!listPostulante.isEmpty()){
                return false;
            }   
        } catch (Exception e) {
            throw  e;
        } 
       return true;
    }
    
    public boolean emailPostulante(String email){
         String consulta;
        try {
            consulta = "FROM Postulante u WHERE u.email = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, email);
            
            List<Postulante> listPostulante = query.getResultList();
            
            if(!listPostulante.isEmpty()){
                return true;
            }   
        } catch (Exception e) {
            throw  e;
        }     
     return false;   
    }  
}
