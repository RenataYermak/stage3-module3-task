package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository implements BaseRepository<Author, Long> {

    private EntityManager entityManager;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<Author> readAll() {
        var criteria = entityManager.getCriteriaBuilder().createQuery(Author.class);
        criteria.from(Author.class);
        return entityManager.createQuery(criteria)
                .getResultList();
    }

    @Override
    public Optional<Author> readById(Long id) {
        return Optional.ofNullable(entityManager.find(Author.class, id));
    }

    @Override
    public Author create(Author entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Author update(Author entity) {
        entityManager.getTransaction().begin();
        var updatedAuthor = entityManager.find(Author.class, entity.getId());
        updatedAuthor.setName(entity.getName());
        entityManager.merge(updatedAuthor);
        entityManager.getTransaction().commit();
        return updatedAuthor;
    }

    @Override
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Author.class, id));
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
