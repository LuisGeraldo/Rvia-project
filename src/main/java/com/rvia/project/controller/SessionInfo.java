package com.rvia.project.controller;

import com.rvia.project.controller.util.SessionReference;
import com.rvia.project.ejb.PostulanteCapacitacionFacade;
import com.rvia.project.ejb.PostulanteExperienciaFacade;
import com.rvia.project.ejb.PostulanteFacade;
import com.rvia.project.entities.Postulante;
import com.rvia.project.entities.PostulanteCapacitacion;
import com.rvia.project.entities.PostulanteExperiencia;
import com.rvia.project.entities.PostulanteIdioma;
import com.rvia.project.entities.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author clear
 */

@Named(value = "sessionInfo")
@SessionScoped
public class SessionInfo implements Serializable {
    SessionReference reference;
    Usuario usuario;
    Postulante postulante;
    PostulanteExperiencia experienciaLaboral;
    PostulanteCapacitacion postulanteCapacitacion;
    PostulanteIdioma postulanteIdioma[];

    @EJB
    private PostulanteFacade ejbPostulateFacade;
    
    @EJB
    private PostulanteExperienciaFacade ejbPostulanteExperienciaFacade;
  
    @EJB
    private PostulanteCapacitacionFacade ejbPostulanteCapacitacionFacade;
    
  
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        postulante = new Postulante();  
        experienciaLaboral = new PostulanteExperiencia();
        postulanteCapacitacion = new PostulanteCapacitacion();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    } 

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public PostulanteExperiencia getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(PostulanteExperiencia experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public PostulanteCapacitacion getPostulanteCapacitacion() {
        return postulanteCapacitacion;
    }

    public void setPostulanteCapacitacion(PostulanteCapacitacion postulanteCapacitacion) {
        this.postulanteCapacitacion = postulanteCapacitacion;
    }
    
    public void infoUser(){   
        try {
            reference = new SessionReference();
            usuario = (Usuario) reference.sessionMapGet("usuario");
          
        } catch (Exception e) {
            throw  e;    
        }      
    }
    
    public void infoPostulante(){
        try {
            reference = new SessionReference();
            usuario = (Usuario) reference.sessionMapGet("usuario");
            postulante = ejbPostulateFacade.userIdEmail(usuario.getEmail()); 
            infoPostulanteSession(postulante.getId());
            
            
        } catch (Exception e) {
            throw  e;    
        }  
    }
       
    public void infoPostulanteSession(int id){
        try { 
            experienciaLaboral = ejbPostulanteExperienciaFacade.postulanteExperienciaLaboral(id); 
            postulanteCapacitacion = ejbPostulanteCapacitacionFacade.postulanteCapacitacion(id);
            
        } catch (Exception e) {
            throw  e;    
        }  
    }
}
