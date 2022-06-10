package com.idat.AbrilServicio1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.AbrilServicio1.dto.ClienteDTORequest;
import com.idat.AbrilServicio1.dto.ClienteDTOResponse;
import com.idat.AbrilServicio1.servicio.ClienteServicio;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteControlador {
	
	@Autowired
	private ClienteServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTOResponse>> listarCliente(){
		return new ResponseEntity<List<ClienteDTOResponse>>(servicio.listarClientes(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarCliente(@RequestBody ClienteDTORequest cliente){
		servicio.guardarcliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ClienteDTOResponse> listarPorId(@PathVariable Integer id){
		ClienteDTOResponse c = servicio.obtenerClientexId(id);
		if(c != null)
			return new ResponseEntity<ClienteDTOResponse>(c, HttpStatus.OK);
		return new ResponseEntity<ClienteDTOResponse>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editarCliente(@RequestBody ClienteDTORequest cliente){
		ClienteDTOResponse c = servicio.obtenerClientexId(cliente.getIdClienteDTO());
		if(c != null) {
			servicio.editarCliente(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarCliente(@PathVariable Integer id){
		ClienteDTOResponse c = servicio.obtenerClientexId(id);
		if(c != null) {
			servicio.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
}
