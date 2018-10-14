package com.rvia.project.ejb;

import com.rvia.project.entities.Usuario;
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
public class UsuarioFacade extends AbstractFacade<Usuario>{

    @PersistenceContext(unitName = "com.rvia.project_rvia-project_war_version-1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario iniciarSesion(Usuario usuario) {
        Usuario user = null;
        String consulta;
        
        try {
            consulta = "FROM Usuario u WHERE u.email = ?1 and u.pass  = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, usuario.getEmail());
            query.setParameter(2, usuario.getPass());
            
            
            List<Usuario> listUser = query.getResultList();
            
            if(!listUser.isEmpty()){
                user = listUser.get(0);
            }
            
        } catch (Exception e) {
            throw  e;   
        }
         return user;
    }  
    
    public Usuario userToEmail(String email) {
        Usuario user = null;
        String consulta;
        
        try {
            consulta = "FROM Usuario u WHERE u.email = ?1";
            Query query = em.createQuery(consulta);
            query.setParameter(1, email);
            
            List<Usuario> listUser = query.getResultList();
            
            if(!listUser.isEmpty()){
                user = listUser.get(0);
            }
            
        } catch (Exception e) {
            throw  e;   
        }
         return user;
    } 
}
