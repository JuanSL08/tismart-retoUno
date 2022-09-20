package com.tismart.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.model.Provincia;
import com.tismart.repository.ProvinciaRepository;
import com.tismart.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {

	@Autowired
	private ProvinciaRepository provinciaRepository;
	
	@Override
	public List<Provincia> buscarTodas() {
		return provinciaRepository.findAll();
	}

}
