package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Users;
// import com.example.library.repository.UserRoleRepository;
import com.example.library.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsersService {
    @Autowired 
    private UsersRepository userRepository;

    // @Autowired 
    // private UserRoleRepository userRoleRepository;

    // @Autowired 
    // private UsersRepository userRepository;

    public List<Users> getAll() {
        return userRepository.findAll();
        
    }

    public List<Users> getUserByName(String name) {
        List<Users> users = userRepository.getUserByNAMEContainingIgnoreCase(name);
        
        if (users.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return users;
    }

    public Users getUserByUserName(String username) {
        Optional<Users> tmpUsers = userRepository.getUserByUSERNAME(username);

        if (tmpUsers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return tmpUsers.get();
    }

    public Users getUserByEmail(String email) {
        Optional<Users> tmpUsers = userRepository.getUserByEMAIL(email);

        if (tmpUsers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return tmpUsers.get();
    }

    // public Users getUserRoleByUserId(long userId) {
    //     return userRoleViewRepository.getUserRoleByUserId(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User [name = " +name+ "] is not found"));
    // }

    // public Users addUsers(Users users){
    //     Optional<Users> tmpUsers = UsersRepository.findById(Users.getID());

    //     if(tmpUsers.isPresent()) {
    //         throw new ResponseStatusException(HttpStatus.CONFLICT, "Yeayy!! Pelanggan with matching KODEPEL was found");
    //     }

    //     userRepository.save(users);
    //     throw new ResponseStatusException(HttpStatus.OK, "Yeay! New Pelanggan was added!"); 
    // }
}