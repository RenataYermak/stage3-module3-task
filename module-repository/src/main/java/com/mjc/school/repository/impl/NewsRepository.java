package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;
import java.util.Optional;

@Repository
public class NewsRepository implements BaseRepository<News, Long> {

    private EntityManager entityManager;

    @PersistenceUnit
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public List<News> readAll() {
        var criteria = entityManager.getCriteriaBuilder().createQuery(News.class);
        criteria.from(News.class);
        return entityManager.createQuery(criteria)
                .getResultList();
    }

    @Override
    public Optional<News> readById(Long id) {
        return Optional.ofNullable(entityManager.find(News.class, id));
    }

    @Override
    public News create(News entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public News update(News entity) {
        entityManager.getTransaction().begin();
        var updatedNews = entityManager.find(News.class, entity.getId());
        updatedNews.setTitle(entity.getTitle());
        entityManager.merge(updatedNews);
        entityManager.getTransaction().commit();
        return updatedNews;
    }

    @Override
    public boolean deleteById(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(News.class, id));
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id).isPresent();
    }
}
