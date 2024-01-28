package edu.jsp.Testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test2 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","scott","tiger");
			System.out.println("connection Successfull...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
