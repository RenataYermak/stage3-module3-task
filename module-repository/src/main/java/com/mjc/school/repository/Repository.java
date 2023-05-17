package com.mjc.school.repository;

import com.mjc.school.repository.model.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T extends Serializable, E extends BaseEntity<T>> {

    Optional<E> readById(T id);

    List<E> readAll();

    E create(E entity);

    E update(E entity);

    boolean deleteById(T id);

    boolean existById(T id);
}