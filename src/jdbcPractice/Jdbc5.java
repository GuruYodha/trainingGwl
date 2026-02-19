package jdbcPractice;

import java.sql.*;
import java.util.Scanner;

public class Jdbc5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/sbs_db?user=postgres&password=root")) {

            while (true) {

                System.out.println("\n===== MENU =====");
                System.out.println("1. Filter by Order Type");
                System.out.println("2. Filter by Minimum Price");
                System.out.println("3. Filter by Order Type and Minimum Price");
                System.out.println("4. View All Products");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                   
                    case 1:

                        String query1 =
                                "SELECT * FROM product WHERE prod_category = ?";

                        System.out.print("Enter Order Type (Category): ");
                        String category = sc.nextLine();

                        try (PreparedStatement ps =
                                     con.prepareStatement(query1)) {

                            ps.setString(1, category);

                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {

                                System.out.println("----------------");
                                System.out.println("ID: " +
                                        rs.getInt("prod_id"));
                                System.out.println("Name: " +
                                        rs.getString("prod_name"));
                                System.out.println("Category: " +
                                        rs.getString("prod_category"));
                                System.out.println("Price: " +
                                        rs.getDouble("price"));
                            }
                        }
                        break;


                   
                    case 2:

                        String query2 =
                                "SELECT * FROM product WHERE price >= ?";

                        System.out.print("Enter Minimum Price: ");
                        double minPrice = sc.nextDouble();
                        sc.nextLine();

                        try (PreparedStatement ps =
                                     con.prepareStatement(query2)) {

                            ps.setDouble(1, minPrice);

                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {

                                System.out.println("----------------");
                                System.out.println("ID: " +
                                        rs.getInt("prod_id"));
                                System.out.println("Name: " +
                                        rs.getString("prod_name"));
                                System.out.println("Category: " +
                                        rs.getString("prod_category"));
                                System.out.println("Price: " +
                                        rs.getDouble("price"));
                            }
                        }
                        break;


                   
                    case 3:

                        String query3 =
                                "SELECT * FROM product WHERE prod_category = ? AND price >= ?";

                        System.out.print("Enter Order Type: ");
                        String cat = sc.nextLine();

                        System.out.print("Enter Minimum Price: ");
                        double price = sc.nextDouble();
                        sc.nextLine();

                        try (PreparedStatement ps =
                                     con.prepareStatement(query3)) {

                            ps.setString(1, cat);
                            ps.setDouble(2, price);

                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {

                                System.out.println("----------------");
                                System.out.println("ID: " +
                                        rs.getInt("prod_id"));
                                System.out.println("Name: " +
                                        rs.getString("prod_name"));
                                System.out.println("Category: " +
                                        rs.getString("prod_category"));
                                System.out.println("Price: " +
                                        rs.getDouble("price"));
                            }
                        }
                        break;


                    case 4:

                        String query4 =
                                "SELECT * FROM product";

                        try (PreparedStatement ps =
                                     con.prepareStatement(query4)) {

                            ResultSet rs = ps.executeQuery();

                            while (rs.next()) {

                                System.out.println("----------------");
                                System.out.println("ID: " +
                                        rs.getInt("prod_id"));
                                System.out.println("Name: " +
                                        rs.getString("prod_name"));
                                System.out.println("Category: " +
                                        rs.getString("prod_category"));
                                System.out.println("Price: " +
                                        rs.getDouble("price"));
                            }
                        }
                        break;


                   
                    case 5:
                        System.out.println("Exiting program...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
}
