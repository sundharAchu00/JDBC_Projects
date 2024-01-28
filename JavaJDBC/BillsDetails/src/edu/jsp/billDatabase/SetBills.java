package edu.jsp.billDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SetBills {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bills", "root", "root");
			PreparedStatement ps = c.prepareStatement("insert into bill_details values(null	,?,?,?)");
			
			System.out.println("Enter Number of Bills Do You Want to Enter :");
			int num = sc.nextInt();
			
			for (int i = 0; i < num; i++) {
				System.out.println("Enter Customer Name :");
				ps.setString(1, sc.next());
				System.out.println("Enter Customer Number :");
				ps.setLong(2, sc.nextLong());
				System.out.println("Enter Bill Amount :");
				ps.setDouble(3, sc.nextDouble());
				ps.addBatch();
			}
			ps.executeBatch();
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
