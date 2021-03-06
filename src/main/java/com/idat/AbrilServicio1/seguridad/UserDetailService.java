package com.idat.AbrilServicio1.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicio1.modelo.Usuarios;
import com.idat.AbrilServicio1.repositorio.UsuarioRepositorio;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuario = repositorio.findByUsuario(username);
		if(usuario != null) {
			List<GrantedAuthority> granted = new ArrayList<GrantedAuthority>();
			GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol());
			granted.add(authority);		
			
			return new User(usuario.getUsuario(), usuario.getPassword(), granted);
		}else {
			throw new UsernameNotFoundException("El Usuario no Existe");
		}
				
	}		
}
