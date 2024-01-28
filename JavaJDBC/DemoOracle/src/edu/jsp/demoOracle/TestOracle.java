package edu.jsp.demoOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestOracle {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("loading done...");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcle","scott","tiger");
			System.out.println("Connection done...");
			Statement s = c.createStatement();
			s.executeUpdate("insert into movieRating values('vikram',2)");
			System.out.println("Updation done...");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
