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

import com.idat.AbrilServicio1.dto.ItemDTORequest;
import com.idat.AbrilServicio1.dto.ItemDTOResponse;
import com.idat.AbrilServicio1.servicio.ItemServicio;

@RestController
@RequestMapping("/items/v1")
public class ItemControlador {
	
	@Autowired
	private ItemServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<ItemDTOResponse>> listarItem(){
		return new ResponseEntity<List<ItemDTOResponse>>(servicio.listarItems(), HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardarItem(@RequestBody ItemDTORequest item){
		servicio.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<ItemDTOResponse> listarPorId(@PathVariable Integer id){
		ItemDTOResponse i = servicio.obtenerItemxId(id);
		if(i != null)
			return new ResponseEntity<ItemDTOResponse>(i, HttpStatus.OK);
		return new ResponseEntity<ItemDTOResponse>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/editar")
	public ResponseEntity<Void> editarItem(@RequestBody ItemDTORequest item){
		ItemDTOResponse i = servicio.obtenerItemxId(item.getIdItemDTO());
		if(i != null) {
			servicio.editarItem(item);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminarItem(@PathVariable Integer id){
		ItemDTOResponse i = servicio.obtenerItemxId(id);
		if(i != null) {
			servicio.eliminarItem(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} 
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);		
	}

}
