package edu.jsp.Testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import com.mysql.jdbc.Driver;

public class Test1 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			//1.load or register
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.get connection
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			//3.create statement
			Statement stmt = (Statement) conn.createStatement();
			System.out.println("Enter Number of Employee You want to add : ");
			int n=sc.nextInt();
			int id;
			String nam;
			double sal;
			long p_no;
			for (int i = 1; i <= n; i++) {
				System.out.println("Enter "+ i+"st Employee ");
				System.out.println("Enter Employee ID :");
				id = sc.nextInt();
				System.out.println("Enter Employee NAME :");
				nam = sc.next();
				System.out.println("Enter Employee PHONE_NUMBER :");
				p_no=sc.nextLong();
				System.out.println("Enter Employee SALARY :");
				sal = sc.nextDouble();
				//4.create query
				stmt.executeUpdate("INSERT INTO `employee`.`emp` VALUES ("+id+","+"'"+nam+"'"+","+p_no+", "+sal+");");
			}
			//5.close connection
			stmt.close();
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
	}
}
