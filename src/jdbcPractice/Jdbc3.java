package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Jdbc3 {

	public static void main(String[] args) throws SQLException {
		
		//1
		Connection c=DriverManager
				.getConnection("jdbc:postgresql://localhost:5432/sbs_db?user=postgres&password=root");
		//2
		String query="select orders.prod_id,prod_name,count(*) as ord_count,(count(*)*price) as Tot_rev\r\n"
				+ "from product inner join orders\r\n"
				+ "on product.prod_id=orders.prod_id\r\n"
				+ "group by orders.prod_id,prod_name,price\r\n"
				+ "order by count(*) desc\r\n"
				+ "limit 3;";
		PreparedStatement ps=c.prepareStatement(query);
		//3
		ps.execute();
		
		//4
		ResultSet rs=ps.getResultSet();
		
		List<ProductReport>arr=new ArrayList<>();
		
		while(rs.next()) {
			ProductReport pr=new ProductReport();
			pr.setOrderCount(rs.getInt("ord_count"));
			pr.setProdName(rs.getString("prod_name"));
			pr.setTotalRevenue(rs.getInt("tot_rev"));
			arr.add(pr);
		}
		for(ProductReport r:arr ) {
			System.out.println(r);
		}
		
	}

}

class ProductReport{
	String prodName;
	int orderCount;
	int totalRevenue;
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getTotalRevenue() {
		return totalRevenue;
	}
	public void setTotalRevenue(int totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	@Override
	public String toString() {
		return "ProductReport [prodName=" + prodName + ", orderCount=" + orderCount + ", totalRevenue=" + totalRevenue
				+ "]";
	}

}
//3. Write a JDBC program that: - Create a pojo class for ProductReport
//Fetches top 3 products based on number of orders
//Display:
//    prodName
//    orderCount
//    totalRevenue