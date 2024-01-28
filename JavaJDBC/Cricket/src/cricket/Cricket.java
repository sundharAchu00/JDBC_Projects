package cricket;

import java.sql.*;

public class Cricket {
	
	public static void main(String[] args) {
		

		
		try {
			//load or reister
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//establish connection
			
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","root");
			
			//create statement
			Statement s=c.createStatement();
			
			//execute and update
			
//			s.executeUpdate("insert into cricket values('7','Dhoni','10000')");
//			s.executeUpdate("insert into cricket values('45','Rohit sharma','10000')");
//			s.executeUpdate("insert into cricket values('8','Viat kolhi','30000')");
			
			
			s.executeUpdate("update cricket set score=4500 where jersy_no=7");
			System.out.println("cricket player update data base sucessfull");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	
	}

}
