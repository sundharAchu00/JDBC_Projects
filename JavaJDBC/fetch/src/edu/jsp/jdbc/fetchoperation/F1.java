package edu.jsp.jdbc.fetchoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class F1 {
	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","root");
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery("select * from movie");
			while (rs.next()) {
				System.out.println("movie ID : "+rs.getInt(1)+" movie Name : "+rs.getString(2));
			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
