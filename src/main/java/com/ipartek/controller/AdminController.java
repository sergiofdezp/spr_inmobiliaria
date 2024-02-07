package com.ipartek.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.model.Categoria;
import com.ipartek.model.Vivienda;
import com.ipartek.repository.CategoriaRepository;
import com.ipartek.repository.ViviendaRepository;

@Controller
public class AdminController {
	@Autowired
	private ViviendaRepository viviendaRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@RequestMapping("/form_modificar_vivienda/{id}")
	public String cargarModificarMascota(@PathVariable int id, Model model) {
		Optional<Vivienda> vivienda = viviendaRepo.findById(id);
		List<Categoria> listaCategorias = categoriaRepo.findAll();
		
		model.addAttribute("atr_lista_categorias", listaCategorias);
		model.addAttribute("objeto_entidad", vivienda);
		
		return "form_modificar_vivienda";
	}
	
	@RequestMapping("/modificar_mascota")
	public String ModificarMascota(@ModelAttribute Vivienda objeto_entidad, Model model) {
		viviendaRepo.save(objeto_entidad);
		
		List<Vivienda> listaViviendas = viviendaRepo.findAll();		
		List<Vivienda> listaVentas = viviendaRepo.obtenerViviendasPorCateg(1);
		List<Vivienda> listaAlquileres = viviendaRepo.obtenerViviendasPorCateg(2);
		
		model.addAttribute("atr_lista_viviendas", listaViviendas);
		model.addAttribute("atr_lista_ventas", listaVentas);
		model.addAttribute("atr_lista_alquileres", listaAlquileres);

		return "index";
	}
}
