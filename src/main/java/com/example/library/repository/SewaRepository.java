package com.example.library.repository;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Sewa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SewaRepository extends JpaRepository<Sewa, Long> {
    Optional<Sewa> findByISBN(String ISBN);
    
}
