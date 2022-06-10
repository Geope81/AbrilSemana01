package com.idat.AbrilServicio1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.AbrilServicio1.dto.ItemDTORequest;
import com.idat.AbrilServicio1.dto.ItemDTOResponse;

import com.idat.AbrilServicio1.modelo.Items;
import com.idat.AbrilServicio1.repositorio.ItemRepositorio;


@Service
public class ItemServicioImpl implements ItemServicio{
	
	@Autowired
	public ItemRepositorio repositorio;
	
	
	@Override
	public void guardarItem(ItemDTORequest item) {
		Items i = new Items();
		i.setIdItem(item.getIdItemDTO());
		i.setItem(item.getItemDTO());
		i.setCantidad(item.getCantidadDTO());
		i.setTotal(item.getTotalDTO());
		repositorio.save(i);		
	}
	

	@Override
	public void editarItem(ItemDTORequest item) {
		Items i = new Items();
		i.setIdItem(item.getIdItemDTO());
		i.setItem(item.getItemDTO());
		i.setCantidad(item.getCantidadDTO());
		i.setTotal(item.getTotalDTO());
		repositorio.saveAndFlush(i);		
	}
	

	@Override
	public void eliminarItem(Integer id) {
		repositorio.deleteById(id);		
	}
	

	@Override
	public List<ItemDTOResponse> listarItems() {
		List<ItemDTOResponse> lista = new ArrayList<ItemDTOResponse>();
		ItemDTOResponse i = null; 
		
		for (Items item : repositorio.findAll()) {
			i = new ItemDTOResponse();
			i.setIdItemDTO(item.getIdItem());
			i.setItemDTO(item.getItem());
			i.setCantidadDTO(item.getCantidad());
			i.setTotalDTO(item.getTotal());			
			lista.add(i);
		}		
		return lista;
	}
	

	@Override
	public ItemDTOResponse obtenerItemxId(Integer id) {
		Items item = repositorio.findById(id).orElse(null);
		
		ItemDTOResponse i = new ItemDTOResponse();
		i.setIdItemDTO(item.getIdItem());
		i.setItemDTO(item.getItem());
		i.setCantidadDTO(item.getCantidad());
		i.setTotalDTO(item.getTotal());		
		return i;
	}
}
