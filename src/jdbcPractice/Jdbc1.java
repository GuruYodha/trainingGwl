package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Jdbc1 {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:postgresql://localhost:5432/sbs_db?user=postgres&password=root";
		
		//1. Load the driver
		//Driver driver = new Driver();
		//DriverManager.registerDriver(driver);
		
		//2. Establish the connection
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstatement = null;
		
		//3. Create a statement
		try {
			connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//1. Write a jdbc program that deletes a product Conditions:
		//if the product has associated orders, do not delete the product and print a message 
		//"Cannot delete the product as it has existing orders" Otherwise successfully delete the product 
		//and print a message "Product deleted successfully"
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product id to delete");
		int id = sc.nextInt();
		
		String query="select product.prod_id\r\n"
				+ "from product left outer join orders\r\n"
				+ "on orders.prod_id=product.prod_id\r\n"
				+ "where orders.ord_id is null";
		
		//4. Execute the query
		pstatement = connection.prepareStatement(query);
		pstatement.executeQuery();
		//5. Process the result
		ResultSet resultSet = pstatement.getResultSet();
		
		
		while(resultSet.next()) {
			if(resultSet.getInt("prod_id")==id){
				String deleteQuery="delete from product where prod_id=?";
				PreparedStatement deletePstatement = connection.prepareStatement(deleteQuery);
				
				deletePstatement.setInt(1,id);
				deletePstatement.executeUpdate();
				System.out.println("Product deleted successfully");
				break;
			}
			else {
				System.out.println("Cannot delete the product as it has existing orders");
				break;
			}
					
		}
	}

}
