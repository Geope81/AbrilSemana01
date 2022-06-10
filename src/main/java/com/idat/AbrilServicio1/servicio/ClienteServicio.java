package com.idat.AbrilServicio1.servicio;

import java.util.List;

import com.idat.AbrilServicio1.dto.ClienteDTORequest;
import com.idat.AbrilServicio1.dto.ClienteDTOResponse;

public interface ClienteServicio {
	
	public void guardarcliente(ClienteDTORequest cliente);
	public void editarCliente(ClienteDTORequest cliente);
	public void eliminarCliente(Integer id);
	public List<ClienteDTOResponse> listarClientes();
	public ClienteDTOResponse obtenerClientexId(Integer id);
}
