package com.rays.college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		
		Statement stmt =conn.createStatement();
		
		int i =stmt.executeUpdate("insert into college values(101, 'Acropolis Institute', 'Indore', 'RGPV', 987654321),(102, 'Medicaps University', 'Indore', 'Medicaps University', 912345678),(103, 'IPS Academy', 'Indore', 'DAVV', 998877665),(104, 'SGSITS', 'Indore', 'RGPV', 987123456),(105, 'IET DAVV', 'Indore', 'DAVV', 976543210)");
		System.out.println("data inserted: "+i+ " rows affected");
		
		
	}

}
