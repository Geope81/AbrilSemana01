package com.idat.AbrilServicio1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.AbrilServicio1.modelo.Clientes;

@Repository
public interface ClienteRepositorio extends JpaRepository<Clientes, Integer>{

}
