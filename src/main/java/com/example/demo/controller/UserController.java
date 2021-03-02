package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IUserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/users")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> Users(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }

    @PostMapping
    public User create (@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Optional<User>> update (@RequestBody User user, @PathVariable(value = "id") Long id) throws Exception {
        userService.updateUserById(id, user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") Long id){
        userService.remove(id);
    }


}
