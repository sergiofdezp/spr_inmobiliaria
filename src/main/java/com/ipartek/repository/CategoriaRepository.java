package com.ipartek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ipartek.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
