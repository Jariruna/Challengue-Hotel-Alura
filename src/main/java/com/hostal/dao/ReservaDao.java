package com.hostal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.hostal.modelo.Reserva;



public class ReservaDao {
	private EntityManager em;

	public ReservaDao() {}

	public ReservaDao(EntityManager em) {
		this.em = em;
	}
	
	public Reserva buscarReservaPorId(Long id) {
		return em.find(Reserva.class, id);
	}
	
	public List<Reserva> listarReserva(){
		final String jpql="SELECT r FROM Reserva AS r";
		return em.createQuery(jpql,Reserva.class).getResultList();
	}
	
	public void eliminarReserva(Reserva reserva) {
		Reserva h=em.merge(reserva);
		em.remove(h);
	}
	
	public void guardarReserva(Reserva reserva) {
		em.persist(reserva);
	}
	
	public void  ActualizarReserva(Reserva reserva) {
		em.merge(reserva);
	}

	public List<Reserva> BucarReserva(String busqueda) {
		final String jpql="SELECT r FROM Reserva r WHERE"
				+" r.fechaEntrada LIKE '%'||:busqueda||'%' OR"
				+" r.fechaSalida LIKE '%'||:busqueda||'%' OR"
				+" CAST(r.valor AS java.lang.String)=:busqueda OR"
				+" r.formaPago LIKE '%'||:busqueda||'%'";
		
		return em.createQuery(jpql,Reserva.class).setParameter("busqueda",busqueda).getResultList();
	}

	public void eliminarReservaPorId(Long id) {
		final String jpql="DELETE FROM Reserva r WHERE r.Id=:id";
		em.createQuery(jpql).setParameter("id",id).executeUpdate();
	}
	
	public void eliminarReservasConHuespedId(Long id) {
		final String jpql="DELETE FROM Reserva r WHERE r.huesped.Id=:id";
		em.createQuery(jpql).setParameter("id",id).executeUpdate();
	}
}
