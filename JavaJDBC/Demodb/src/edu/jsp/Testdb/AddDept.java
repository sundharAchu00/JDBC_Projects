package edu.jsp.Testdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddDept {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","root");
			PreparedStatement s = con.prepareStatement("INSERT INTO `employee`.`dept` (`deptno`, `dname`, `city`) VALUES ( ? , ? , ?);");
			System.out.println("Enter how many dept do you want to add");
			int n=sc.nextInt(),no;
//			s.setInt(1, 5); s.setString(2, "'computer science'"); s.setString(3,"'chennai'");
			
			String dname,dcity;
			for (int i = 0; i < n; i++) {
				System.out.println("Enter The Department Number ");
				no = sc.nextInt();
				s.setInt(1, no);
				System.out.println("Enter The Department Name ");
				dname = sc.next();
				s.setString(2, dname);
				System.out.println("Enter The Department City ");
//				sc.next();
				dcity = sc.next();
				s.setString(3, dcity);
				s.executeUpdate();
			}
			System.out.println(" record added successfully");
			s.close();
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
}
