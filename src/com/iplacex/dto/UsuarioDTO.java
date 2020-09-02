package com.iplacex.dto;

public class UsuarioDTO {
	private String nombreUsuario;
	private String passUsuario;
	private Integer rutUsuario;
	public UsuarioDTO() {		
	}	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassUsuario() {
		return passUsuario;
	}
	public void setPassUsuario(String passUsuario) {
		this.passUsuario = passUsuario;
	}
	public Integer getRutUsuario() {
		return rutUsuario;
	}
	public void setRutUsuario(Integer rutUsuario) {
		this.rutUsuario = rutUsuario;
	}
}
