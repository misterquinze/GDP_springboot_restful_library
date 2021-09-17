package com.example.library.controller;

import java.util.List;

import com.example.library.entity.UserRole;
import com.example.library.service.UserRoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/userRole")
public class UserRoleController{
    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("")
    public List<UserRole> getAllUserRole() {
        return userRoleService.getAll();
    }
}