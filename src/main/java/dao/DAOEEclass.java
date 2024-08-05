package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.DBConnected;

import dto.DTOEEclass;

public class DAOEEclass extends DBConnected {

	private static final String SQL_SELECT = "SELECT id, name, price FROM products WHERE id =? AND name =? AND price = ?";

	
	public List<DTOEEclass> selectByCriteria(int id, String name, int price) throws SQLException {
        List<DTOEEclass> resultList = new ArrayList<>();
        DTOEEclass dto = new DTOEEclass();

        try (Connection con = getConnection();
             PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {

            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, price);
            
            System.out.println("Executing query: " + SQL_SELECT);//test

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    dto.setProductId(rs.getInt("id"));
                    dto.setProductName(rs.getString("name"));
                    dto.setProductPrice(rs.getInt("price"));
                    resultList.add(dto);
                    
                    System.out.println("Added product to list: ID=" + dto.getProductId() + ", Name=" + dto.getProductName() + ", Price=" + dto.getProductPrice());//test
                }
            }

        } catch (SQLException e) {
        	 System.out.println("SQLException in DAO: " + e.getMessage());//test
            e.printStackTrace();
        }
        return resultList;
    }
}
//	public List<DTOEEclass> selectOne() throws SQLException {
//		List<DTOEEclass> resultList = new ArrayList<>(); //セットするデータが複数行あるためlistを使用
//
//		//getConnection()メソッドを呼び出してデータベースへの接続 (Connection) を取得します。
//		//Resultsetを明示的にクローズするために、try-with-resourcesをconnectionとpreparestatementにかける
//
//		try (Connection con = getConnection();
//				PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
//
//			statement.setInt(1, 101);
//			statement.setString(2, "鉛筆");
//			statement.setInt(3, 50);
//
//			try (ResultSet rs = statement.executeQuery()) {
//				while (rs.next()) {
//					DTOEEclass dto = new DTOEEclass();
//					dto.setProductId(rs.getInt("id"));
//					dto.setProductName(rs.getString("name"));
//					dto.setProductPrice(rs.getInt("price"));
//					resultList.add(dto);
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return resultList;
//	}
//
//	public List<DTOEEclass> selectTwo() throws SQLException {
//		List<DTOEEclass> resultList = new ArrayList<>();
//
//		try (Connection con = getConnection();
//				PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
//
//			statement.setInt(1, 102);
//			statement.setString(2, "消しゴム");
//			statement.setInt(3, 100);
//
//			try (ResultSet rs = statement.executeQuery()) {
//
//				while (rs.next()) {
//					DTOEEclass dto = new DTOEEclass();
//					dto.setProductId(rs.getInt("id"));
//					dto.setProductName(rs.getString("name"));
//					dto.setProductPrice(rs.getInt("price"));
//					resultList.add(dto);
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return resultList;
//	}
//
//	public List<DTOEEclass> selectThree() throws SQLException {
//		List<DTOEEclass> resultList = new ArrayList<>();
//
//		try (Connection con = getConnection();
//				PreparedStatement statement = con.prepareStatement(SQL_SELECT)) {
//
//			statement.setInt(1, 103);
//			statement.setString(2, "地球儀");
//			statement.setInt(3, 5000);
//
//			try (ResultSet rs = statement.executeQuery()) {
//
//				while (rs.next()) {
//					DTOEEclass dto = new DTOEEclass();
//					dto.setProductId(rs.getInt("id"));
//					dto.setProductName(rs.getString("name"));
//					dto.setProductPrice(rs.getInt("price"));
//					resultList.add(dto);
//				}
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//
//		}
//		return resultList;
//	}
//}
