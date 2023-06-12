package com.hostal.controller;



import java.util.List;

import javax.persistence.EntityManager;

import com.hostal.dao.ReservaDao;
import com.hostal.modelo.Reserva;
import com.hostal.utiles.JPAUtils;

public class ReservaController {
	
	private ReservaDao reservaDao;
	
	private EntityManager em;
	
	public ReservaController() {
		em=JPAUtils.getEntityManager();
		reservaDao=new ReservaDao(em);
	}
	
	public void save(Reserva reserva) { 
		em.getTransaction().begin();
		reservaDao.guardarReserva(reserva);;
		em.getTransaction().commit();
	}
		
	public void update(Reserva reserva) {
		em.getTransaction().begin();
		reservaDao.ActualizarReserva(reserva);;
		em.getTransaction().commit();
	}
	
	public Reserva getById(Long id) {
		return reservaDao.buscarReservaPorId(id);
	}
	
	public List<Reserva> list(){
		return reservaDao.listarReserva();
	}
	
	public List<Reserva> search(String busqueda) {
		return reservaDao.BucarReserva(busqueda);
	}

	
	public void removeById(Long id) {
		em.getTransaction().begin();
		reservaDao.eliminarReservaPorId(id);;
		em.getTransaction().commit();
	}

	public void removeReservasWithHuespedId(Long id) {
		em.getTransaction().begin();
		reservaDao.eliminarReservasConHuespedId(id);;
		em.getTransaction().commit();
	}
}
