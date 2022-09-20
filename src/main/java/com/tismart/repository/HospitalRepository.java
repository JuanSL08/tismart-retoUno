package com.tismart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tismart.model.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	List<Hospital> findAllByOrderByIdHospital();
	
}
