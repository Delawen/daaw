package com.cine.struts.service;

import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.cine.*;
import com.cine.dao.*;
import com.cine.dao.hibernate.*;

public class FachadaPeliculaImpl implements FachadaPelicula 
{

	DAOFactory daofact;
	public boolean addPelicula(String titulo, String sinopsis) 
	{
		boolean resultado = true;
		
		Pelicula p = new Pelicula();
		
		p.setTitulo(titulo);
		p.setSinopsis(sinopsis);
		
		HibernateUtils.beginTransaction();
		daofact = DAOFactory.getInstance();
		daofact.getPeliculaDAO().makePersistent(p);
		HibernateUtils.commitTransaction();
		
		return resultado;
	}

	public boolean deletePelicula(String titulo) 
	{
		boolean resultado = false;
		
		Pelicula p;
	
		daofact = DAOFactory.getInstance();
		PeliculaDAO pdao = daofact.getPeliculaDAO();
		
		List<Pelicula> peliculas = pdao.findAll();
		
		Iterator it = peliculas.iterator();
		
		while(it.hasNext())
		{
			p = (Pelicula) it.next();
			if(p.getTitulo().equals(titulo))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(p);
				HibernateUtils.commitTransaction();
				resultado = true;
			}
		}
		
		return resultado;
	}

	public List<Pelicula> getPelicula(String titulo)
	{
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		
		daofact = DAOFactory.getInstance();
		PeliculaDAO pdao = daofact.getPeliculaDAO();
		
		List<Pelicula> peliculas = pdao.findAll();
		
		Iterator it = peliculas.iterator();
		
		while(it.hasNext())
		{
			Pelicula p = (Pelicula)it.next();
			if(p.getTitulo().contains(titulo))
				resultado.add(p);
		}
		
		return resultado;
	}

	public List<Pelicula> getPeliculas() 
	{
		daofact = DAOFactory.getInstance();
		PeliculaDAO pdao = daofact.getPeliculaDAO();
		
		return pdao.findAll();
	}

	public List<Pelicula> getPeliculas(Date time) 
	{
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO scdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones =scdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			SesionCine s = (SesionCine)it.next();
			if(s.getTime().equals(time))
				resultado.add(s.getPelicula());
		}
		
		return resultado;
	}

	public List<Pelicula> searchPelicula(String palabra_clave)
	{
		List<Pelicula> resultado = new ArrayList<Pelicula>();
		
		daofact = DAOFactory.getInstance();
		PeliculaDAO pdao = daofact.getPeliculaDAO();
		
		List<Pelicula> peliculas = pdao.findAll();
		
		Iterator it = peliculas.iterator();
		
		while(it.hasNext())
		{
			Pelicula p = (Pelicula)it.next();
			if(p.getTitulo().contains(palabra_clave)
					||p.getSinopsis().contains(palabra_clave))
				resultado.add(p);
		}
		
		return resultado;
	}

	public boolean addSala(String descripcion)
	{
		boolean resultado = true;
		
		Sala s = new Sala();
		
		s.setDescripcion(descripcion);
		
		daofact = DAOFactory.getInstance();
		
		HibernateUtils.beginTransaction();
		daofact.getSalaDAO().makePersistent(s);
		HibernateUtils.commitTransaction();
		
		return resultado;
	}
	
	public List<Sala> getSalas()
	{
		daofact = DAOFactory.getInstance();
		
		SalaDAO sdao = daofact.getSalaDAO();
		return sdao.findAll();
	}
	
	public List<SesionCine> getSesiones()
	{
		daofact = DAOFactory.getInstance();
		SesionCineDAO scdao = daofact.getSesionCineDAO();
		
		return scdao.findAll();
	}
	
	public boolean addSesion(Sala sala, Pelicula pelicula, Date time, float precio)
	{
		boolean resultado = true;
		
		SesionCine s = new SesionCine();
		
		s.setPelicula(pelicula);
		s.setSala(sala);
		s.setPrecio(precio);
		s.setTime(time);
		
		daofact = DAOFactory.getInstance();
		
		HibernateUtils.beginTransaction();
		daofact.getSesionCineDAO().makePersistent(s);
		daofact.getSalaDAO().makePersistent(s.getSala());
		daofact.getPeliculaDAO().makePersistent(s.getPelicula());
		HibernateUtils.commitTransaction();
		
		return resultado;
	}
	
	public boolean deleteSala(String descripcion)
	{
		boolean resultado = false;
		
		Sala s;
		
		daofact = DAOFactory.getInstance();
		SalaDAO pdao = daofact.getSalaDAO();
		
		List<Sala> salas = pdao.findAll();
		Iterator it = salas.iterator();
		
		while(it.hasNext())
		{
			s = (Sala)it.next();
			if(s.getDescripcion().equals(descripcion))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(s);
				HibernateUtils.commitTransaction();
				
				resultado = true;
			}
			
		}
		
		return resultado;
	}
	
	public boolean deleteSesion(Sala s, Pelicula pelicula, Date time)
	{
		boolean resultado = true;
		
		SesionCine sesion = new SesionCine();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO pdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones = pdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			sesion = (SesionCine)it.next();
			if(sesion.getPelicula().equals(pelicula) &&
					sesion.getSala().equals(s) &&
					sesion.getTime().equals(time))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(sesion);
				HibernateUtils.commitTransaction();
			}
		}
		
		return resultado;
	}
	
	public boolean deleteSesion(Sala s, Pelicula pelicula)
	{
		boolean resultado = true;
		
		SesionCine sesion = new SesionCine();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO pdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones = pdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			sesion = (SesionCine)it.next();
			if(sesion.getPelicula().equals(pelicula) &&
					sesion.getSala().equals(s))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(sesion);
				HibernateUtils.commitTransaction();
			}
		}
		
		return resultado;
	}
	public boolean deleteSesion(String titulo_pelicula)
	{
		boolean resultado = true;
		
		SesionCine sesion = new SesionCine();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO pdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones = pdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			sesion = (SesionCine)it.next();
			if(sesion.getPelicula().getTitulo().equals(titulo_pelicula))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(sesion);
				HibernateUtils.commitTransaction();
			}
		}
		
		return resultado;
	}
	
	public boolean deleteSesion(Pelicula pelicula)
	{
		boolean resultado = true;
		
		SesionCine sesion = new SesionCine();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO pdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones = pdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			sesion = (SesionCine)it.next();
			if(sesion.getPelicula().equals(pelicula))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(sesion);
				HibernateUtils.commitTransaction();
			}
		}
		
		return resultado;
	}
	
	public boolean deleteSesion(Sala s)
	{
		boolean resultado = true;
		
		SesionCine sesion = new SesionCine();
		
		daofact = DAOFactory.getInstance();
		SesionCineDAO pdao = daofact.getSesionCineDAO();
		
		List<SesionCine> sesiones = pdao.findAll();
		
		Iterator it = sesiones.iterator();
		
		while(it.hasNext())
		{
			sesion = (SesionCine)it.next();
			if(sesion.getSala().equals(s))
			{
				HibernateUtils.beginTransaction();
				pdao.makeTransient(sesion);
				HibernateUtils.commitTransaction();
			}
		}
		
		return resultado;
	}
}
