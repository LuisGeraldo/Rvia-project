package com.rvia.project.controller;

import com.rvia.project.controller.util.SessionReference;
import com.rvia.project.entities.Usuario;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author clear
 */

@Named
@ViewScoped

public class controlAccesoClass implements Serializable{
    SessionReference reference;
    Usuario user;
  
    public void onlyAdmin() {
        try {
           reference = new SessionReference();
           user = new Usuario();
           
           user = (Usuario) reference.sessionMapGet("usuario");
           
           if(user == null || !user.getIdNombre().getIdNombre().equals("ADMIN")){
               reference.getFacesContext().getExternalContext().redirect("./../../../acceso/login.xhtml");
           }   
           
        } catch (Exception e) {
            
        }
    }
     
    public void onlyPostulante(){
        try {
           reference = new SessionReference();
           user = new Usuario();
           
           user = (Usuario) reference.sessionMapGet("usuario");
           
           if(user == null || !user.getIdNombre().getIdNombre().equals("POSTULANTE")){
               reference.getFacesContext().getExternalContext().redirect("./../acceso/login.xhtml");
           }   
           
           
        } catch (Exception e) {
            
        }
    }    
          
    public void onlyEmpleado(){
        try {
           reference = new SessionReference();
           user = new Usuario();
           
           user = (Usuario) reference.sessionMapGet("usuario");
           
           if(user == null || !user.getIdNombre().getIdNombre().equals("EMPLEADO")){
                reference.getFacesContext().getExternalContext().redirect("./../acceso/login.xhtml");
           }   
           
        } catch (Exception e) {
            
        }
    }    
               
    public void cerraSesion(){           
          
        try {
           reference = new SessionReference();    
           reference.sessionMapGetRemove("usuario");
           
        } catch (Exception e) {
           
        }
    }   
}
