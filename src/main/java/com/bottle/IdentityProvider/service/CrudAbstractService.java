package com.bottle.IdentityProvider.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AKuzmanoski on 16/03/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 16/03/2017
 */
public abstract class CrudAbstractService<T, ID extends Serializable> implements CrudService<T, ID> {
    private JpaRepository<T, ID> repository;

    public CrudAbstractService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findOne(ID id) {
        return repository.findOne(id);
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(ID id) {
        this.repository.delete(id);
    }
}
