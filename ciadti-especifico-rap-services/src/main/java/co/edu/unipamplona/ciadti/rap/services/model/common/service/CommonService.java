package co.edu.unipamplona.ciadti.rap.services.model.common.service;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;

import java.util.Collection;

public interface CommonService<T> {
    T findById(Long id) throws RapException;
    Iterable<T> findAll();
    T save (T entity);
    Iterable<T> save(Collection<T> entities);
}
