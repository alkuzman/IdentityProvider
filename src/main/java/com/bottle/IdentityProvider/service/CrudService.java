package com.bottle.IdentityProvider.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by AKuzmanoski on 16/03/2017.
 *
 * @author AKuzmanoski
 * @version 1.0
 * @since 16/03/2017
 */
public interface CrudService<T, ID extends Serializable> {
    List<T> findAll();

    T findOne(ID id);

    T save(T object);

    T add(T object);

    void delete(ID id);
}
