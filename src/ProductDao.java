import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao extends DBconnection {

	public void register(Product product) throws Exception {
		int rs = 0;

		PreparedStatement statement;
		try {
			Connection con = getConnection();
			//DBeaverですでにシーケンスの作成をしているからnextvalが使える。
			String sql = "INSERT INTO products (id,name,price)VALUES(nextval('products_seq'),?,?)";
			statement = con.prepareStatement(sql);
			//プレースホルダー(?)にset○○で値を設定している。
			//1番目の？にproductの中にあるNameを入れている。
			//2番目の？にproductの中にあるNameを入れている。
			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getProductPrice());
			//rsにSQLの結果を代入
			rs = statement.executeUpdate();
			//executeUpdataメソッドはSQLが正常に動いたら1が返ってくるからif文の中身を1だと仮定する条件の与える。
			if (rs == 1) {
				System.out.println("成功しました");
			}
			//ルールとして必ずstatementとconを閉めてあげる。
			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void update(Product product) {
		int rs = 0;

		PreparedStatement statement;
		try {
			Connection con = getConnection();

			String sql = "UPDATE products SET name = ?, price = ? WHERE id =?";
			statement = con.prepareStatement(sql);

			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getProductPrice());
			statement.setInt(3, product.getProductId());

			rs = statement.executeUpdate();

			if (rs == 1) {
				System.out.println("更新しました");
			}

			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void delete(int productid) {
		int rs = 0;

		PreparedStatement statement;
		try {
			Connection con = getConnection();

			String sql = "DELETE FROM products WHERE id = ?";
			statement = con.prepareStatement(sql);

			statement.setInt(1, productid);

			rs = statement.executeUpdate();

			if (rs == 1) {
				System.out.println("削除しました");
			}

			statement.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public List<Product> find(Product product) {

		List<Product> resultList = new ArrayList<>();
		PreparedStatement statement = null;

		try {
			Connection con = getConnection();
			if (product.getProductId() == 0) {
				System.out.println("IDの値の確認に失敗しました");
			} else if (product.getProductName() == null) {
				System.out.println("NAMEの値の確認に失敗しました");
			} else if (product.getProductPrice() == 0) {
				System.out.println("PRICEの値の確認に失敗しました");
				
			} else {
				String sql = "SELECT id, name, price FROM products WHERE id=? AND name=? AND price=?";
				statement = con.prepareStatement(sql);

				statement.setInt(1, product.getProductId());
				statement.setString(2, product.getProductName());
				statement.setInt(3, product.getProductPrice());
				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					Product dto = new Product();
					dto.setProductId(rs.getInt("id"));
					dto.setProductName(rs.getString("name"));
					dto.setProductPrice(rs.getInt("price"));
					resultList.add(dto);
					System.out.println("データを取得しました");

				}

				statement.close();
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return resultList;

	}
}