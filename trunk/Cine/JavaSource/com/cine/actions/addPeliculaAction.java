package com.cine.actions;

import com.cine.beans.*;

import com.cine.struts.service.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class addPeliculaAction extends org.apache.struts.action.Action {

    
    public addPeliculaAction() {
    }
    
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	ActionForward direccion;
    	
    	PeliculaForm formulario = (PeliculaForm) form;
       
    	FachadaPelicula fpeli = new FachadaPeliculaImpl();

    	fpeli.addPelicula(formulario.getTitulo(), formulario.getSinopsis());
    	
    	direccion = mapping.findForward("exito");
    	
        return direccion;
    }

}