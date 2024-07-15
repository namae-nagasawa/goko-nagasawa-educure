
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection_JavaSE03 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement stmt = null;
		PreparedStatement pstmtSelect = null;

		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "hogeuser", "hoge");

			String selectSql = "SELECT * FROM products FOR SHARE";
			pstmtSelect = con.prepareStatement(selectSql);

			pstmtSelect.executeQuery();

			String sql = "INSERT INTO products(id,name, price)VALUES (nextval('products_seq'),'望遠鏡', 20000)";

			stmt = con.prepareStatement(sql);

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected == 1) {
				System.out.println("成功しています");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}