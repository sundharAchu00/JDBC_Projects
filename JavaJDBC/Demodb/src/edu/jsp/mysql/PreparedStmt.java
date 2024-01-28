package edu.jsp.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStmt {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");

			PreparedStatement ps = c.prepareStatement("insert into movie values(?,?)");

			System.out.println("enter movie id");
			int id = s.nextInt();
			
			System.out.println("enter movie Name");
			String name = s.next();
			ps.setInt(2, id);
			ps.setString(1, name);
			ps.executeUpdate();
			System.out.println("updated Successfully");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
