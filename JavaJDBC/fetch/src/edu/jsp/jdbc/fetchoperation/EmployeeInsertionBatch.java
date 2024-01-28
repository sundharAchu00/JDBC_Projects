package edu.jsp.jdbc.fetchoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeInsertionBatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection c = null;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c= DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
				
				PreparedStatement ps =  c.prepareStatement("insert into emp values(?,?,?,?,?)");
			
				System.out.println("enter how many details want to Enter ");
				int n= sc.nextInt();
				
				for (int i = 0; i < n; i++) {
					System.out.println("Enter Employee id :");
					ps.setInt(1, sc.nextInt());
					System.out.println("Enter Employee Name");
					ps.setString(2, sc.next());
					System.out.println("Enter Employee Number");
					ps.setLong(3, sc.nextLong());
					System.out.println("Enter Employee salary :");
					ps.setDouble(4, sc.nextDouble());
					System.out.println("Enter Employee deptNo :");
					ps.setInt(5, sc.nextInt());
					System.out.println("-----------------------");
					
					ps.addBatch();
				}
				
				ps.executeBatch();
				ps.clearBatch();
				
				System.out.println("Entered Data inserted successfully...");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
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
