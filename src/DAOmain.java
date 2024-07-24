
public class DAOmain {

	public static void main(String[] args) throws Exception {
		try {//productクラスのインスタンス生成
			Product dto = new Product();
			//productDaoクラスのインスタンス生成

			dto.setProductId(101); // 更新対象の商品ID
			dto.setProductName("土星の土地"); // 更新後の商品名
			dto.setProductPrice(5000000); // 更新後の価格

			ProductDao dao = new ProductDao();

			//productクラスのセッターに定数を設定

			//dao.register(dto);
			//dao.update(dto);
			//dao.delete(dto.getProductId());
			dao.find(dto);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
