package ru.javamentor.spring_mvc_Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javamentor.spring_mvc_Boot.dao.UserDAO;
import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }
}
