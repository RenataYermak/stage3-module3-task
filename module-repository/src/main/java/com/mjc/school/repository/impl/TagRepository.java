package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class TagRepository implements BaseRepository<Tag, Long> {

    private EntityManager entityManager;

    @PersistenceUnit
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Tag> readAll() {
        var criteria = entityManager.getCriteriaBuilder().createQuery(Tag.class);
        criteria.from(Tag.class);
        return entityManager.createQuery(criteria)
                .getResultList();
    }

    @Override
    public Optional<Tag> readById(Long id) {
        return Optional.ofNullable(entityManager.find(Tag.class, id));
    }

    @Override
    public Tag create(Tag entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Tag update(Tag entity) {
        entityManager.getTransaction().begin();
        var updatedTag = entityManager.find(Tag.class, entity.getId());
        updatedTag.setName(entity.getName());
        entityManager.merge(updatedTag);
        entityManager.getTransaction().commit();
        return updatedTag;
    }

    @Override
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Tag.class, id));
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
