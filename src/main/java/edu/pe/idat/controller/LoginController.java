package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.pe.idat.Model.Login;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public ModelAndView Login() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("loginform", new Login());
		modelView.addObject("visualizar", false);
		return modelView;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("home") Login loginForm, 
			Model model) {
		if(loginForm.getUsuario().equals("d18159") && 
				loginForm.getContraseña().equals("123456")) {
			model.addAttribute("mensaje", "Bienvenido: "+ loginForm.getUsuario());
			model.addAttribute("titulo", "Home");
			return "menu";
		}
		model.addAttribute("visualizar", true);
		model.addAttribute("mensajeerror", "Usuario o password incorrecto.");
		return "login";
	}
}
