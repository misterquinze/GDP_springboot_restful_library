package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Role;
import com.example.library.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long roleId) {
        Optional<Role> tmpRole = roleRepository.findById(roleId);

        if (tmpRole.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return tmpRole.get();
    }
    
    
}
