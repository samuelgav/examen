package pe.com.examen.model;

import java.io.Serializable;

import pe.com.examen.dto.Direccion;
import pe.com.examen.dto.Usuario;

public class RegisterModel implements Serializable{

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private Direccion direccion;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
}
