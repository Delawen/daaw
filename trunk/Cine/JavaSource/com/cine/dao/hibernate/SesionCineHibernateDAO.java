package com.cine.dao.hibernate;


import  com.cine.dao.SesionCineDAO;
import  com.cine.SesionCine;

public class SesionCineHibernateDAO
        extends     GenericHibernateDAO<SesionCine, Long, SesionCineDAO>
        implements  SesionCineDAO {
}