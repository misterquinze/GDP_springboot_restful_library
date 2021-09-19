package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Users;
import com.example.library.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService userService;

    @GetMapping("")
    public List<Users> getAllUser() {
        return userService.getAll();
    }

    @GetMapping("/users/{name}")
    public List<Users> getUserByName(@PathVariable(name="name") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/users/{username}")
    public Users getUserByUserName(@PathVariable(name="username") String username) {
        return userService.getUserByUserName(username);
    }

    @GetMapping("/users/{email}")
    public Users getUserByEmail(@PathVariable(name="email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("")
    public void addUser(@RequestBody final Users user) {
        userService.addUser(user);
    }

}
