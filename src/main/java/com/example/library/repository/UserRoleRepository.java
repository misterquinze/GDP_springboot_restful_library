package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    Optional<UserRole> getUserByUSERID(long userId);
    List<UserRole> getUserByROLEID(long roleId);
}
