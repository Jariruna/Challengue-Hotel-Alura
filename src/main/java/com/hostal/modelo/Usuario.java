package com.hostal.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usuario;
	private String contrasenia;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String usuario, String contrasenia) {
		this.id = id;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}
	
	public Usuario(String usuario, String contrasenia) {
		
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	public Object[] toArray() {
		return new Object[] {
				this.id.toString(),
				this.getUsuario(),
				this.getContrasenia(),
				
		};
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + usuario + ", contrasenia=" + contrasenia + "]";
	}
	
		
	
}
