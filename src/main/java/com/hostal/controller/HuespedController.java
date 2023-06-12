package com.hostal.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.hostal.dao.HuespedDao;
import com.hostal.modelo.Huesped;
import com.hostal.utiles.JPAUtils;


public class HuespedController {
	
	private HuespedDao huespedDao;
	
	private EntityManager em;
	
	public HuespedController() {
		em=JPAUtils.getEntityManager();
		huespedDao=new HuespedDao(em);
	}
	
	public void save(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.GuardarHuesped(huesped);
		em.getTransaction().commit();
	}

	public List<Huesped> list() {
		return huespedDao.listarHuesped();
	}

	public List<Huesped> search(String busqueda) {
		return huespedDao.buscarHuesped(busqueda);
	}

	public void removeById(Long id) {
		em.getTransaction().begin();
		huespedDao.eliminarHuespedPorId(id);;
		em.getTransaction().commit();
	}

	public Huesped getById(Long id) {
		return huespedDao.buscarHuespedPorId(id);
	}

	public void remove(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.eliminarHuesped(huesped);;
		em.getTransaction().commit();
	}
	
	public void update(Huesped huesped) {
		em.getTransaction().begin();
		huespedDao.actualizarHuesped(huesped);
		em.getTransaction().commit();
		
	}
}
