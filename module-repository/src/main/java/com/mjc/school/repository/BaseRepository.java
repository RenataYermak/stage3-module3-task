package com.mjc.school.repository;

import com.mjc.school.repository.model.BaseEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<T extends BaseEntity<K> , K> {

    List<T> readAll();

    Optional<T> readById(K id);

    T create(T entity);

    T update(T entity);

    boolean deleteById(K id);

    boolean existById(K id);
}
//@RequiredArgsConstructor
//public abstract class BaseRepository<T extends Serializable, E extends BaseEntity<T>> implements Repository<T, E> {
//
//    private final Class<E> clazz;
//    protected final EntityManager entityManager;
//
//    @Override
//    public Optional<E> readById(T id) {
//        return Optional.ofNullable(entityManager.find(clazz, id));
//    }
//
//    @Override
//    public List<E> readAll() {
//        var criteria = entityManager.getCriteriaBuilder().createQuery(clazz);
//        criteria.from(clazz);
//        return entityManager.createQuery(criteria)
//                .getResultList();
//    }
//
//    @Override
//    public E create(E entity) {
//        entityManager.persist(entity);
//        return entity;
//    }
//
//    @Override
//    public E update(E entity) {
//        entityManager.merge(entity);
//        return entity;
//    }
//
//    @Override
//    public boolean deleteById(T id) {
//        entityManager.find(clazz, id);
//        entityManager.remove(entityManager.find(clazz, id));
//        entityManager.flush();
//        return true;
//    }
//
//    @Override
//    public boolean existById(T id){
//        return readById(id).isPresent();
//    }
//}
