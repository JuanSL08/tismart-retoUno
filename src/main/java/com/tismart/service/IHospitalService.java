package com.tismart.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.tismart.model.Hospital;

public interface IHospitalService {

	List<Hospital> buscarTodos();
	
	List<Hospital> buscarByExample(Example<Hospital> example);
	
	void guardar(Hospital hospital);
	
	void eliminar(Integer idHospital);
	
	Hospital buscarPorId(Integer idHospital);
	
}
