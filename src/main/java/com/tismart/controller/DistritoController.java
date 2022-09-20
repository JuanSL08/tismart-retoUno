package com.tismart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tismart.service.IDistritoService;

@Controller
@RequestMapping(value="/distrito")
public class DistritoController {
	
	@Autowired
	private IDistritoService serviceDistrito;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		model.addAttribute("distritos", serviceDistrito.buscarTodos());
		return "distrito/listDistrito";
	}
}
