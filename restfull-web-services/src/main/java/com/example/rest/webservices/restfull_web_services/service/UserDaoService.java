package com.example.rest.webservices.restfull_web_services.service;

import com.example.rest.webservices.restfull_web_services.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    public static List<User> users = new ArrayList<>();
    private static  int userCount = 0;
    static {
        users.add(new User(++userCount, "Adam", LocalDate.of(1990, 1, 1)));
        users.add(new User(++userCount, "Eve", LocalDate.of(1991, 1, 1)));
        users.add(new User(++userCount, "Jack", LocalDate.of(1992, 1, 1)));
        users.add(new User(++userCount, "Lily", LocalDate.of(1993, 1, 1)));
    }

    public List<User> findAll() {
        return users;
    }
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
