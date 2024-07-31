package ru.javamentor.spring_mvc_Boot.service;

import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    void save(User user);

    void delete(int id);

    User findById(int id);

    void update(User user);
}
