package jdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc2callable {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner sc = new Scanner(System.in);
		
		Connection connection = DriverManager
			.getConnection("jdbc:postgresql://localhost:5432/sbs_db?user=postgres&password=root");
		
		String addQuery = "call addrecords(?,?,?,?,?)";
		
		CallableStatement cstmt = connection.prepareCall(addQuery);
		
		while(true)
		{
		System.out.println("Enter the product id");
		int id=sc.nextInt();
		System.out.println("Enter the product price");
		int price=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter the product name");
		String name=sc.nextLine();
		System.out.println("Enter the product type");
		String type=sc.nextLine();
		System.out.println("Enter the product description");
		String desc=sc.nextLine();
		
		cstmt.setInt(1, id);
		cstmt.setInt(4, price);
		cstmt.setString(2, name);
		cstmt.setString(3, desc);
		cstmt.setString(5, type);
		
		cstmt.execute();
		System.out.println("Record Successfully Inserted");
		
		System.out.println("Do u want to enter a new item :Y/N");
		String cont=sc.nextLine();
		
		if(!cont.equalsIgnoreCase("Y"))
		break;
		}
		System.out.println("Thank u for Inserting");
		
		
	}

}
