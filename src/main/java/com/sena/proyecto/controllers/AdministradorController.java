package com.sena.proyecto.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.proyecto.service.ICategoriaService;
import com.sena.proyecto.service.IClienteService;
import com.sena.proyecto.service.IDomiciliarioService;
import com.sena.proyecto.service.IDomicilioService;
import com.sena.proyecto.service.IEmpleadoService;
import com.sena.proyecto.service.IProductoService;
import com.sena.proyecto.service.IVentaService;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	@Autowired
	private ICategoriaService categoriaService;
	
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IDomiciliarioService domiciliarioService;
	
	@Autowired
	private IDomicilioService domicilioService;
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IProductoService productoService;

	@Autowired
	private IVentaService ventaService;
	

	@GetMapping("")
	public String home(Model model) {

		return "administrador/index";
	}	

	@GetMapping("/categoria")
	public String categoria(Model model) {
		model.addAttribute("categoria", categoriaService.findAll());
		return "administrador/categoria";
	} 

	@GetMapping("/cliente")
	public String cliente(Model model) {
		model.addAttribute("cliente", clienteService.findAll());
		return "administrador/cliente";
	} 

	@GetMapping("/domiciliarios")
	public String domiciliario(Model model) {
		model.addAttribute("domiciliario", domiciliarioService.findAll());
		return "administrador/domiciliarios";
	} 

	@GetMapping("/domicilios")
	public String domicilio(Model model) {
		model.addAttribute("domicilio", domicilioService.findAll());
		return "administrador/domicilios";
	} 

	@GetMapping("/empleado")
	public String empleado(Model model) {
		model.addAttribute("empleado", empleadoService.findAll());
		return "administrador/empleado";
	} 

	@GetMapping("/producto")
	public String producto(Model model) {
		model.addAttribute("ventas", productoService.findAll());
		return "administrador/producto";
	} 

	@GetMapping("/venta")
	public String ventas(Model model) {
		model.addAttribute("ventas", ventaService.findAll());
		return "administrador/venta";
	} 
}
