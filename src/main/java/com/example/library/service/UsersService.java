package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.UserRoleView;
import com.example.library.entity.Users;
import com.example.library.repository.UserRoleViewRepository;
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

    @Autowired 
    private UserRoleViewRepository userRoleViewRepository;

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
        Optional<Users> tmpUsers = userRepository.findByUSERNAME(username);

        if (tmpUsers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return tmpUsers.get();
    }

    public Users getUserByEmail(String email) {
        Optional<Users> tmpUsers = userRepository.findByEMAILIgnoreCase(email);

        if (tmpUsers.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return tmpUsers.get();
    }

    public Users addUser(Users user){
        Optional<Users> tmpUser = userRepository.findByUSERNAME(user.getUSERNAME());

        if(tmpUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Yeayy!! User with matching USERNAME was found");
        }

        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK, "Yeay! New User was added!"); 
    }

    public void updateUser(Long userId, Users user) {
        Optional<Users> tmpUser = userRepository.findById(userId);

        if (tmpUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh Oh! no mataching user was found");
        }

        userRepository.save(user);
        throw new ResponseStatusException(HttpStatus.OK, "Yeayy! Succes Update!");
    }

    public void deleteUser(Long userId) {
        Optional<Users > user = userRepository.findById(userId);

        if (user.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }

        userRepository.deleteById(userId);
        throw new ResponseStatusException(HttpStatus.OK, "Succes Delete");
    }

    public UserRoleView getUserRoleByEmail(String email) {
        return userRoleViewRepository.getUserRoleByEmail(email).orElseThrow(() -> 
                new ResponseStatusException(HttpStatus.NOT_FOUND, "not found"));
    }

    
}
