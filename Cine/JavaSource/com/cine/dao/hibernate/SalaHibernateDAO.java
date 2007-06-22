package com.cine.dao.hibernate;

import com.cine.Sala;
import com.cine.dao.SalaDAO;

public class SalaHibernateDAO
        extends     GenericHibernateDAO<Sala, Long, SalaDAO>
        implements  SalaDAO {
}