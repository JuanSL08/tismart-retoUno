package com.tismart.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tismart.model.Condicion;
import com.tismart.repository.CondicionRepository;
import com.tismart.service.ICondicionService;

@Service
public class CondicionServiceImpl implements ICondicionService{

	@Autowired
	private CondicionRepository condicionRepository;
	
	@Override
	public List<Condicion> buscarTodas() {
		return condicionRepository.findAll();
	}

}
