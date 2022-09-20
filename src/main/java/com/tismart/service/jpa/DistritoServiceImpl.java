package com.tismart.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.model.Distrito;
import com.tismart.repository.DistritoRepository;
import com.tismart.service.IDistritoService;

@Service
public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private DistritoRepository distritoRepository;
	
	@Override
	public List<Distrito> buscarTodos() {
		return distritoRepository.findAll();
	}

}
