package com.hostal.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.hostal.modelo.Huesped;




public class HuespedDao {
	private EntityManager em;

	public HuespedDao() {}

	public HuespedDao(EntityManager em) {
		this.em = em;
	}
	
	public Huesped buscarHuespedPorId(Long id) {
		return em.find(Huesped.class, id);
	}
	
	public List<Huesped> listarHuesped(){
		final String jpql="SELECT h FROM Huesped h";
		return em.createQuery(jpql,Huesped.class).getResultList();
	}
	
	public void eliminarHuesped(Huesped huesped) {
		Huesped h=em.merge(huesped);
		em.remove(h);
	}
	
	public void GuardarHuesped(Huesped huesped) {
		em.persist(huesped);
	}
	
	public void  actualizarHuesped(Huesped huesped) {
		em.merge(huesped);
	}
	
	public List<Huesped> buscarHuesped(String busqueda) {
		final String jqpl="SELECT h FROM Huesped AS h WHERE"
					+" h.nombre   LIKE '%'||:busqueda||'%' OR"
					+" h.apellido LIKE '%'||:busqueda||'%' OR"
					+" h.fechaNacimiento LIKE '%'||:busqueda||'%' OR"
					+" h.nacionalidad LIKE '%'||:busqueda||'%' OR"
					+" h.telefono LIKE '%'||:busqueda||'%'";
					
		return em.createQuery(jqpl,Huesped.class).setParameter("busqueda",busqueda).getResultList();
	}

	public void eliminarHuespedPorId(Long id) {
		final String jpql="DELETE FROM Huesped h WHERE h.Id=:id";
		em.createQuery(jpql).setParameter("id",id).executeUpdate();
	}
}
