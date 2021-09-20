package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    List<Users> getUserByNAMEContainingIgnoreCase(String name);

    Optional<Users> findByUSERNAME(String username);
    Optional<Users> findByEMAILIgnoreCase(String email);
}
