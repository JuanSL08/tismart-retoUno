package com.tismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tismart.service.IGerenteService;

@Controller
@RequestMapping(value="/gerente")
public class GerenteController {

	@Autowired
	private IGerenteService serviceGerente;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("gerentes", serviceGerente.buscarTodos());
		return "gerente/listGerente";
	}
}
