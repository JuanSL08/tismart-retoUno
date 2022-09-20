package com.tismart.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tismart.model.Hospital;
import com.tismart.repository.HospitalRepository;
import com.tismart.service.IHospitalService;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;
	
	@Override
	public List<Hospital> buscarTodos() {
		return hospitalRepository.findAllByOrderByIdHospital();
	}

	@Override
	public List<Hospital> buscarByExample(Example<Hospital> example) {
		return hospitalRepository.findAll(example);
	}

	@Override
	public void guardar(Hospital hospital) {
		hospitalRepository.save(hospital);
	}

	@Override
	public void eliminar(Integer idHospital) {
		hospitalRepository.deleteById(idHospital);
	}

	@Override
	public Hospital buscarPorId(Integer idHospital) {
		Optional<Hospital> optional = hospitalRepository.findById(idHospital);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
