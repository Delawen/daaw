
package com.cine.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import com.cine.dao.GenericDAO;

public abstract class GenericHibernateDAO<T, ID extends Serializable, DaoImpl extends GenericDAO<T, ID>>
  implements GenericDAO<T, ID> {

  private Class<T> persistentClass;
  private Session session;

  @SuppressWarnings("unchecked")
  public GenericHibernateDAO() {
    this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0];
  }

  @SuppressWarnings("unchecked")
  public DaoImpl setSession(Session s) {
    this.session = s;
    return (DaoImpl)this;
  }

  @SuppressWarnings("unchecked")
  protected Session getSession() {
    if (session == null)
      throw new IllegalStateException("Session has not been set on DAO before usage");
    return session;
  }

  @SuppressWarnings("unchecked")
  public Class<T> getPersistentClass() {
    return persistentClass;
  }

  @SuppressWarnings("unchecked")
  public T findById(ID id, boolean lock) {
    T entity;
    if (lock)
      entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
    else
      entity = (T) getSession().load(getPersistentClass(), id);

    return entity;
  }

  @SuppressWarnings("unchecked")
  public List<T> findAll() {
    return findByCriteria();
  }

  @SuppressWarnings("unchecked")
  public List<T> findPageByPage(int firstResult, int maxResults) {
    return findByCriteriaPageByPage(firstResult, maxResults);
  }

  @SuppressWarnings("unchecked")
  public List<T> findByExample(T exampleInstance, String... excludeProperty) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    Example example =  Example.create(exampleInstance);
    for (String exclude : excludeProperty) {
       example.excludeProperty(exclude);
    }
    crit.add(example);
    return crit.list();
  }

  @SuppressWarnings("unchecked")
  public T makePersistent(T entity) {
    getSession().saveOrUpdate(entity);
	  //getSession().save(entity);
    return entity;
  }

  @SuppressWarnings("unchecked")
  public void makeTransient(T entity) {
    getSession().delete(entity);
  }

  @SuppressWarnings("unchecked")
  protected List<T> findByCriteria(Criterion... criterion) {
    Criteria crit = getSession().createCriteria(getPersistentClass());
    for (Criterion c : criterion) {
      crit.add(c);
    }
    return crit.list();
  }

  @SuppressWarnings("unchecked")
  protected List<T> findByCriteriaPageByPage(int firstResult, int maxResults, Criterion... criterion) {
    Criteria criteria = getSession().createCriteria(getPersistentClass());
    for (Criterion c : criterion) {
      criteria.add(c);
    }
    criteria.setFirstResult(firstResult);
    criteria.setMaxResults(maxResults);
    return criteria.list();
  }

}