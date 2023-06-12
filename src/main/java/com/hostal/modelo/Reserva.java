package com.hostal.modelo;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date fechaEntrada;
	private Date fechaSalida;
	private BigDecimal valor = new BigDecimal(0);
	private String formaPago;
		
	@ManyToOne(fetch=FetchType.LAZY)
	private Huesped huesped;
	
	
	public Reserva() {
		
	}
	

	public Reserva(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago) {
		
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		
	}
	
	public Reserva(Date fechaEntrada, Date fechaSalida, BigDecimal valor, String formaPago, Huesped huesped) {
		
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
		this.huesped = huesped;
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getFechaEntrada() {
		return fechaEntrada;
	}


	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public Date getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getFormaPago() {
		return formaPago;
	}


	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}


	public Huesped getHuesped() {
		return huesped;
	}


	public void setHuesped(Huesped huesped) {
		this.huesped = huesped;
	}


	public Object[] toArray() {
		return new Object[] {
			this.id.toString(),
			this.fechaEntrada.toString(),
			this.fechaSalida.toString(),
			this.valor.toString(),
			this.getFormaPago()
		};
	}


	@Override
	public String toString() {
		return "Reservas [ ID: " + id + ", FECHA ENTRADA: " + fechaEntrada + ", FECHA SALIDA: " + fechaSalida + ", VALOR: "
				+ valor + ", FORMA DE PAGO: " + formaPago + " ]";
	}
	
	
	
	

}
