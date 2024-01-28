package edu.jsp.jdbc.fetchoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class F2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c= DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
			System.out.println("enter product Name");
			String name = sc.next();
			PreparedStatement ps = c.prepareStatement("select * from productdetail where productName =?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("product id :"+rs.getInt(1));
				System.out.println("product name :"+rs.getString(2));
				System.out.println("product price :"+rs.getDouble(3));
				System.out.println("product weight :"+rs.getDouble(4));
				System.out.println("product manufacturer :"+rs.getString(5));
			}

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
