package com.skiresort.controllers;

import com.skiresort.models.User;
import com.skiresort.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
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
}
