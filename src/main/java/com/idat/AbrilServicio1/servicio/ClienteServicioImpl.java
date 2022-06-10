package com.idat.AbrilServicio1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicio1.dto.ClienteDTORequest;
import com.idat.AbrilServicio1.dto.ClienteDTOResponse;
import com.idat.AbrilServicio1.modelo.Clientes;
import com.idat.AbrilServicio1.repositorio.ClienteRepositorio;

@Service
public class ClienteServicioImpl implements ClienteServicio{

	@Autowired
	public ClienteRepositorio repositorio;
	
	@Override
	public void guardarcliente(ClienteDTORequest cliente) {
		Clientes c = new Clientes();
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setCliente(cliente.getClienteDTO());
		c.setCelular(cliente.getCelularDTO());
		repositorio.save(c);
	}
	

	@Override
	public void editarCliente(ClienteDTORequest cliente) {
		Clientes c = new Clientes();
		c.setIdCliente(cliente.getIdClienteDTO());
		c.setCliente(cliente.getClienteDTO());
		c.setCelular(cliente.getCelularDTO());
		repositorio.saveAndFlush(c);		
	}
	

	@Override
	public void eliminarCliente(Integer id) {
		repositorio.deleteById(id);		
	}
	

	@Override
	public List<ClienteDTOResponse> listarClientes() {
		List<ClienteDTOResponse> lista = new ArrayList<ClienteDTOResponse>();
		ClienteDTOResponse c = null;
		
		for (Clientes cliente : repositorio.findAll()) {
			c = new ClienteDTOResponse();
			c.setIdClienteDTO(cliente.getIdCliente());
			c.setClienteDTO(cliente.getCliente());
			c.setCelularDTO(cliente.getCelular());
			lista.add(c);					
		}		
		return lista;
	}
	

	@Override
	public ClienteDTOResponse obtenerClientexId(Integer id) {
		
		Clientes cliente = repositorio.findById(id).orElse(null);
		
		ClienteDTOResponse c = new ClienteDTOResponse();
		c.setIdClienteDTO(cliente.getIdCliente());
		c.setClienteDTO(cliente.getCliente());
		c.setCelularDTO(cliente.getCelular());
		return c;			
	}



	
	
	

}
