package com.cine.dao.hibernate;


import  com.cine.dao.PeliculaDAO;
import  com.cine.Pelicula;

public class PeliculaHibernateDAO
        extends     GenericHibernateDAO<Pelicula, Long, PeliculaDAO>
        implements  PeliculaDAO {
}