package com.ista.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false,defaultValue = "si le salio este mensaje debe enviar: /string?texto=Buenas tardes")String texto,Model modelo) {
		modelo.addAttribute("resultado","El tetxo enviado es: "+texto);
		return "params/ver";
	}
	
	//Obtener varios parámetros de la URL con @RequestParam
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero,Model modelo) {
		modelo.addAttribute("resultado","El tetxo enviado es: '"+saludo+"' y el numero es '"+numero+"'");
		return "params/ver";
	}
	
	
	//Obtener varios parámetros de la URL con a través de HTTPServletRequest
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request,Model modelo) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		
		try {
			numero= Integer.parseInt(request.getParameter("numero"));
			
		} catch (NumberFormatException e) {
			numero=0;
		}
		modelo.addAttribute("resultado","El saludo enviado: '"+saludo+"' y el numero es '"+numero +"'");
		return "params/ver";
	}

}
