package com.rays.jdbc.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateConnection {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rays","root","root");
		System.out.println("Connection established successfully..."+conn.getCatalog());
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs =stmt.executeQuery("select * from marksheet");
		
		while(rs.next()) {
			System.out.println("Id : "+rs.getInt("id"));
			System.out.println("Roll No. : "+rs.getString("rollno"));
			System.out.println("Name : "+rs.getString("name"));
			System.out.println("Physics : "+rs.getInt("physics"));
			System.out.println("Chemistry : "+rs.getInt("chemistry"));
			System.out.println("Maths : "+rs.getInt("maths"));
			System.out.println("-------------------");
			int total = (rs.getInt("physics")+rs.getInt("chemistry")+rs.getInt("maths"));
			System.out.println("Total Marks : "+total);
			double percentage = total/3;
			System.out.println("Percentage : "+percentage);
			System.out.println("-------------------");
			
		}
		}

		

}
