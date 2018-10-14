package com.rvia.project.controller;

import com.rvia.project.controller.util.SessionReference;
import com.rvia.project.ejb.UsuarioFacade;
import com.rvia.project.entities.Usuario;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
/**
 *
 * @author clear
 */
@Named(value = "loginController")
@RequestScoped
public class LoginController {
    
    @EJB
    private UsuarioFacade EJBUsuarioFacade;
    
    Usuario usuario;
    SessionReference reference;

    @PostConstruct
    public void init(){
        usuario = new Usuario();
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
    
    public void iniciarSesion(){
        Usuario user;
        
        try {
            reference = new SessionReference();
            user = EJBUsuarioFacade.iniciarSesion(usuario);

                switch (user.getIdNombre().getIdNombre()) {
                    
                case "ADMIN":   
                    reference.sessionMapPut("usuario", user);
                    reference.getFacesContext().getExternalContext().redirect("../admin/index/adminDash/indexAdmin.xhtml");  
                    break;
                    
                case "EMPLEADO":
                      reference.sessionMapPut("usuario", user); 
                      reference.navigationHandlerRedirect("/view/empleado/indexEmpleado");   
                    break;
                    
                case "POSTULANTE":     
                    reference.sessionMapPut("usuario", user);    
                    reference.navigationHandlerRedirect("/view/postulante/indexPostulante");          
                    break;
                   
                default:   
                    reference.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Credenciales incorrectas", "error"));
                    break;      
              } 
           } catch (Exception e) {          
                    reference.getFacesContext().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales incorrectas", "error"));
        }
    }
}
