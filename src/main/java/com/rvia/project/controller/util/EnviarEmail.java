package com.rvia.project.controller.util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author clear
 */
public class EnviarEmail {
    public String nameCompany = null;
    public String companyEmail = null;
    public String compayEmailPassword = null;

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompayEmailPassword() {
        return compayEmailPassword;
    }

    public void setCompayEmailPassword(String compayEmailPassword) {
        this.compayEmailPassword = compayEmailPassword;
    }
    
    public EnviarEmail(){
        nameCompany = "";
        companyEmail = "";
        compayEmailPassword = "";
    }
     
    public EnviarEmail(String nameCompany, String companyEmail, String companyEmailPassword){
        this.nameCompany = nameCompany;
        this.companyEmail = companyEmail;
        this.compayEmailPassword = companyEmailPassword;
    }
    
    public boolean enviarCorreo(String asunto,String userEmail, String userPassword, String cuerpoMessage){
	              
            try{
            
                String host = "smtp.gmail.com";
                
                Properties prop = System.getProperties();
                
                prop.put("mail.smtp.starttls.enable","true");
                prop.put("mail.smtp.host", host);
                prop.put("mail.smtp.user",companyEmail);
                prop.put("mail.smtp.password", compayEmailPassword);
                prop.put("mail.smtp.port","587");
                prop.put("mail.smtp.auth","true");
                
                Session sesion = Session.getDefaultInstance(prop,null);
                
                MimeMessage message = new MimeMessage(sesion);
                
                message.setFrom(new InternetAddress(companyEmail));
                
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
                
                message.setSubject(asunto);
     
                message.setContent("<html>"
                	    +"<section style='background-image: url(http://i65.tinypic.com/k480ig.png); background-repeat: no-repeat; background-size: cover; width: 450px; margin: 0 auto; padding-top: 20px'>"
                            +"<h1 style='font-family: Arial; text-align: center; color:white; font-size: 30px'>"+nameCompany+"</h1>" 
                            +"<article style='background: white; margin-top: 50px; height: 400px'>"
                            +"<h1 style='font-family: Arial, cursive; display: block; font-size: 30px; padding-top: 30px'>Mensaje de la administracion </h1>"
                            +"<p style='font-family: Arial; font-size: 15px'>Para: "+userEmail+" </p>"
                            +"<h1 style='font-family: Arial; font-size: 15px; font-weight: bold'>Mensaje de la administracion: </h1>"
                            +"<p style='font-family: Arial; font-size: 15px'>"+cuerpoMessage+"</p>"
                           
                            +"</article>"
                            +"</section>"
                            +"</html>", "text/html" ) ; 
                
                Transport transport = sesion.getTransport("smtp");
                
                transport.connect(host,companyEmail,compayEmailPassword);
                
                transport.sendMessage(message, message.getAllRecipients());
                
                transport.close();
                
                return true;
                
            }catch(Exception e){
                e.printStackTrace();
            }
        
        return false;
    }   
}
