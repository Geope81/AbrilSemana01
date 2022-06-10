package com.idat.AbrilServicio1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.AbrilServicio1.modelo.Usuarios;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Integer> {
	
	Usuarios findByUsuario(String usuario);
	Usuarios findByPassword(String password);
	Usuarios findByrol(String rol);

}
