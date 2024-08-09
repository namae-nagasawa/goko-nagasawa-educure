package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.DBConnected;

import dto.DTOEEclass;

public class DAOEEclass extends DBConnected {

	private static final String SQL_SELECT = "SELECT id, name, price FROM products WHERE id = ? OR name = ? OR price = ?";

	private static final String SQL_INSERT = "INSERT INTO products(id, name, price) VALUES (nextval('products_seq'), ?, ?)";//シーケンスを作成済なのでnextvalを使って柔軟性重視

	private static final String SQL_UPDATE = "UPDATE products SET name = ?, price = ? WHERE id = ?";

	private static final String SQL_DELETE = "DELETE FROM products WHERE id = ?";

	//private static final String SQL_SELECT_ALL = "SELECT * FROM products";// productsテーブルのidを主とし検索を合わせる

	public List<DTOEEclass> selectByCriteria(int id, String name, int price)
			throws SQLException, ClassNotFoundException {
		List<DTOEEclass> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {//SQL文を実行するために処理速度を上げるためにpreparedで用意する

			//↓(SQL_SELECTのプレースホルダーにid,name,priceをセット、selectByCriteriaの引数と同じ扱い
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setInt(3, price);

			System.out.println("引数をセット " + SQL_SELECT);//test

			try (ResultSet rs = statement.executeQuery()) {//try with resource構文なのでclose省く。
				while (rs.next()) {
					DTOEEclass dto = new DTOEEclass();//dtoクラスのオブジェクトを生成することで他クラスでそのクラスのメソッドを扱えるようにした
					dto.setProductId(rs.getInt("id"));//dtoクラスの中にあるidのセッターを呼び出し、引数にjspから贈られてきたパラメータを設定することでセットできている
					dto.setProductName(rs.getString("name"));
					dto.setProductPrice(rs.getInt("price"));
					resultList.add(dto);//最後、格納するレコードは複数行あるため作成したList型にaddする

					System.out.println("Added product to list: ID=" + dto.getProductId() + ", Name="
							+ dto.getProductName() + ", Price=" + dto.getProductPrice());//test
				}
			}

		} catch (SQLException e) {
			System.out.println("SQLExceptionが発生 " + e.getMessage());//test
			e.printStackTrace();
		}
		return resultList;//一連の流れを終え、最後そのList型の変数resultListを返す
	}

	public List<DTOEEclass> insertByCriteria(String name, int price)//追加の場合はidはなにも入力しないからnameとpriceの２つだけを引数に(シーケンスを採用してるから）
			throws SQLException, ClassNotFoundException {
		List<DTOEEclass> resultList = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement insertStatement = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS))//insert文を実行した際に自動生成されたキーを取得するためにStatement.RETURN_GENERATED_KEYSを使う。
		{//まずINSERT文を実行して、そこでシーケンスを採用（nextval())しているのでidが自動生成される。その自動生成されたキーを取得するためにStatement.RETURN_GENERATED_KEYSこれが必要

			// データの挿入
			insertStatement.setString(1, name);//insert文のプレースホルダーの１つ目にnameを設定
			insertStatement.setInt(2, price);// "" ２つ目にpriceを設定

			System.out.println("insert文にセットしました" + SQL_INSERT); // Test
			int rowsAffected = insertStatement.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected); // Output the number of affected rows

			// 自動生成されたキーの取得
			try (ResultSet generatedKeys = insertStatement.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int geneId = generatedKeys.getInt(1);

					DTOEEclass dto = new DTOEEclass();
					dto.setProductId(geneId); // 自動生成された ID を設定
					dto.setProductName(name); // 入力された name を設定
					dto.setProductPrice(price); // 入力された price を設定
					resultList.add(dto);

				} else {
					System.out.println("generatedIdが取得できませんでした"); // Test
				}

			} catch (SQLException e) {
				System.out.println("SQLExceptionがDAOで起こりました " + e.getMessage()); // Test
				e.printStackTrace();
			}
			return resultList;
		}
	}

	public List<DTOEEclass> updateByCriteria(int id, String name, int price)
			throws SQLException, ClassNotFoundException {
		List<DTOEEclass> resultList = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement updateStatement = con.prepareStatement(SQL_UPDATE)) {

			// パラメータを設定
			updateStatement.setString(1, name); // プレースホルダーの1つ目にnameを設定
			updateStatement.setInt(2, price); // プレースホルダーの2つ目にpriceを設定
			updateStatement.setInt(3, id); // プレースホルダーの3つ目にIDを設定

			System.out.println("引数をセット" + SQL_UPDATE); // Test
			int rowsAffected = updateStatement.executeUpdate();
			System.out.println("Rows affectedにSQL結果を挿入しました" + rowsAffected); // Output the number of affected rows

			// 更新されたレコードの取得
			if (rowsAffected > 0) {
				DTOEEclass dto = new DTOEEclass();
				dto.setProductId(id); // 更新されたIDを設定
				dto.setProductName(name); // 入力されたnameを設定
				dto.setProductPrice(price); // 入力されたpriceを設定
				resultList.add(dto);
			} else {
				System.out.println("レコードが更新されませんでした"); // Test
			}

		} catch (SQLException e) {
			System.out.println("SQLExceptionがDAOで起こりました" + e.getMessage()); // Test
			e.printStackTrace();
		}
		return resultList;
	}

	

	public List<DTOEEclass> deleteByCriteria(int id)
			throws SQLException, ClassNotFoundException {
		List<DTOEEclass> resultList = new ArrayList<>();

		try (Connection con = getConnection();
				PreparedStatement deleteStatement = con.prepareStatement(SQL_DELETE)) {

			// パラメータを設定
			deleteStatement.setInt(1, id); // プレースホルダーの1つ目にnameを設定

			System.out.println("引数をセット" + SQL_UPDATE); // Test
			int rowsAffected = deleteStatement.executeUpdate();
			System.out.println("Rows affectedにSQL結果を挿入しました" + rowsAffected); // Output the number of affected rows

			// 更新されたレコードの取得
			if (rowsAffected > 0) {
				DTOEEclass dto = new DTOEEclass();
				dto.setProductId(id); // 更新されたIDを設定

				resultList.add(dto);
			} else {
				System.out.println("レコードが更新されませんでした"); // Test
			}

		} catch (SQLException e) {
			System.out.println("SQLExceptionがDAOで起こりました" + e.getMessage()); // Test
			e.printStackTrace();
		}
		return resultList;
	}
}
