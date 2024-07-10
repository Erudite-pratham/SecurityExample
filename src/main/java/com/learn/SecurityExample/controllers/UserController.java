package com.learn.SecurityExample.controllers;

import com.learn.SecurityExample.models.User;
import com.learn.SecurityExample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String home() {
        return "this is home page";
    }

    // all users
    @GetMapping("/")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    //return single user
//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username) {
        return this.userService.getUser(username);
    }

    @PostMapping("/")
    public User add(@RequestBody User user) {
        return this.userService.addUser(user);
    }

}

