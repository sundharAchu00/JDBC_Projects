package emp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("1.insert\n2.update\n3.fetchAll\n4.fetchbyemail");
		int input=sc.nextInt();
		
		switch (input) {
		case 1: {
			insert();
			break;
		}
		case 2:{
			update();
			break;
		}
		case 3:{
			fetchAll();
			break;
		}
		case 4:{
			fetchbyemai();
			break;
		}
		default:
			System.out.println("enter crct input");
			break;
		}
	}
	
	//insert
	public static void insert() {
		Connection c=null;
		System.out.println("Enter how many data you enter");
		int n=sc.nextInt();
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
		
		PreparedStatement ps=c.prepareStatement("insert into employee values(?,?,?,?,?,?,?);");
//		System.out.println("connection syccessfully");
		
		for (int i = 0; i < n; i++) {
			System.out.println("enter the id");
			ps.setInt(1, sc.nextInt());
			System.out.println("enter the name");
			ps.setString(2, sc.next());
			System.out.println("enter the job");
			ps.setString(3, sc.next());
			System.out.println("enter the salary");
			ps.setDouble(4, sc.nextDouble());
			System.out.println("enter the company name");
			ps.setString(5,sc.next());
			System.out.println("enter the phoneno");
			ps.setDouble(6, sc.nextDouble());
			System.out.println("enter the  email");
			ps.setString(7,sc.next());
		
			
			ps.addBatch();
			System.out.println("*****************************");
		}
		ps.executeBatch();
		System.out.println("Inserted sucessfull");
		}
		catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			c.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		}
	}
	//update
	public static void update() {
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			PreparedStatement ps=c.prepareStatement("update cricket.employee set sal=? where email=?");
			
			System.out.println("Enter The salary");
			ps.setDouble(1, sc.nextDouble());
			
			System.out.println("Enter The Email");
			ps.setString(2, sc.next());
			
			ps.executeUpdate();
			System.out.println("update sucessFull");
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
//	fetchAll
	
	public static void fetchAll() {
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select * from employee");
			
			while (rs.next()) {
				System.out.println("Employee id           :"+rs.getInt(1));
				System.out.println("Employee Name         :"+rs.getString(2));
				System.out.println("Employee job          :"+rs.getString(3));
				System.out.println("Employee sal          :"+rs.getDouble(4));
				System.out.println("Employee company name :"+rs.getString(5));
				System.out.println("Employee phoneno      :"+rs.getString(6));
				System.out.println("Employee email        :"+rs.getString(7));
				
				System.out.println("*********************************");
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
	
	//fetchbyemai
	
	public static void fetchbyemai() {
		Connection c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			PreparedStatement ps=c.prepareStatement("select * from cricket.employee where email=?");
			
			System.out.println("Enter the email");
			ps.setString(1, sc.next());
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			
//			while (rs.next()) {
				System.out.println("Employee id           :"+rs.getInt(1));
				System.out.println("Employee Name         :"+rs.getString(2));
				System.out.println("Employee job          :"+rs.getString(3));
				System.out.println("Employee sal          :"+rs.getDouble(4));
				System.out.println("Employee company name :"+rs.getString(5));
				System.out.println("Employee phoneno      :"+rs.getString(6));
				System.out.println("Employee email        :"+rs.getString(7));
				
//			}
			
			System.out.println("*********************************");
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
