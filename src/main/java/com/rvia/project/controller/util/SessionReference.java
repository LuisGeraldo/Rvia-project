package com.rvia.project.controller.util;

import javax.faces.context.FacesContext;

/**
 *
 * @author clear
 */
public class SessionReference {
    FacesContext  facesContext;
    
    
    public SessionReference(){
       facesContext = FacesContext.getCurrentInstance();
    }
    
    public FacesContext getFacesContext(){
        return facesContext;
    }
    
    public void navigationHandlerRedirect(String ruta){
       facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, ruta);
    }
    
    public void sessionMapPut(String key, Object object){
        facesContext.getExternalContext().getSessionMap().put(key, object);
    }    
    
    
    public Object sessionMapGet(String key){
      return facesContext.getExternalContext().getSessionMap().get(key);
    }
    
    public Object sessionMapGetRemove(String key){
      return facesContext.getExternalContext().getSessionMap().remove(key);
    }
}
