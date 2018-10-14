package com.rvia.project.controller;

import com.rvia.project.controller.util.SessionReference;
import com.rvia.project.ejb.EmpleadoFacade;
import com.rvia.project.entities.Empleado;
import com.rvia.project.entities.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author clear
 */

@Named(value = "sessionEmpleado")
@RequestScoped
public class SessionEmpleado implements Serializable{
    SessionReference reference;
    Usuario usuario;
    Empleado empleado;
    
    @EJB
    private EmpleadoFacade ejEmpleadoFacade;
    
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        empleado = new Empleado();
    }
    
    public SessionEmpleado() {
    
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public void infoUser(){   
        try {
            reference = new SessionReference();
            usuario = (Usuario) reference.sessionMapGet("usuario");
          
        } catch (Exception e) {
            throw  e;    
        }      
    }
    
    public void infoEmpleado(){
        try {
            reference = new SessionReference();
            usuario = (Usuario) reference.sessionMapGet("usuario");
            empleado = ejEmpleadoFacade.userIdEmail(usuario.getEmail()); 
                 
        } catch (Exception e) {
            throw  e;    
        }  
    }  
}
