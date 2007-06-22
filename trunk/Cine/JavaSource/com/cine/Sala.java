package com.cine;

import java.lang.String;
import java.util.HashSet;
import java.util.Set;

public class Sala 
{
	private long ID;
	private String descripcion;
	private Set<SesionCine> sesiones = new HashSet<SesionCine>();
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		ID = id;
	}
	public Set<SesionCine> getSesiones() {
		return sesiones;
	}
	public void setSesiones(Set<SesionCine> sesiones) {
		this.sesiones = sesiones;
	}
	public void addSesionCine(SesionCine s)
	{
		this.sesiones.add(s);
		s.setSala(this);
	}
}
