package com.cine.beans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class PeliculaForm extends org.apache.struts.action.ActionForm {

	private String titulo;
	private String sinopsis;

    public PeliculaForm () {
    	this.titulo = "";
    	this.sinopsis = "";
    }

    public void reset(ActionMapping actionMapping, HttpServletRequest request) {
       
    	reset();
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        
    	ActionErrors errores = new ActionErrors();
    	
    	if("".equals(titulo.trim()))
    		errores.add(
    						"sintitulo",
    						new ActionError("error.sinTitulo")
    					);
    	else 
    		return null;
    	
    	return errores;
    	
    }
    
    private void reset()
    {
    	this.titulo = "";
    	this.sinopsis = "";
    }

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


}