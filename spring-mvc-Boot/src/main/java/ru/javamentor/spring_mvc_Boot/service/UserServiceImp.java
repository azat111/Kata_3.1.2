package ru.javamentor.spring_mvc_Boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javamentor.spring_mvc_Boot.dao.UserDAO;
import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return userDAO.index();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    @Transactional
    public void update(int id,String name,int age) {
        userDAO.update(id,name,age);
    }
}
