package com.hostal.test;

import javax.persistence.EntityManager;

import com.hostal.dao.UsuarioDao;
import com.hostal.modelo.Usuario;
import com.hostal.utiles.JPAUtils;

public class RegistroDeUsuarios {

	public static void main(String[] args) {
		RegistroDeUsuarios();
				
	}

	private static void RegistroDeUsuarios() {
		Usuario user = new Usuario("jose", "12345");
		
		EntityManager em = JPAUtils.getEntityManager();
		UsuarioDao usuarioDao = new UsuarioDao(em);
		
		em.getTransaction().begin();
		usuarioDao.GuardarUsuario(user);
		em.getTransaction().commit();
		em.close();
		
		
		
	}

}
