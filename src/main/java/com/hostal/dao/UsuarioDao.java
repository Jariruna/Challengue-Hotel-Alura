package com.hostal.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hostal.modelo.Usuario;
import com.hostal.utiles.JPAUtils;


public class UsuarioDao {
	
	private EntityManager em;
	
	/*public UsuarioDao() {
		
	}*/
			
	public UsuarioDao(EntityManager em) {
		this.em = em;
	}

	
	public void eliminarUsuario(Usuario usuario) {
		Usuario u =em.merge(usuario);
		em.remove(u);
	}
	
	public void GuardarUsuario(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void  actualizarUsuario(Usuario usuario) {
		em.merge(usuario);
	}
	
	
	
	
	
	

}
