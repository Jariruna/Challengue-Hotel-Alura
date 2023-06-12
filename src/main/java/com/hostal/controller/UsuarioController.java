package com.hostal.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hostal.dao.UsuarioDao;
import com.hostal.modelo.Usuario;
import com.hostal.utiles.JPAUtils;


public class UsuarioController {
	
	private UsuarioDao usuarioDao;
	
	private EntityManager em;
	
	public UsuarioController() {
		em=JPAUtils.getEntityManager();
		usuarioDao = new UsuarioDao(em);
	}
	
	public void guardarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		usuarioDao.GuardarUsuario(usuario);;
		em.getTransaction().commit();
	}
		
	public void eliminarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		usuarioDao.eliminarUsuario(usuario);
		em.getTransaction().commit();
	}
	
	public void actualizarUsuario(Usuario usuario) {
		em.getTransaction().begin();
		usuarioDao.actualizarUsuario(usuario);
		em.getTransaction().commit();
		
	}
	
	public boolean login (String usuario, String contrasenia) {
		EntityManager em = JPAUtils.getEntityManager();
		boolean valor;
				
		try {
			Query query = em.createQuery("select u.usuario, u.contrasenia from Usuario u where u.contrasenia = :contrasenia AND u.usuario = :usuario");
			query.setParameter("usuario", usuario);
			query.setParameter("contrasenia", contrasenia);
			List resultado = query.getResultList();
			if(!resultado.isEmpty()) {
				valor = true;
			}else {
				valor = false;
			}
		}catch (Exception e){
			valor = false;
			
		}
		return valor;
	}
}
