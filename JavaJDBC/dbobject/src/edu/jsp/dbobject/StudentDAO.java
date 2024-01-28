package edu.jsp.dbobject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	static String driverclass = "com.mysql.cj.jdbc.Driver";
	static String db_url = "jdbc:mysql://localhost:3306/student";
	static String user_name = "root";
	static String password = "root";
	static String query = "insert into student_table values(null,?,?,?,?)";

	// updating
	public void updateName(int id, String name) throws ClassNotFoundException, SQLException {
		Class.forName(driverclass);
		Connection c = DriverManager.getConnection(db_url, user_name, password);
		PreparedStatement ps = c.prepareStatement("update student_table set name = ? where id = ?");
		ps.setInt(2, id);
		ps.setString(1, name);
		ps.executeUpdate();
		System.out.println("updated successfully...");
		ps.close();
	}

	// inserting data
	public void insert(String name, double mark, int age, long exam_no) throws ClassNotFoundException, SQLException {
		Class.forName(driverclass);
		Connection c = DriverManager.getConnection(db_url, user_name, password);
		PreparedStatement ps = c.prepareStatement(query);
		ps.setString(2, name);
		ps.setDouble(3, mark);
		ps.setInt(4, age);
		ps.setLong(5, exam_no);
		ps.executeUpdate();
		System.out.println("inserted successfully...");
		c.close();
	}

	// fetch data by using name
	public void fetch(String name) throws ClassNotFoundException, SQLException {
		Class.forName(driverclass);
		Connection c = DriverManager.getConnection(db_url, user_name, password);
		PreparedStatement ps = c.prepareStatement("select * from student_table where name = ?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println("ID :" + rs.getInt(1));
			System.out.println("name : " + rs.getString(2));
			System.out.println("marks : " + rs.getDouble(3));
			System.out.println("Age :" + rs.getInt(4));
			System.out.println("exam Number :" + rs.getLong(5));
		}
		c.close();
	}

	// fetchAll data
	public void fetchAll() throws ClassNotFoundException, SQLException {
		Class.forName(driverclass);
		Connection c = DriverManager.getConnection(db_url, user_name, password);
		Statement ps = c.createStatement();
//		ps.setString(1, name);
		ResultSet rs = ps.executeQuery("select * from student_table");
		while (rs.next()) {
			System.out.println("ID :" + rs.getInt(1));
			System.out.println("name : " + rs.getString(2));
			System.out.println("marks : " + rs.getDouble(3));
			System.out.println("Age :" + rs.getInt(4));
			System.out.println("exam Number :" + rs.getLong(5));
			System.out.println("--------------------------");
		}
		c.close();
	}

	// delete data
	public void delete() throws ClassNotFoundException, SQLException {
		Class.forName(driverclass);
		Connection c = DriverManager.getConnection(db_url, user_name, password);
		Statement ps = c.createStatement();
//		ps.setString(1, name);
		ps.executeUpdate("truncate student_table");
		c.close();
	}
}
