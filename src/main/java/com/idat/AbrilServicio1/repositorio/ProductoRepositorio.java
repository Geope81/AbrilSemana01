package com.idat.AbrilServicio1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.AbrilServicio1.modelo.Productos;

@Repository
public interface ProductoRepositorio extends JpaRepository<Productos, Integer> {
	
	
	

}
