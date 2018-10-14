package com.rvia.project.ejb;

import com.rvia.project.entities.Empleado;
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
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }
    
     public Empleado userIdEmail(String email){
        Empleado empleado = null;
        String consulta;
        try {
            consulta = "FROM Empleado u WHERE u.email = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, email);
            
            List<Empleado> listEmpleado = query.getResultList();
            
            if(!listEmpleado.isEmpty()){
                empleado = listEmpleado.get(0);
            }   
        } catch (Exception e) {
            throw  e;
        }
        return empleado;
    }   
}
