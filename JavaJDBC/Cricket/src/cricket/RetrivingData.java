package cricket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RetrivingData {
	public static void main(String[] args) {
		try {
//			Class.forName("com.mysql.cj.jdbc.Diver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			
			Statement s=c.createStatement();
			
			boolean b=s.execute("select * from student");
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}
}
