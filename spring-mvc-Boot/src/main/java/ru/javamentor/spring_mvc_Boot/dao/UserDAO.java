package ru.javamentor.spring_mvc_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

@Component
public class UserDAO implements UserService {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<User> index() {
        List<User> userlist = entityManager.createQuery("from User", User.class).getResultList();
        return userlist;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    @Override
    public User findById(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }
}
