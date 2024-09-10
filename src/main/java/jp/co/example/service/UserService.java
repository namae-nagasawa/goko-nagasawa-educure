package jp.co.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.example.DBconnection;
import jp.co.example.entity.Modelentity;
import jp.co.example.repository.UserRepository;

@Service
public class UserService extends DBconnection {
	@Autowired
	UserRepository userRepository;

	private static final String SQL_SELECTALL = "SELECT id, name, price FROM products";

	public List<Modelentity> searchAll(int id, String name, int price) throws SQLException, ClassNotFoundException {
		List<Modelentity> resultList = new ArrayList<>();

		try (Connection con = getConnection(); //テーブル接続のためのgetConnectionメソッドの呼び出し
				PreparedStatement statement = con.prepareStatement(SQL_SELECTALL)) {

			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setInt(3, price);

			try (ResultSet rs = statement.executeQuery()) {//try with resource構文なのでclose省く。
				while (rs.next()) {
					Modelentity dto = new Modelentity();//dtoクラスのオブジェクトを生成することで他クラスでそのクラスのメソッドを扱えるようにした
					dto.setId(rs.getInt("id"));//dtoクラスの中にあるidのセッターを呼び出し、引数にjspから贈られてきたパラメータを設定することでセットできている
					dto.setName(rs.getString("name"));
					dto.setPrice(rs.getInt("price"));
					resultList.add(dto);

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultList;
	}
}