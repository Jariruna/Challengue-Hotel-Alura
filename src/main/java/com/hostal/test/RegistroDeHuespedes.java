package com.hostal.test;


import java.math.BigDecimal;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

import com.hostal.dao.HuespedDao;
import com.hostal.dao.ReservaDao;
import com.hostal.modelo.Huesped;
import com.hostal.modelo.Reserva;
import com.hostal.utiles.JPAUtils;



public class RegistroDeHuespedes {
		
		public static void main(String[] args) {
		RegistroDeHuespedes();
							
		}

		private static void RegistroDeHuespedes() {
		
		Huesped huesped1=new Huesped("valentino", "jallo", "64565373", Date.valueOf("2008-09-09"), "peruano", "86895759");
		
		
		List<Reserva> reservas=Arrays.asList(
				new Reserva(Date.valueOf("2023-06-11"), Date.valueOf("2023-06-14"), new BigDecimal("130"), "Tarjeta de credito", huesped1));
		
		
		
		EntityManager em = JPAUtils.getEntityManager();
		HuespedDao huespedDao=new HuespedDao(em);
		ReservaDao reservaDao=new ReservaDao(em);
		
		em.getTransaction().begin();
		
				
		huespedDao.GuardarHuesped(huesped1);
		
		reservas.forEach(res -> reservaDao.guardarReserva(res));
		
		em.getTransaction().commit();
		
		List<Reserva> list = reservaDao.listarReserva();
		list.stream().map(Reserva::getHuesped).map(Huesped::getNombre).forEach(System.out::println);
		
		
		em.close();
		}
		
		

}
