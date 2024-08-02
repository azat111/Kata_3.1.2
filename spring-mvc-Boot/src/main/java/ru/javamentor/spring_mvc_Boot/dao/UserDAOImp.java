package ru.javamentor.spring_mvc_Boot.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        List<User> userlist = entityManager.createQuery("FROM User", User.class).getResultList();
        return userlist;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
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
    public void update(int id,String name,int age) {
        User user = findById(id);
        user.setAge(age);
        user.setName(name);
        entityManager.merge(user);
    }
}
