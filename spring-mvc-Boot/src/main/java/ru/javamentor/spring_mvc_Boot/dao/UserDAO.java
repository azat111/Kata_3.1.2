package ru.javamentor.spring_mvc_Boot.dao;

import org.springframework.stereotype.Component;
import ru.javamentor.spring_mvc_Boot.models.User;

import java.util.List;

@Component
public interface UserDAO {
    List<User> index();

    void save(User user);

    void delete(int id);

    User findById(int id);

    void update(int id,String name,int age);
}
