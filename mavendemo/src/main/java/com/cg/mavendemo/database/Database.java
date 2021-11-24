package com.cg.mavendemo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	public static void db() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
		
		String query = "select * from product_tb";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);		
		
		System.out.println("-----------------------values----------------------");
		while(rs.next()){
			System.out.println("ID : "+rs.getInt(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("-----------------");
		}
	}
	
	public static void add() throws SQLException, ClassNotFoundException {
		String enter = "insert into product_tb values (?, ?)";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "root");
	    PreparedStatement ps = con.prepareStatement(enter);
	    
	    ps.setInt(1, 3);
	    ps.setString(2, "c");
	    
	    ps.executeUpdate();
	    
	    System.out.println("value Entered");
	    
	    db();
	    
	}
}
