package edu.jsp.execute;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DbExecute {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Connection c =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			PreparedStatement ps = c.prepareStatement("insert into student_table values(null,?,?,?,?)");
			System.out.println("Enter Your Name :");
			ps.setString(1, sc.next());
			System.out.println("Enter marks :");
			ps.setDouble(2, sc.nextDouble());
			System.out.println("Enter student age");
			ps.setInt(3, sc.nextInt());
			System.out.println("Enter Exam number");
			ps.setLong(4, sc.nextLong());
			boolean b = ps.execute();
			if (b==false) {
				System.out.println("data inserted successfully");
			}else {
				System.err.println("Data Not Inserted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
