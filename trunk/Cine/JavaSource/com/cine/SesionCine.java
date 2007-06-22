package com.cine;

import java.util.*;

public class SesionCine 
{
	private long ID;
	private Sala sala;
	private Pelicula pelicula;
	private Date time;
	private float precio;
	private Set<Butaca> butacas = new HashSet<Butaca>();

	
	public SesionCine() 
	{
		super();
	}
	public Set<Butaca> getButacas() {
		return butacas;
	}
	public void setButacas(Set<Butaca> butacas) {
		this.butacas = butacas;
	}
	public void addButaca(Butaca butaca)
	{
		this.butacas.add(butaca);
		butaca.setSesionCine(this);
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public long getID() {
		return ID;
	}
	public void setID(long id) {
		ID = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
}
