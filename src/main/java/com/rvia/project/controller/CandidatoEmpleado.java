package com.rvia.project.controller;

import com.rvia.project.controller.util.JsfUtil;
import com.rvia.project.ejb.EmpleadoFacade;
import com.rvia.project.ejb.PostulanteFacade;
import com.rvia.project.ejb.UsuarioFacade;
import com.rvia.project.entities.Departamento;
import com.rvia.project.entities.Empleado;
import com.rvia.project.entities.Estado;
import com.rvia.project.entities.Postulante;
import com.rvia.project.entities.Puesto;
import com.rvia.project.entities.TipoUsuario;
import com.rvia.project.entities.Usuario;
import java.io.Serializable;
import java.util.Calendar;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author clear
 */

@Named(value = "canditaEmpleado")
@RequestScoped

public class CandidatoEmpleado implements Serializable{
    
   @EJB
   private EmpleadoFacade ejbEmpleadoFacade;
   
   @EJB
   private PostulanteFacade ejbPostulanteFacade;
   
   @EJB
   private UsuarioFacade ejbUsuarioFacade;
           
   Empleado empleado;
   Postulante postulante;
   Usuario user;
   EmpleadoController empleadoController;
   int salario;
   
   Puesto puesto;
   Departamento departamento;
   Estado estado;
   
   
   @PostConstruct
   public void init(){
       empleado = new Empleado();
       postulante = new Postulante();
       user = new Usuario();
   }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public Puesto getPuesto() {
        if(puesto == null){
            puesto = new Puesto();
        }
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Departamento getDepartamento() {
        if(departamento == null){
            departamento = new Departamento();
        }
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Estado getEstado() {
        if(estado == null){
            estado = new Estado();
        }
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    public void toConvert(int id){   
       postulante = ejbPostulanteFacade.find(id);
       Calendar fechaActual = Calendar.getInstance();
     
       try {    
           empleado.setNombre(postulante.getNombre());
           empleado.setApellido(postulante.getApellido());
           empleado.setCedula(postulante.getCedula());
           empleado.setEmail(postulante.getEmail());
           empleado.setFechaIngreso(fechaActual.get(Calendar.DAY_OF_MONTH)+"/"+(fechaActual.get(Calendar.MONTH) + 1)+"/"+fechaActual.get(Calendar.YEAR));
           empleado.setSalario(salario);
           empleado.setIdPuesto(new Puesto(puesto.getId()));
           empleado.setIdDepartamento(new Departamento(departamento.getId()));
           empleado.setIdEstado(new Estado(estado.getId()));
           
           ejbEmpleadoFacade.create(empleado);
           
           ejbPostulanteFacade.remove(postulante);
           
           user = ejbUsuarioFacade.userToEmail(postulante.getEmail());
           user.setIdNombre(new TipoUsuario("EMPLEADO"));
           ejbUsuarioFacade.edit(user);
          
           JsfUtil.addSuccessMessage("Empleado creado");
           
       } catch (Exception e) {
           JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
       }
   } 
   
    public void refresh(){
     empleadoController = new EmpleadoController();
     empleadoController.prepareList();   
   }
}
