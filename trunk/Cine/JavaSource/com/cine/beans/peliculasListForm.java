package com.cine.beans;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;

public class peliculasListForm extends org.apache.struts.action.ActionForm {

	private Collection peliculas;

    public peliculasListForm () {
    }

    public void reset(ActionMapping actionMapping, HttpServletRequest request) {
    	peliculas = new ArrayList();
    }

    public ActionErrors validate(ActionMapping actionMapping, HttpServletRequest request) {
        return null;
    }

	public Collection getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Collection peliculas) {
		this.peliculas = peliculas;
	}


}