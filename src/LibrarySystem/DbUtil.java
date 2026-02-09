package LibrarySystem;

import java.sql.Connection;
import java.sql.DriverManager;

 class DbUtil {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testdb",
                    "postgres",
                    "root"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}