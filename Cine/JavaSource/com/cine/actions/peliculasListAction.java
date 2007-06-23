package com.cine.actions;

import javax.servlet.http.*;
import org.apache.struts.action.*;

import com.cine.struts.service.*;
import com.cine.beans.*;
import java.util.List;

public class peliculasListAction extends org.apache.struts.action.Action {
    


    
    public peliculasListAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        
        HttpSession sesion = request.getSession();
        
        List peliculas;
        
    	FachadaPelicula fpeli = new FachadaPeliculaImpl();
    	
    	peliculas = fpeli.getPeliculas();
        
        if(peliculas != null)
            sesion.setAttribute("peliculas", peliculas);
    	
    	return (mapping.findForward("verPeliculas"));
    }

}