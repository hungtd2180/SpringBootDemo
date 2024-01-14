package com.example.springbootdemo.servies;

import com.example.springbootdemo.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    void save(User user);

    void delete(Long id);

    Optional<User> findById(Long id);

    List<User> findAll();
}
