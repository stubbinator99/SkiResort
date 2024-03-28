package com.skiresort.controllers;

import com.skiresort.models.User;
import com.skiresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/id/{userId}", produces = "application/json")
    public User getUser(@PathVariable String userId) {
        return userService.getUserById(userId).orElse(null);
    }

    @PostMapping(value = "/new")
    public void newUser(@RequestBody User user) {
        userService.createNewUser(user);
    }

    //temp
    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
