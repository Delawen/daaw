package com.cine.struts.service;

import com.cine.*;
import java.util.*;

public interface FachadaPelicula 
{
	public boolean addPelicula(String titulo, String sinopsis);
	public List<Pelicula> getPeliculas();
	public List<Pelicula> getPeliculas(Date time);
	public Pelicula getPelicula(String titulo);
	public Pelicula getPeliculaByID(long id);
	public List<Pelicula> searchPelicula(String palabra_clave);
	public boolean deletePelicula(String titulo); 
	public boolean deletePeliculaByID(long id);
	
	public List<Sala> getSalas();
	public boolean addSala(String descripcion);
	public boolean deleteSala(String descripcion);
	
	public boolean addSesion(Sala sala, Pelicula pelicula, Date time, float precio);
	public List<SesionCine> getSesiones();
	public boolean deleteSesion(Sala s, Pelicula pelicula, Date time);
	public boolean deleteSesion(Sala s, Pelicula pelicula);
	public boolean deleteSesion(Pelicula pelicula);
	public boolean deleteSesion(String titulo_pelicula);
	public boolean deleteSesion(Sala s);

}
