package com.idat.AbrilServicio1.dto;

public class ItemDTOResponse {
	
	private Integer idItemDTO;
	private String itemDTO;
	private Integer cantidadDTO;
	private Double totalDTO;
	
	public Integer getIdItemDTO() {
		return idItemDTO;
	}
	public void setIdItemDTO(Integer idItemDTO) {
		this.idItemDTO = idItemDTO;
	}
	public String getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(String itemDTO) {
		this.itemDTO = itemDTO;
	}
	public Integer getCantidadDTO() {
		return cantidadDTO;
	}
	public void setCantidadDTO(Integer cantidadDTO) {
		this.cantidadDTO = cantidadDTO;
	}
	public Double getTotalDTO() {
		return totalDTO;
	}
	public void setTotalDTO(Double totalDTO) {
		this.totalDTO = totalDTO;
	}
}
