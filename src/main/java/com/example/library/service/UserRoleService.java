package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.UserRole;
import com.example.library.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getAll() {
        return userRoleRepository.findAll();
    }

    public UserRole getUserByUserId(Long userId) {
        Optional<UserRole> tmpUserRole = userRoleRepository.getUserByUSERID(userId);

        if (tmpUserRole.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return tmpUserRole.get();
    }

    public List<UserRole> getUserByRoleId(Long roleId) {
        List<UserRole> tmpUserRole = userRoleRepository.getUserByROLEID(roleId);

        if (tmpUserRole.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return tmpUserRole;
    }
}
