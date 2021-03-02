package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();
    Optional<User> findById(Long id);
    User save(User user);
    void remove(Long id);
    void updateUserById(Long id, User user) throws Exception;
}
