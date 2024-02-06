package com.ipartek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.model.Categoria;
import com.ipartek.model.Vivienda;
import com.ipartek.repository.CategoriaRepository;
import com.ipartek.repository.ViviendaRepository;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;

@Service
public class InicializarDatos {
	@Autowired
	private ViviendaRepository viviendaRepo;
	
	@Autowired
	private CategoriaRepository catRepo;
	
	@PostConstruct
	@Transactional
	public void cargarDatosBD(){
		// añadir aqui las viviendas
		
		
		// categorias
		catRepo.save(new Categoria(1, "Venta"));
		catRepo.save(new Categoria(2, "Alquiler"));
	}
}
