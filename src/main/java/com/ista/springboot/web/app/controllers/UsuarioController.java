package com.ista.springboot.web.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import com.ista.springboot.web.app.models.entity.alquiler;
import com.ista.springboot.web.app.models.entity.cliente;
import com.ista.springboot.web.app.models.entity.disfraz;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

@Controller
public class UsuarioController {
	List<cliente> clientes= new ArrayList<>();
	List<disfraz> disfrazes= new ArrayList<>();
	List<alquiler> alquileres= new ArrayList<>();
	String cedula="";
	String codigo="";
	
	
	 @GetMapping("/cliente")
	    public String ejemplo(Model model) {
	        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
	        return "cliente";
	    }
	 
	 @GetMapping("/tablaalquiler")
	    public String ejemplo3(Model model) {
	        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
	        return "tablaalquiler";
	    }

	 
	 //Registrocliente
	
	 @PostMapping("/GuardarClientes")
		public String guardarClientes(Model model,@RequestParam String cedula, @RequestParam String nombres, @RequestParam String apellidos, @RequestParam String direccion, @RequestParam String estado) {
			boolean est=true;
			System.out.println(estado);
			if(estado.equalsIgnoreCase("activo")) {
				est=true;
				System.out.println("entree");
			}
			if(estado.equalsIgnoreCase("inactivo")) {
				est=false;
				System.out.println("entree false");
			}
			cliente  cliente = new cliente();
			int total =clientes.size()+1;
			
			cliente.setId_cliente( (long) total);
			cliente.setCedula_cliente(cedula);
			cliente.setNombre_cliente(nombres);
			cliente.setApellido_cliente(apellidos);
			cliente.setDireccion_cliente(direccion);
			cliente.setEstado_cliente(est);
			clientes.add(cliente);
			model.addAttribute("clientes", clientes);
			System.out.println("Cliente guardado "+cliente.getNombre_cliente()+clientes.size());
			return "redirect:/listarcliente";
		}
		
		@GetMapping("/listarcliente")
		public String listarClientes(Model model) {
		    model.addAttribute("clientes", clientes);
		    return "tablacliente";
		}
		
		
		 //Registrodisfraz
		
		 @PostMapping("/GuardarDisfraz")
			public String guardarDisfraz(Model model,@RequestParam String descripcion, @RequestParam Double precio, @RequestParam String tipo, @RequestParam String estado) {
				
				disfraz  disfraz = new disfraz();
				int total =disfrazes.size()+1;
				
				String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		        int longitud = 8;
		        StringBuilder codigoBuilder = new StringBuilder();
		        Random rnd = new Random();
		        
		        for (int i = 0; i < longitud; i++) {
		            int index = rnd.nextInt(caracteres.length());
		            codigoBuilder.append(caracteres.charAt(index));
		        }
		        
		        String codigo = codigoBuilder.toString();
		        System.out.println(codigo);
		        boolean est=true;
				System.out.println(estado);
				if(estado.equalsIgnoreCase("activo")) {
					est=true;
					System.out.println("entree");
				}
				if(estado.equalsIgnoreCase("inactivo")) {
					est=false;
					System.out.println("entree false");
				}
				
				System.out.println(tipo);
				disfraz.setId_disfraz( (long) total);
				disfraz.setCodigo_disfraz(codigo);
				disfraz.setDescripcion_disfraz(descripcion);
				disfraz.setPrecio_disfraz(precio);
				disfraz.setTipo_disfraz(tipo);
				disfraz.setEstado(est);
				disfrazes.add(disfraz);
				model.addAttribute("disfrazes", disfrazes);
				System.out.println("Disfraz guardado "+disfraz.getCodigo_disfraz()+disfrazes.size());
				return "redirect:/listardisfraz";
			}
			
			@GetMapping("/listardisfraz")
			public String listarDisfraz(Model model) {
			    model.addAttribute("disfrazes", disfrazes);
			    return "tabladisfraz";
			}
			
			
			@PostMapping("/GuardarAlquiler")
			public String guardarAlquiler(Model model,@RequestBody Long id_cliente, @RequestBody Long id_disfraz ,@RequestParam String prestamo, @RequestParam String devolucion, @RequestParam String comentarios, @RequestParam String cantidad) throws ParseException {
				alquiler alquiler= new alquiler();
				cliente cli=new cliente();
				disfraz dis = new disfraz();
				
				System.out.println("AQUII ");
				double pr=0;
				int cat=0;
				
				for (int i = 0; i < clientes.size(); i++) {
					if(clientes.get(i).getId_cliente()==id_cliente) {
						cli.setId_cliente(clientes.get(i).getId_cliente());
						cli.setCedula_cliente(clientes.get(i).getCedula_cliente());
						cli.setNombre_cliente(clientes.get(i).getNombre_cliente());
						cli.setApellido_cliente(clientes.get(i).getApellido_cliente());
						cli.setDireccion_cliente(clientes.get(i).getDireccion_cliente());
						cli.setEstado_cliente(clientes.get(i).isEstado_cliente());
						cedula=clientes.get(i).getCedula_cliente();			}
				}
				
				for (int i = 0; i < disfrazes.size(); i++) {
					if(disfrazes.get(i).getId_disfraz()==id_disfraz) {
						dis.setId_disfraz(disfrazes.get(i).getId_disfraz());
						dis.setCodigo_disfraz(disfrazes.get(i).getCodigo_disfraz());
						dis.setDescripcion_disfraz(disfrazes.get(i).getDescripcion_disfraz());
						dis.setPrecio_disfraz(disfrazes.get(i).getPrecio_disfraz());
						dis.setTipo_disfraz(disfrazes.get(i).getTipo_disfraz());
						pr=disfrazes.get(i).getPrecio_disfraz();
						codigo=disfrazes.get(i).getCodigo_disfraz();
					}
				}
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				 java.util.Date date = dateFormat.parse(prestamo);
				 java.util.Date date2 = dateFormat.parse(devolucion);
				 
				Long total2 =(long)alquileres.size()+1;	
				System.out.println("Id "+total2);
				double totalalquiler= pr*Integer.parseInt(cantidad);
				
				alquiler.setId_alquiler((long)total2);
				System.out.println(alquiler.getId_alquiler());
				
				alquiler.setCliente(cli);
				alquiler.setDisfraz(dis);
				alquiler.setPrestamo(date);
				alquiler.setDevolucion(date2);
				alquiler.setCantidad_disfraces(Integer.parseInt(cantidad));
				alquiler.setTotal_alquiler(totalalquiler);
				alquiler.setComentarios_alquiler(comentarios);
				
				alquileres.add(alquiler);
				model.addAttribute("alquileres", alquileres);
				model.addAttribute("cedula", cedula);
				model.addAttribute("codigo", codigo);
				System.out.println("Codigo"+codigo+" Cedula: "+cedula+" Alquiler Guardado "+alquiler.getId_alquiler()+alquileres.size());
				return "redirect:/listaralquiler";
			}
			
			@GetMapping("/listaralquiler")
			public String listaralquiler(Model model) {
			    model.addAttribute("alquileres", alquileres);
			    model.addAttribute("codigo", codigo);
			    model.addAttribute("cedula", cedula);
			    return "tablaalquiler";
			}
			
	//EditarController
			@GetMapping("/clientes/editar")
			public String editarCliente(@RequestParam("id") Long idCliente, Model model) {
			    cliente cliente = null;
			    for (cliente c : clientes) { // Buscar el cliente en el array
			        if (c.getId_cliente() == idCliente) {
			            cliente = c;
			            break;
			        }
			    }
			    model.addAttribute("cliente", cliente); // Agregar el cliente al modelo
			    return "editarcliente"; // Devolver la vista del formulario de edición
			}

			@PostMapping("/clientes/editar")
			public String actualizarCliente(@ModelAttribute("cliente") cliente cliente) {
			    for (int i = 0; i < clientes.size(); i++) { // Buscar el cliente en el array y actualizarlo
			        if (clientes.get(i).getId_cliente() == cliente.getId_cliente()) {
			            clientes.set(i, cliente);
			            break;
			        }
			    }
			    return "redirect:/listarcliente"; // Redirigir a la vista de la lista de clientes
			}

	 
	 
			
	 /*@GetMapping("/listarcliente")
	    public String listarclliente(Model model) {
		 	
	        model.addAttribute("titulo", "¡Listado de clientes");
	        
	        return "tablacliente";
	    }
	 
	 @ModelAttribute("cliente")
	    public List<cliente> poblarClientes() {
		 	List<cliente> clientes = Arrays.asList(new cliente(null, "0106977176","Johann","Arizaga","sangurima",true),
		 			new cliente(null, "012932934","Lizeth","Orellana","trigales",true),
		 			new cliente(null, "02344343","Patrick","Mendez","llacao",true)
		 			);       
	        return clientes;
	    }*/
	 
		
		
		
	
	 
	 //RUTAS HTML
			
			 @GetMapping("/")
			    public String defaultPage() {
			        return "default";
			    }
	 @GetMapping("/disfraz")
	    public String ejemplo1(Model model) {
	        model.addAttribute("mensaje", "¡Hola desde Thymeleaf!");
	        return "disfraz";
	    }
	 
	 @GetMapping("/alquiler")
	    public String ejemplo2(Model model) {
	        model.addAttribute("clientes", clientes);
	        model.addAttribute("disfrazes", disfrazes);
	        return "alquiler";
	    }
	 

}
