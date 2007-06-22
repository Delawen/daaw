package com.cine.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cine.struts.service.*;
import com.cine.beans.*;

public class peliculasListAction extends org.apache.struts.action.Action {
    


    
    public peliculasListAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	FachadaPelicula fpeli = new FachadaPeliculaImpl();
    	
    	peliculasListForm pform = (peliculasListForm) form;
    	
    	pform.setPeliculas(fpeli.getPeliculas());
    	
    	return mapping.findForward("ListarPeliculas");
    }

}