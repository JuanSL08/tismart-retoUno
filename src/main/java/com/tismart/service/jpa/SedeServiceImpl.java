package com.tismart.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.model.Sede;
import com.tismart.repository.SedeRepository;
import com.tismart.service.ISedeService;

@Service
public class SedeServiceImpl implements ISedeService {

	@Autowired
	private SedeRepository sedeRepository;
	
	@Override
	public List<Sede> buscarTodas() {
		return sedeRepository.findAll();
	}

}
