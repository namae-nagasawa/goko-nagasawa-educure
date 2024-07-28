import java.util.ArrayList;
import java.util.List;

public class DAOmain {

	public static void main(String[] args) throws Exception {
		try {//productクラスのインスタンス生成
			Product dto = new Product();
			ProductDao dao = new ProductDao();
			List<Product> list = new ArrayList<>();

			dto.setProductId(101); // 更新対象の商品ID
			dto.setProductName("土星の土地"); // 更新後の商品名
			dto.setProductPrice(5000000); // 更新後の価格

			List<Product> products = (List<Product>) dao.find(dto); // 型キャストが必要な場合
			list.addAll(products);

			//productDaoクラスのインスタンス生成

			//productクラスのセッターに定数を設定 

			dao.register(dto);
			dao.update(dto);
			dao.delete(dto.getProductId());
			System.out.println(products);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
