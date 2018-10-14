package com.rvia.project.controller;

import com.rvia.project.controller.util.EnviarEmail;
import com.rvia.project.controller.util.JsfUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author clear
 */
@Named(value = "contactarController")
@RequestScoped
public class ContactarController implements Serializable{

    EnviarEmail mail;
    String asunto;
    String userEmail;
    String userPassword;
    String cuerpoMenssage;

    public EnviarEmail getMail() {
        return mail;
    }

    public void setMail(EnviarEmail mail) {
        this.mail = mail;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCuerpoMenssage() {
        return cuerpoMenssage;
    }

    public void setCuerpoMenssage(String cuerpoMenssage) {
        this.cuerpoMenssage = cuerpoMenssage;
    }
     
    @PostConstruct
    public void init(){
        /*
        *En esta parte, el segundo parametro y el ultimo son las credenciales de la cuenta de gmail 
        *La cuenta debe ser valida, para que pueda enviar el correo
        *Tambien la cuenta debe tener permitido el uso de aplicaciones externas (No seguras) activadas
        *
        **/
        mail = new EnviarEmail("Rvia, administracion", "ejemploCorreo@gmail.com", "lacontrasenaDelcorreo1234");
    }
    
    public void EnviarMensaje(String userEmail){
        try {
         mail.enviarCorreo(asunto, userEmail, userPassword,cuerpoMenssage);
         JsfUtil.addSuccessMessage("Mensaje enviado");
                
        } catch (Exception e) {
            JsfUtil.addErrorMessage("Mensaje no enviado " + e);
        }
    }  
}
