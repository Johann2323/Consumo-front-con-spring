package com.ista.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model modelo) {
		modelo.addAttribute("titulo","Enviar parametros de la ruta (@PathVariable)");
		
		return "variables/index";
	}
	
	//Obtención de varios parámetros a través de @RequestParam
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model modelo) {
		
		modelo.addAttribute("titulo","Recibir parametros de la Ruta (@PathVariable)");
		modelo.addAttribute("resultado","el texto enviado en la ruta es "+texto);
		return "variables/ver1";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto,@PathVariable Integer numero, Model modelo) {
		
		modelo.addAttribute("titulo","Recibir parametros de la Ruta (@PathVariable)");
		modelo.addAttribute("resultado","el texto enviado en la ruta es "+texto+" y el numero enviado en el path es "+numero);
		return "variables/ver1";
	}
	
}
