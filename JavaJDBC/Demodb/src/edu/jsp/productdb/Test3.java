package edu.jsp.productdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
			int id;
			String name;
			System.out.println("Enter the product ID :");
			id = sc.nextInt();
			System.out.println("Enter Product Name :");
			name = sc.next();
			PreparedStatement ps = c.prepareStatement("UPDATE `productdetail` SET `productName` = ? WHERE (`product_id` = ?)");
			ps.setInt(2, id);
			ps.setString(1, name);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
