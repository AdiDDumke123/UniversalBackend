package com.repository;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RequestScoped
@Transactional
public abstract class GenericRepository<T> {

    @PersistenceContext(unitName = "mark1")
    private EntityManager entityManager;

    public void save(T entity){
        this.entityManager.persist(entity);
        this.entityManager.flush();
    }
}
