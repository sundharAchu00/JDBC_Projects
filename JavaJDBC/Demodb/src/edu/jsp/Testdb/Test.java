package edu.jsp.Testdb;

import java.sql.*;

public class Test {
	public static void main(String[] args) {

//		ArrayList a = new ArrayList();
		
		try {
			Driver d=new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			String query ="select * from `student_table` ";
			Statement stmt=(Statement)con.createStatement();
//			if (con != null) {
//				System.out.println("connection successfull...");
//			}
			ResultSet s= stmt.executeQuery(query);
			String stu_data = "";
			System.out.println("ID            |    Name           |   Marks         |       Age       |      class" );
			System.out.println("---------------------------------------");
//			s.next();
//			System.out.println(s.getInt(1)+" : "+s.getString(2)+" : "+s.getInt(3)+" : "+s.getInt(4)+" : "+s.getInt(5));
			while (s.next()) {
				stu_data=s.getInt(1)+" : "+s.getString(2)+" : "+s.getInt(3)+" : "+s.getInt(4)+" : "+s.getInt(5);
				System.out.println(stu_data);
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("invalid user name or password....");
			e.printStackTrace();
		}

	}
}
