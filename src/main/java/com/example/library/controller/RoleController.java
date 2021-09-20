package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Role;
import com.example.library.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public List<Role> getAllURole() {
        return roleService.getAll();
    } 

    @GetMapping("/{roleId}")
    public Role getRoleId(@PathVariable(name="roleId") Long roleId) {
        return roleService.getRoleById(roleId);
    }
}
