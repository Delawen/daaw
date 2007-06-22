package com.cine.dao;


public abstract class DAOFactory {

  private static DAOFactory instance;

  private static final String daoFactoryClassName = "com.cine.dao.hibernate.HibernateDAOFactory";

  public static DAOFactory getInstance() {
    if(instance == null) {
      try {
        instance = (DAOFactory) Class.forName(daoFactoryClassName).newInstance();
      } catch (Exception e) {
        throw new RuntimeException("Could not instantiate DAO factory class ["+daoFactoryClassName+"]", e);
      }
    }
    return instance;
  }

  public abstract PeliculaDAO getPeliculaDAO();
  public abstract ButacaDAO getButacaDAO();
  public abstract SalaDAO getSalaDAO();
  public abstract SesionCineDAO getSesionCineDAO();

}