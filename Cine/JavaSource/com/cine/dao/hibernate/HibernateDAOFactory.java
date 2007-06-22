package com.cine.dao.hibernate;

import org.hibernate.Session;

import com.cine.dao.DAOFactory;
import com.cine.dao.*;

public class HibernateDAOFactory extends DAOFactory 
{

  public PeliculaDAO getPeliculaDAO() 
  {
    return new PeliculaHibernateDAO().setSession(getCurrentSession());
  }

  public ButacaDAO getButacaDAO() 
  {
    return new ButacaHibernateDAO().setSession(getCurrentSession());
  }
  
  public SalaDAO getSalaDAO() 
  {
    return new SalaHibernateDAO().setSession(getCurrentSession());
  }
  
  public SesionCineDAO getSesionCineDAO() 
  {
    return new SesionCineHibernateDAO().setSession(getCurrentSession());
  }
  
  public Session getCurrentSession() 
  {
    return HibernateUtils.currentSession();
  }

}