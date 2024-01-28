package cricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner; 

public class InsertUsingExecute {
	static Scanner sc=new Scanner(System.in);
	static Connection c=null;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			
			PreparedStatement ps=c.prepareStatement("insert into student values(?,?,?,?,?,?);");
			
			System.out.println("Enter your id");
			ps.setInt(1,sc.nextInt());
			System.out.println("Enter your name");
			ps.setString(2, sc.next());
			System.out.println("Enter your mark");
			ps.setDouble(3,sc.nextDouble());
			System.out.println("Enter your Age ");
			ps.setInt(4, sc.nextInt());
			System.out.println("Enter you Exam no");
			ps.setInt(5,sc.nextInt());
			System.out.println("Enter your phoneno");
			ps.setDouble(6, sc.nextDouble());
			
			boolean b=ps.execute();
			
			if(b==false) {
				System.out.println("data inserted Sucessfully");

			}
			else {
				System.out.println("No data");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
