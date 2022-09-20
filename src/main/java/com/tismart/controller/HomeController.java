package com.tismart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tismart.model.Hospital;

@Controller
public class HomeController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String mostrarHome(Model model) {
		Hospital hospitalSearch = new Hospital();
		hospitalSearch.setIdHospital(1);
		model.addAttribute("search", hospitalSearch);
		return "index";				//NO ES NECESARIO AGREGAR .html, POR THYMELEAF
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		Hospital hospitalSearch = new Hospital();
		hospitalSearch.setIdHospital(1);
		model.addAttribute("search", hospitalSearch);
		return "index";				//NO ES NECESARIO AGREGAR .html, POR THYMELEAF
	}
	
	@GetMapping("/login" )
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request){
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	@GetMapping("/bcrypt/{texto}")
	@ResponseBody
	public String encriptar(@PathVariable("texto") String texto) {
		return texto + "Encriptado en Bcrypt: " + passwordEncoder.encode(texto);
	}
}
