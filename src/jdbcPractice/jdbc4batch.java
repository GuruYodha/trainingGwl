package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbc4batch {

	public static void main(String[] args) throws SQLException{
		
		
		Scanner sc=new Scanner(System.in);
		
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/sbs_db?user=postgres&password=root");
		
		con.setAutoCommit(false);
		
		String query="insert into product(prod_name,prod_desc,price,prod_category) values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(query);
		
		while(true) {
			
			System.out.println("Enter the product price");
			int price=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter the product name");
			String name=sc.nextLine();
			System.out.println("Enter the product type");
			String type=sc.nextLine();
			System.out.println("Enter the product description");
			String desc=sc.nextLine();
			
			ps.setString(1, name);
			ps.setString(2, desc);
			ps.setInt(3, price);
			ps.setString(4, type);
			
			ps.addBatch();
			System.out.println("Batch Successfully Added");
			
			System.out.println("Do u want to enter a new item into Batch : Y/N");
			
			String cont=sc.nextLine();
			
			if(!cont.equalsIgnoreCase("Y"))
			break;
		}
		try {
		ps.executeBatch();
		con.commit();
		System.out.print("successfully inserted");
		
		}catch(Exception e) {
		con.rollback();
	}
	}
}
//4. Write a JDBC program that:
//    Inserts multiple products using batch processing
//    Then inserts multiple orders for those products using batch
//    Commit transaction only if all inserts succeed
//    Rollback entirely if any failure occurs
//
//Requirements:     --> use addBatch() and executeBatch() methods
//    con.setAutoCommit(false);
//    con.commit();
//    con.rollback();
