package com.ipartek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Vivienda;
import com.ipartek.repository.ViviendaRepository;

@Controller
public class MainController {
	@Autowired
	private ViviendaRepository viviendaRepo;
	
	@RequestMapping("/")
	public String cargarHome(Model model) {
		List<Vivienda> listaViviendas = viviendaRepo.findAll();		
		model.addAttribute("atr_lista_viviendas", listaViviendas);
		
		// System.out.println(listaViviendas);
		
		return "index";
	}
	
	@RequestMapping("/alquileres")
	public String cargarAlquileres(Model model) {
		List<Vivienda> listaAlquileres = viviendaRepo.obtenerViviendasPorCateg(2);
		model.addAttribute("atr_lista_alquileres", listaAlquileres);
		
		System.out.println(listaAlquileres);
		
		return "alquileres";
	}
	
	@RequestMapping("/ventas")
	public String cargarVentas(Model model) {
		List<Vivienda> listaVentas = viviendaRepo.obtenerViviendasPorCateg(1);
		model.addAttribute("atr_lista_ventas", listaVentas);
		
		System.out.println(listaVentas);
		
		return "ventas";
	}
}
