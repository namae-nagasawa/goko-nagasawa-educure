
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection_JavaSE05 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement stmt = null;

		try {

			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql:dbconnection", "hogeuser", "hoge");

			Statement statement = con.createStatement();

			String sql = "INSERT INTO products(id,name, price)VALUES (999,'月の土地',1000000)";

			stmt = con.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.equals(rs)) {
				System.out.println("登録しました");
			}

			String sql2 = "update products set name='火星の土地',price=2000000 where id=999";

			statement.executeUpdate(sql2);

			int rs2 = statement.executeUpdate(sql2);
			if (rs2 == 1) {
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