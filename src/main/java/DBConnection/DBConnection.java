package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
	private static final String URL = "jdbc:postgresql://localhost:5432/sampledb_task";
    private static final String USER = "hogeuser";
    private static final String PASSWORD = "hoge";
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        System.out.println("データベースに接続準備"); // test
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
