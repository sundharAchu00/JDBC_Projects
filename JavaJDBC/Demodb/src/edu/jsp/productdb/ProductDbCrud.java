package edu.jsp.productdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductDbCrud {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		boolean b=true;
		int id;
		double price,qty;
		String ven,name;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/product","root","root");
//			System.out.println(c);
			PreparedStatement ps;
			System.out.println("\t\tWelcome to Super Store...");
			do {
				System.out.println("1. Do You Want to insert into Product");
				System.out.println("2. Do You Want to update existing Product Name");
				System.out.println("3. Do You Want to delete the Product");
				System.out.println("4.Exit");
				switch (sc.nextInt()) {
				case 1:{
					System.out.println("Enter the product id :");
					id = sc.nextInt();
					System.out.println("Enter Product Name :");
					name = sc.next();
					System.out.println("Enter product Price :");
					price =  sc.nextDouble();
					System.out.println("Enter product Quantity :");
					qty =  sc.nextDouble();
					System.out.println("Enter product Vendor :");
					ven = sc.next();
					ps = c.prepareStatement("INSERT INTO productdetail  VALUES (?, ?, ?, ?, ?)");
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setDouble(3, price);
					ps.setDouble(4, qty);
					ps.setString(5, ven);
					ps.executeUpdate();
					System.out.println("Inserted Successfully.........");
					ps.close();
					c.close();
					break;}
				case 2:{
					System.out.println("Enter the product id :");
					id = sc.nextInt();
					System.out.println("Enter Product Name :");
					name = sc.next();
					ps = c.prepareStatement("UPDATE `productdetail` SET `productName` = ? WHERE (`product_id` = ?)");
					ps.setInt(2, id);
					ps.setString(1, name);
					ps.executeUpdate();
					System.out.println("Updated Successfully.........");
					ps.close();
					c.close();
					break;}
				
				case 3:{
					System.out.println("Enter the product id :");
					id = sc.nextInt();
					ps = c.prepareStatement("DELETE FROM productdetail WHERE product_id = ? ");
					ps.setInt(1, id);
					ps.executeUpdate();
					System.out.println("Deleted Successfully.........");
					ps.close();
					c.close();
					break;}
				case 4:{
					System.out.println("\t\tThank You for using the Application...");
					b=false;
					break;}
				default:
					System.out.println("Enter any one of the Option Given Above...");
					break;
				}
				
			}while(b);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
