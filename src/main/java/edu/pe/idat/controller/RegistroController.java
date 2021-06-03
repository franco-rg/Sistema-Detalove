package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.idat.Model.Registro;

@Controller
public class RegistroController {
	
	@GetMapping("/registrar")
	public ModelAndView Login() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("registrarform", new Registro());
		modelView.addObject("visualizar", false);
		return modelView;
	}
	
	@PostMapping("/registrar")
	public String login(@ModelAttribute("registrarform") Registro registrarForm, 
			Model model) {
		return "login";
	}

}
