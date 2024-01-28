package edu.jsp.jdbc.fetchoperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class F3 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		boolean b=true;
		Connection c = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies","root","root");
			ps = c.prepareStatement("select * from movies.movie where hero_name = ?");
			System.out.println("enter hero name");
			String hname = sc.next();
			ps.setString(1, hname);
			
			ResultSet rs = ps.executeQuery();
			
			while(b) {
				if (rs.next()&& rs.getString(2).equalsIgnoreCase(hname)) {
					
					System.out.println("movie name : "+rs.getString(1));
					
				}else if(rs.isAfterLast()) {
					System.out.println("End of Movie List");
					b=false;
				}else {
					b=false;
					System.err.println("actor data not found...");
				}
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
