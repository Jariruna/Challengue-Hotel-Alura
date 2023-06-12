package com.hostal.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost/hotel_vales?useTimeZone=true&serverTimeZone=UTC", 
				"root",
				"root1234");
		
		System.out.println("estamos cerrando la conexion");
		
		con.close();
		
	}

}
