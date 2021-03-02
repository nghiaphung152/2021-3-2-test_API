package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUserById (Long id, User user) throws Exception {
        Optional<User> user1 = userRepository.findById(id);
        if (!user1.isPresent()) {
            throw new Exception("User is not existed");
        }
        user1.get().setAge(user.getAge());
        user1.get().setName(user.getName());
        userRepository.save(user1.get());
    }
}
