package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBConnection.DBConnection;
import dto.dto1Class;

public class dao1Class extends DBConnection {

	private static final String SQL_LOGIN = "SELECT login_id,password,user_id,user_name,telephone,role_id  FROM user_info WHERE login_id = ? AND password = ?";
	private static final String SQL_ROLE = "SELECT * FROM role";
	private static final String SQL_SELECT_ALL = "SELECT user_info.user_id, user_info.login_id, user_info.user_name, user_info.telephone, user_info.password, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id = role.role_id";

	private static final String SQL_ROLE_ALL_TEL = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.telephone=?";
	private static final String SQL_ROLE_ALL_NAME = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.user_name=?";
	private static final String SQL_ROLE_ALL_NAME_AND_TEL = "SELECT user_info.login_id, user_info.password, user_info.user_id, user_info.user_name, user_info.telephone, role.role_name FROM user_info LEFT JOIN role ON user_info.role_id=role.role_id WHERE user_info.user_name = ? AND user_info.telephone = ?";

	private static final String SQL_SELECT_ID = "SELECT * FROM user_info WHERE login_id =?";
	private static final String SQL_INSERT = "INSERT INTO user_info (login_id,user_name,telephone,password,role_id) VALUES(?,?,?,?,?)";

	public List<dto1Class> login(String login_id, String password)
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_LOGIN)) {//SQL文を実行するために処理速度を上げるためにpreparedで用意する

			statement.setString(1, login_id);//プレースホルダーにメソッドの引数をセット
			statement.setString(2, password);

			System.out.println("引数をセット " + SQL_LOGIN);//test

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setLoginId(rs.getString("login_id"));
					System.out.println("ログインIDセット");

					dto.setPassword(rs.getString("password"));
					System.out.println("パスワードセット");

					dto.setUserName(rs.getString("user_name"));
					System.out.println("ユーザー名セット");

					dto.setUserId(rs.getInt("user_id"));
					System.out.println("ユーザーIDセット");

					dto.setTelephone(rs.getString("telephone"));
					System.out.println("電話番号セット");

					dto.setRoleId(rs.getInt("role_id"));
					System.out.println("ロールIDセット");

					System.out.println("user_info内のデータすべてをセットしました");

					resultList.add(dto);

					System.out.println("セットした値をすべて結果に加えました");
				}
			} catch (SQLException e) {
				System.out.println("DAOでSQLExceptionが起こりました");
				e.printStackTrace();
			}
			System.out.println("resultListに値をセットしました");
			return resultList;//ここで入力されたlogin_idとpasswordは入ってるはず？
		}

	}

	public List<dto1Class> role()
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_ROLE)) {

			System.out.println("ROLEテーブルのデータを用意");

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setRoleId(rs.getInt("role_id"));
					dto.setRoleName(rs.getString("role_name"));

					resultList.add(dto);

					System.out.println("role_nameとrole_idは入ってる");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	public List<dto1Class> selectAll()
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_SELECT_ALL)) {//SQL文を実行するために処理速度を上げるためにpreparedで用意する

			System.out.println("電話番号、ユーザー名をセット");

			try (ResultSet rs = statement.executeQuery()) {
				System.out.println("SQLを実行します");
				while (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setLoginId(rs.getString("login_id"));
					System.out.println("ログインIDセット");

					dto.setPassword(rs.getString("password"));
					System.out.println("パスワードセット");

					dto.setUserName(rs.getString("user_name"));
					System.out.println("ユーザー名セット");

					dto.setUserId(rs.getInt("user_id"));
					System.out.println("ユーザーIDセット");

					dto.setTelephone(rs.getString("telephone"));
					System.out.println("電話番号セット");

					dto.setRoleName(rs.getString("role_name"));
					System.out.println("ロール名セット");

					resultList.add(dto);

					System.out.println("セットした値をすべて結果に加えました");
				}
			} catch (SQLException e) {
				System.out.println("DAOでSQLExceptionが起こりました");
				e.printStackTrace();
			}
			System.out.println("resultListに値をセットしました");
			return resultList;//ここで入力されたlogin_idとpasswordは入ってるはず？
		}
	}

	public List<dto1Class> selectName(String user_name) throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement(SQL_ROLE_ALL_NAME)) {

			statement.setString(1, user_name);

			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					dto1Class dto = new dto1Class();

					dto.setUserId(rs.getInt("user_id"));
					dto.setLoginId(rs.getString("login_id"));
					dto.setUserName(rs.getString("user_name"));
					dto.setTelephone(rs.getString("telephone"));
					dto.setPassword(rs.getString("password"));
					dto.setRoleName(rs.getString("role_name"));

					resultList.add(dto);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultList;
		}
	}

	public List<dto1Class> selectTel(String telephone) throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();
		try (Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement(SQL_ROLE_ALL_TEL)) {

			statement.setString(1, telephone);

			try (ResultSet rs = statement.executeQuery()) {

				while (rs.next()) {
					dto1Class dto = new dto1Class();

					dto.setUserId(rs.getInt("user_id"));
					dto.setLoginId(rs.getString("login_id"));
					dto.setUserName(rs.getString("user_name"));
					dto.setTelephone(rs.getString("telephone"));
					dto.setPassword(rs.getString("password"));
					dto.setRoleName(rs.getString("role_name"));

					resultList.add(dto);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return resultList;
		}
	}

	public List<dto1Class> selectByNameAndTel(String user_name, String telephone)
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement(SQL_ROLE_ALL_NAME_AND_TEL)) {

			statement.setString(1, user_name);
			statement.setString(2, telephone);

			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setUserId(rs.getInt("user_id"));
					dto.setLoginId(rs.getString("login_id"));
					dto.setUserName(rs.getString("user_name"));
					dto.setTelephone(rs.getString("telephone"));
					dto.setPassword(rs.getString("password"));
					dto.setRoleName(rs.getString("role_name"));
					resultList.add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;

	}

	public List<dto1Class> selectId(String login_id)
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_SELECT_ID)) {//SQL文を実行するために処理速度を上げるためにpreparedで用意する

			statement.setString(1, login_id);//プレースホルダーにメソッドの引数をセット

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setLoginId(rs.getString("login_id"));

					dto.setPassword(rs.getString("password"));

					dto.setUserName(rs.getString("user_name"));

					dto.setUserId(rs.getInt("user_id"));

					dto.setTelephone(rs.getString("telephone"));

					dto.setRoleId(rs.getInt("role_id"));

					resultList.add(dto);

				}
			} catch (SQLException e) {
				System.out.println("DAOでSQLExceptionが起こりました");
				e.printStackTrace();
			}
			System.out.println("resultListに値をセットしました");
			return resultList;//ここで入力されたlogin_idとpasswordは入ってるはず？
		}

	}


	public List<dto1Class> insert(String login_id, String user_name, String telephone, String password, int role_id)
			throws SQLException, ClassNotFoundException {
		List<dto1Class> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_INSERT)) {//SQL文を実行するために処理速度を上げるためにpreparedで用意する

			statement.setString(1, login_id);//プレースホルダーにメソッドの引数をセット
			statement.setString(2, user_name);
			statement.setString(3, telephone);
			statement.setString(4, password);
			statement.setInt(5, role_id);

			System.out.println("引数をセット " + SQL_LOGIN);//test

			try (ResultSet rs = statement.executeQuery()) {
				if (rs.next()) {
					dto1Class dto = new dto1Class();
					dto.setLoginId(rs.getString("login_id"));
					System.out.println("ログインIDセット");

					dto.setUserName(rs.getString("user_name"));
					System.out.println("ユーザー名セット");

					dto.setTelephone(rs.getString("telephone"));
					System.out.println("電話番号セット");

					dto.setPassword(rs.getString("password"));
					System.out.println("パスワードセット");

					dto.setRoleId(rs.getInt("role_id"));
					System.out.println("ロールIDセット");

					System.out.println("データをINSERTしました");

					resultList.add(dto);

				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

			return resultList;//ここで入力されたlogin_idとpasswordは入ってるはず？
		}

	}
}