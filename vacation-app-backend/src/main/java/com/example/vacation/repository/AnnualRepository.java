package com.example.vacation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vacation.model.Annual;

@Repository
public interface AnnualRepository extends JpaRepository<Annual, Long> {

    Optional<Annual> findById(Long id);
    
    Annual findByUserIdAndYear(Long id, String year);
}
