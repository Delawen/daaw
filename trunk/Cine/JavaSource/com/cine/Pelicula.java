package com.cine;

import java.lang.String;

import java.util.HashSet;
import java.util.Set;

public class Pelicula 
{
	public Pelicula() 
	{
		super();
	}
	private long ID;
	private String titulo;
	private String sinopsis;
	private Set<SesionCine> sesiones = new HashSet<SesionCine>();
	
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
	public long getID() {
		return ID;
	}
	public Set<SesionCine> getSesiones() {
		return sesiones;
	}
	public void setSesiones(Set<SesionCine> sesiones) {
		this.sesiones = sesiones;
	}
	public void setID(long id) {
		ID = id;
	}
	public void addSesionCine(SesionCine s)
	{
		this.sesiones.add(s);
		s.setPelicula(this);
	}
}
