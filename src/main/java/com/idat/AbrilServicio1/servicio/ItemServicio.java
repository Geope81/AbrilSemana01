package com.idat.AbrilServicio1.servicio;

import java.util.List;

import com.idat.AbrilServicio1.dto.ItemDTORequest;
import com.idat.AbrilServicio1.dto.ItemDTOResponse;

public interface ItemServicio {
	
	public void guardarItem(ItemDTORequest item);
	public void editarItem(ItemDTORequest item);
	public void eliminarItem(Integer id);
	public List<ItemDTOResponse> listarItems();
	public ItemDTOResponse obtenerItemxId(Integer id);
}
