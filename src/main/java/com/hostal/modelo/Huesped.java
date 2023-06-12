package com.hostal.modelo;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="huespedes")
public class Huesped {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String nombre;
		private String apellido;
		private String documento;
		private Date fechaNacimiento;
		private String nacionalidad;
		private String telefono;
		
		@OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL)
		private List<Reserva> reserva = new ArrayList<Reserva>();
				
		public Huesped() {
			
		}
		
		public Huesped(String nombre, String apellido, String documento, Date fechaNacimiento,
				String nacionalidad, String telefono) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.documento = documento;
			this.fechaNacimiento = fechaNacimiento;
			this.nacionalidad = nacionalidad;
			this.telefono = telefono;
			
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}

		public Date getFechaNacimiento() {
			return fechaNacimiento;
		}

		public void setFechaNacimiento(Date fechaNacimiento) {
			this.fechaNacimiento = fechaNacimiento;
		}

		public String getNacionalidad() {
			return nacionalidad;
		}

		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public List<Reserva> getReserva() {
			return reserva;
		}

		public void setReserva(List<Reserva> reserva) {
			this.reserva = reserva;
		}

		public Object[] toArray() {
			return new Object[] {
					this.id.toString(),
					this.getNombre(),
					this.getApellido(),
					this.getDocumento(),
					this.getFechaNacimiento().toString(),
					this.getNacionalidad(),
					this.getTelefono(),
					this.reserva.size()+""
			};
		}
		
		@Override
		public String toString() {
			return "ID: " + documento + ", NOMBRE: " + nombre + ", APELLIDO: " + apellido + ", FECHA-NAC: "
					+ fechaNacimiento + ", NACIONALIDAD: " + nacionalidad + ", TELEFONO: " + telefono + ", N° RESERVA: "
					+ reserva + "]";
		}
	}

