package com.tismart.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.model.Gerente;
import com.tismart.repository.GerenteRepository;
import com.tismart.service.IGerenteService;

@Service
public class GerenteServiceImpl implements IGerenteService {

	@Autowired
	private GerenteRepository gerenteRepository;
	
	@Override
	public List<Gerente> buscarTodos() {
		return gerenteRepository.findAll();
	}

}
