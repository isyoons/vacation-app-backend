package com.example.vacation.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.vacation.model.Vacation;

@Repository
public interface VacationRepository extends JpaRepository<Vacation, Long> {
	
	Optional<Vacation> findById(Long id);
	
	List<Vacation> findByUserAnnualId(Long id);
	
	@Query(value = "select sum(use_days) as total_use_days from vacation v where v.user_annual_id = :id", nativeQuery = true)
	Double findAllByUserAnnualId(@Param("id") Long id);
	
	@Transactional
	int deleteAllById(Long id);
}
