package com.tismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tismart.service.ICondicionService;

@Controller
@RequestMapping(value="/condicion")
public class CondicionController {
	
	@Autowired
	private ICondicionService serviceCondicion;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("condiciones", serviceCondicion.buscarTodas());
		return "condicion/listCondicion";
	}
}
