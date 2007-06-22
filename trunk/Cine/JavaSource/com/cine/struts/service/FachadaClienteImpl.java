package com.cine.struts.service;

import java.util.Iterator;
import java.util.List;

import com.cine.dao.DAOFactory;
import com.cine.dao.ButacaDAO;
import com.cine.dao.hibernate.*;
import com.cine.Butaca;

public class FachadaClienteImpl implements FachadaCliente 
{
	private DAOFactory daofact;
	
	public boolean cancelarReserva(List<Butaca> butacas) 
	{
		boolean resultado = false;
		
		Butaca b;
		
		daofact = DAOFactory.getInstance();
		ButacaDAO bdao = daofact.getButacaDAO();
		
		Iterator it = butacas.iterator();
		
		while(it.hasNext())
		{
			b = (Butaca) it.next();
			
			HibernateUtils.beginTransaction();
			bdao.makeTransient(b);
			HibernateUtils.commitTransaction();
			
			resultado = true;
		}
		
		return resultado;
	}

	public boolean reservarButacas(List<Butaca> butacas) 
	{
		boolean resultado = false;
		Butaca b;
		
		daofact = DAOFactory.getInstance();
		ButacaDAO bdao = daofact.getButacaDAO();
		
		Iterator it = butacas.iterator();
		
		while(it.hasNext())
		{
			b = (Butaca) it.next();
			
			HibernateUtils.beginTransaction();
			bdao.makePersistent(b);
			HibernateUtils.commitTransaction();
			
			resultado = true;
		}
		return resultado;
	}

}
