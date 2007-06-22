// license-header java merge-point
package com.cine.dao; 

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id, boolean lock);

    List<T> findAll();
    
    List<T> findPageByPage(int firstResult, int maxResults);

    List<T> findByExample(T exampleInstance, String... excludeProperty);

    T makePersistent(T entity);

    void makeTransient(T entity);
}