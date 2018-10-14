package com.rvia.project.controller;

import com.rvia.project.controller.util.JsfUtil;
import com.rvia.project.ejb.CapacitacionFacade;
import com.rvia.project.ejb.ExperienciaLaboralFacade;
import com.rvia.project.ejb.PostulanteCapacitacionFacade;
import com.rvia.project.ejb.PostulanteCompetenciaFacade;
import com.rvia.project.ejb.PostulanteExperienciaFacade;
import com.rvia.project.ejb.PostulanteFacade;
import com.rvia.project.ejb.PostulanteIdiomaFacade;
import com.rvia.project.ejb.UsuarioFacade;
import com.rvia.project.entities.Capacitacion;
import com.rvia.project.entities.Competencia;
import com.rvia.project.entities.ExperienciaLaboral;
import com.rvia.project.entities.Idioma;
import com.rvia.project.entities.NivelEducacional;
import com.rvia.project.entities.Postulante;
import com.rvia.project.entities.PostulanteCapacitacion;
import com.rvia.project.entities.PostulanteCompetencia;
import com.rvia.project.entities.PostulanteExperiencia;
import com.rvia.project.entities.PostulanteIdioma;
import com.rvia.project.entities.TipoUsuario;
import com.rvia.project.entities.Usuario;
import java.io.Serializable;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/*
 *
 * @author clear
 */

@Named(value = "candidatoController")
@SessionScoped
public class CandidatoController implements Serializable{
       
    @EJB
    private PostulanteFacade ebjPostulanteFacade;
    
    @EJB
    private PostulanteIdiomaFacade ejbPostulanteIdiomaFacade;
    
    @EJB
    private PostulanteCompetenciaFacade ejbPostulanteCompetenciaFacade;
    
    
    @EJB
    private CapacitacionFacade ejbCapacitacionFacade;

    @EJB
    private PostulanteCapacitacionFacade ejbPostulanteCapacitacionFacade;
    
    
    @EJB
    private ExperienciaLaboralFacade ejbExperienciaLaboralFacade;
    
    @EJB
    private PostulanteExperienciaFacade ejPostulanteExperienciaFacade;
    
    
    @EJB
    private UsuarioFacade ejUsuarioFacade;
    
    
    Postulante postulante;
    PostulanteIdioma postulanteIdioma;
    PostulanteCompetencia postulanteCompetencia;
    PostulanteCapacitacion postulanteCapacitacion;
    PostulanteExperiencia postulanteExperiencia;
 
    
    NivelEducacional nivelEducacional;
    Capacitacion capacitacion;
    ExperienciaLaboral experienciaLaboral;
    Usuario usuario;
    
    Idioma idiomas[];   
    Competencia competencia[];
   // Capacitacion capacitacionList[];
    
    String email;
    
            
    @PostConstruct
    public void init(){
        postulanteIdioma = new PostulanteIdioma();
        postulanteCompetencia = new PostulanteCompetencia();
        postulanteCapacitacion = new PostulanteCapacitacion();
        postulanteExperiencia = new PostulanteExperiencia();
    }
      
    public Postulante getSelectedPostulante(){
        if(postulante == null){
            postulante = new Postulante();
    }
      return postulante;
    }

    
    public PostulanteIdioma getPostulanteIdioma(){
        if(postulanteIdioma == null){
            postulanteIdioma = new PostulanteIdioma();
        }
        return postulanteIdioma;
    }

    public Usuario getUsuario() {
        if(usuario == null){
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPostulanteIdioma(PostulanteIdioma postulanteIdioma) {
        this.postulanteIdioma = postulanteIdioma;
    }
    
    public Postulante getPostulante() {
        if(postulante == null){
            postulante = new Postulante();
        }
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public PostulanteCompetencia getPostulanteCompetencia() {
        if(postulanteCompetencia == null){
            postulanteCompetencia = new PostulanteCompetencia();

        }
        return postulanteCompetencia;
    }

    public void setPostulanteCompetencia(PostulanteCompetencia postulanteCompetencia) {
        this.postulanteCompetencia = postulanteCompetencia;
    }
   
      public Idioma[] getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idioma[] idiomas) {
        this.idiomas = idiomas;
    } 

    public Competencia[] getCompetencia() {    
        return competencia;
    }

    public void setCompetencia(Competencia[] competencia) {
        this.competencia = competencia;
    }

//    public void setCapacitacion(Capacitacion[] capacitacion) {
//        this.capacitacionList = capacitacion;
//    }

    public NivelEducacional getNivelEducacional() {
        return nivelEducacional;
    }

    public void setNivelEducacional(NivelEducacional nivelEducacional) {
        this.nivelEducacional = nivelEducacional;
    }

    public Capacitacion getCapacitacion() {
        if(capacitacion == null){
            capacitacion = new Capacitacion();
        }
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public PostulanteCapacitacion getPostulanteCapacitacion() {
        if(postulanteCapacitacion == null){
            postulanteCapacitacion = new PostulanteCapacitacion();
        }
        return postulanteCapacitacion;
    }

    public void setPostulanteCapacitacion(PostulanteCapacitacion postulanteCapacitacion) {
        this.postulanteCapacitacion = postulanteCapacitacion;
    }

    public ExperienciaLaboral getExperienciaLaboral() {
        if(experienciaLaboral == null){
            experienciaLaboral = new ExperienciaLaboral();
            
        }
        return experienciaLaboral;
    }

    public void setExperienciaLaboral(ExperienciaLaboral experienciaLaboral) {
        this.experienciaLaboral = experienciaLaboral;
    }

    public ExperienciaLaboralFacade getEjbExperienciaLaboralFacade() {
        return ejbExperienciaLaboralFacade;
    }

    public void setEjbExperienciaLaboralFacade(ExperienciaLaboralFacade ejbExperienciaLaboralFacade) {
        this.ejbExperienciaLaboralFacade = ejbExperienciaLaboralFacade;
    }
    
    
  
    public void crearCandidato(){
        try {
            postulante.setEmail(email);
            ebjPostulanteFacade.create(postulante);
            ejbCapacitacionFacade.create(capacitacion); 
            ejbExperienciaLaboralFacade.create(experienciaLaboral);
            
               
            for(int i = 0; i <= (getIdiomas().length - 1); i++){
                postulanteIdioma.setIdIdioma(new Idioma(idiomas[i].getId()));
                postulanteIdioma.setIdPostulante(new Postulante(postulante.getId()));
                ejbPostulanteIdiomaFacade.create(postulanteIdioma);
            }
           
            for(int i = 0; i <= (getCompetencia().length - 1); i++){
                postulanteCompetencia.setIdCompetencia(new Competencia(competencia[i].getId()));
                postulanteCompetencia.setIdPostulante(new Postulante(postulante.getId()));
                ejbPostulanteCompetenciaFacade.create(postulanteCompetencia);
            }
            
              postulanteCapacitacion.setIdCapacitacion(new Capacitacion(capacitacion.getId()));
              postulanteCapacitacion.setIdPostulante(new Postulante(postulante.getId()));
              ejbPostulanteCapacitacionFacade.create(postulanteCapacitacion);
              
              postulanteExperiencia.setIdExperiencia(new ExperienciaLaboral(experienciaLaboral.getId()));
              postulanteExperiencia.setIdPostulante(new Postulante(postulante.getId()));
              ejPostulanteExperienciaFacade.create(postulanteExperiencia);
              
              
              usuario.setEmail(email);
              usuario.setIdNombre(new TipoUsuario("POSTULANTE"));
              ejUsuarioFacade.create(usuario);      
            
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PostulanteCreated"));
            
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, "Postulante no creadoe"+ e);
        } 
    }  
}
