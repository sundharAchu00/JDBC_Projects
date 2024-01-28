package edu.jsp.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrivingDatadb {
	public static void main(String[] args) {
		
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			Statement s = c.createStatement();//static way
			boolean b = s.execute("select * from student_table");
			if (b) {
				
				ResultSet rs = s.getResultSet();
				
				while (rs.next()) {
					
					System.out.println("Student ID : "+rs.getInt(1));
					System.out.println("Student Name : "+rs.getString(2));
					System.out.println("Student Marks : "+rs.getDouble(3));
					System.out.println("Student Age : "+rs.getInt(4));
					System.out.println("Student ID : "+rs.getLong(5));
					System.out.println("----------------------");
				}
			} else {
				System.out.println("No Data Found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
