package com.tismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tismart.service.IProvinciaService;

@Controller
@RequestMapping(value="/provincia")
public class ProvinciaController {

	@Autowired
	private IProvinciaService serviceProvincia;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("provincias",serviceProvincia.buscarTodas());
		return "provincia/listProvincia";
	}
}
