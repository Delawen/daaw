package com.cine.actions;
import com.cine.beans.*;
import com.cine.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.cine.beans.peliculasListForm;
import com.cine.struts.service.FachadaPelicula;
import com.cine.struts.service.FachadaPeliculaImpl;

public class editPeliculaAction extends org.apache.struts.action.Action {
    


    
    public editPeliculaAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
	
    	FachadaPelicula fpeli = new FachadaPeliculaImpl();
    	
    	PeliculaForm pform = (PeliculaForm) form;
    	
    	Pelicula p = fpeli.getPelicula(request.getParameter("titulo"));

    	pform.setTitulo("puta");
    	pform.setSinopsis("wa");
    	
    	/*
    	pform.setTitulo(p.getTitulo());
    	pform.setSinopsis(p.getSinopsis());
    	*/
    	return mapping.findForward("editarPelicula");
    }

}