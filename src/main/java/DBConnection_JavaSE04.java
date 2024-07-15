import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_JavaSE04 {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "hogeuser", "hoge");

			Statement statement = con.createStatement();

			String sql = "update products set name='シャープペンシル',price=200 where id=101";

			statement.executeUpdate(sql);

			int rs = statement.executeUpdate(sql);
			if (rs == 1) {
				System.out.println("アップデート完了しました");
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
