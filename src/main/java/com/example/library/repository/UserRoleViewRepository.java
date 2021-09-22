package com.example.library.repository;

import java.util.Optional;

import com.example.library.entity.UserRoleView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRoleViewRepository extends JpaRepository<UserRoleView, Long>{
    @Query(value = "SELECT ur.id, ur.userid, ur.aktif "
        + " , u.name, u.email, u.username, u.zipcode, u.register_date, u.password "
        + " , ur.roleid, r.role "
        + "FROM userrole ur "
        + " LEFT JOIN users u ON ur.userid=u.id "
        + " LEFT JOIN role r ON ur.roleid=r.id "
        + "WHERE u.email=:email", nativeQuery = true)
    Optional<UserRoleView> getUserRoleByEmail (@Param("email") String email);

    @Query(value = "SELECT ur.id, ur.userid, ur.aktif "
        + " , u.name, u.email, u.username, u.zipcode, u.register_date, u.password "
        + " , ur.roleid, r.role "
        + "FROM userrole ur "
        + " LEFT JOIN users u ON ur.userid=u.id "
        + " LEFT JOIN role r ON ur.roleid=r.id "
        + "WHERE u.username=:username", nativeQuery = true)
    Optional<UserRoleView> getUserRoleByUsername(@Param("username") String email);

}
