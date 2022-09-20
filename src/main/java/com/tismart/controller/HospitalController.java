package com.tismart.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tismart.model.Hospital;
import com.tismart.service.ICondicionService;
import com.tismart.service.IDistritoService;
import com.tismart.service.IGerenteService;
import com.tismart.service.IHospitalService;
import com.tismart.service.ISedeService;

@Controller
@RequestMapping(value="/hospital")
public class HospitalController {

	@Autowired
	private IHospitalService serviceHospital;
	
	@Autowired
	private ISedeService serviceSede;
	
	@Autowired
	private IDistritoService serviceDistrito;
	
	@Autowired
	private IGerenteService serviceGerente;
	
	@Autowired
	private ICondicionService serviceCondicion;
	
	@GetMapping("")
	public String mostrarIndex(Model model) {
		return "hospital/listHospital";
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Hospital hospital, Model model) {
		System.out.println("Buscando por: "+hospital);
		
		//where descripcion like '%?%'
		ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("nombre", 
									ExampleMatcher.GenericPropertyMatchers.contains());
		
		Example<Hospital> example = Example.of(hospital, matcher);
		List<Hospital> lista = serviceHospital.buscarByExample(example);
		
		Hospital hospitalSearch = new Hospital();
		model.addAttribute("search", hospitalSearch);
		model.addAttribute("hospitales", lista);
		model.addAttribute("listaSize", lista.size());
		return "hospital/listHospital";
	}
	
	@GetMapping("/create")
	public String crear(Hospital hospital, Model model) {
		return "hospital/formHospital";
	}
	
	@PostMapping("/save")
	public String guardar(Hospital hospital, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}
			return "hospital/formHospital";
		}
		
		serviceHospital.guardar(hospital);
		attributes.addFlashAttribute("msg", "Registro Guardado");
		System.out.println("Nombre hospital: " + hospital);
		
		return "redirect:/hospital";
	}
	
	@GetMapping("/edit")
	public String listEditar(Hospital hospital, Model model) {
		return "hospital/formHospitalEdit";
	}
	
	@GetMapping("/editSearch")
	public String buscarEdit(@ModelAttribute("search") Hospital hospital, Model model, 
			BindingResult result, RedirectAttributes attributes) {
		Hospital hospitalSearch = new Hospital();
		model.addAttribute("search", hospitalSearch);		
		Hospital hospitalEncontrado = serviceHospital.buscarPorId(hospital.getIdHospital());
		if(Objects.isNull(hospitalEncontrado)) {
			attributes.addFlashAttribute("msg", "Registro No Encontrado");
			model.addAttribute("hospital", new Hospital());
			return "redirect:/hospital/edit";
		}
		
		if(result.hasErrors()) {
			for (ObjectError error: result.getAllErrors()){
				System.out.println("Ocurrio un error: "+ error.getDefaultMessage());
			}
			return "hospital/formHospitalEdit";
		}

		System.out.println("Buscando por: "+hospitalEncontrado);
		
		model.addAttribute("hospital", hospitalEncontrado);
		return "hospital/formHospitalEdit";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idHospital, Model model) {
		Hospital hospital = serviceHospital.buscarPorId(idHospital);
		model.addAttribute("hospital", hospital);
		return "hospital/formHospital";
	}
	
	@GetMapping("/delete")
	public String listEliminar(Model model) {
		return "hospital/listHospitalDelete";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idHospital, Model model, RedirectAttributes attributes) {
		System.out.println("Borrando vacante con id: " + idHospital);
		serviceHospital.eliminar(idHospital);
		attributes.addFlashAttribute("msg", "Registro eliminado");
		return "redirect:/hospital/delete";
	}
	
	//******************
	@ModelAttribute
	public void setGenericos(Model model) {
		model.addAttribute("listaSize", serviceHospital.buscarTodos().size());
		
		Hospital vacanteSearch = new Hospital();
		model.addAttribute("search", vacanteSearch);
		
		model.addAttribute("hospitales", serviceHospital.buscarTodos());
		
		model.addAttribute("sedes", serviceSede.buscarTodas());
		model.addAttribute("distritos", serviceDistrito.buscarTodos());
		model.addAttribute("gerentes", serviceGerente.buscarTodos());
		model.addAttribute("condiciones", serviceCondicion.buscarTodas());
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
}
