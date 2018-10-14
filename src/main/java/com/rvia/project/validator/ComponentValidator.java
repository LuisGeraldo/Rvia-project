package com.rvia.project.validator;

import com.rvia.project.ejb.PostulanteFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author clear
 */
@Named(value = "componentValidator")
@RequestScoped
public class ComponentValidator implements Serializable{
    @EJB
    private PostulanteFacade ejPostulanteFacade;

    @PostConstruct
    public void init(){
        
    }
    
     public void validateCedula(FacesContext f, UIComponent c, Object value){
            String cedula = value.toString();
            if(!validarCedula(cedula)){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "La cedula es incorrecta", null));
            }
            
            if(!ejPostulanteFacade.cedula(cedula)){
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "La cedula esta en uso", null));
            }    
    }
     
     public void validateEmail(FacesContext f, UIComponent c, Object obj){
     String email = obj.toString();
     
        if(ejPostulanteFacade.emailPostulante(email)){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "El correo esta en uso", null));   
        } 
     }
     
     public static boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 11 || cedula.equals("00000000000")) {
            return false;
        }
        int suma = 0;
        int division = 0;
        String peso = "1212121212";
        for (int i = 0; i < 10; i++) {
            int mul = (cedula.charAt(i) - '0') * (peso.charAt(i) - '0');
            while (mul > 0) {
                suma += mul % 10;
                mul /= 10;
            }
        }
        division = (suma / 10) * 10;
        if (division < suma) {
            division += 10;
        }
        int digito = division - suma;
        if (digito != cedula.charAt(10) - '0') {
            return false;
        }
        return true;
    }    
}
