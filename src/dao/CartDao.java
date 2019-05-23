package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CartDateBeans;
import db.DBManager;

public class CartDao{
	public CartDateBeans InsertInfomation(String itemId,int userId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="INSERT INTO cart(item_id,user_id)VALUES(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,itemId );
			ps.setInt(2,userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;


	}

	public static  ArrayList<CartDateBeans> findcart(int userId) {
		Connection conn = null;
		ArrayList<CartDateBeans> Cart = new ArrayList<CartDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT * FROM cart INNER JOIN item ON cart.item_id=item.id WHERE user_id=?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// インスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				CartDateBeans cart = new CartDateBeans();
				cart.setId(rs.getInt("item_id"));
				cart.setUserId(rs.getInt("user_id"));
				cart.setName(rs.getString("name"));
				cart.setDetail(rs.getString("detail"));
				cart.setPrice(rs.getString("price"));
				cart.setFileName(rs.getString("file_name"));
				Cart.add(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return Cart;
}

	public static int totalPrice(int userId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT SUM(item.price) as total FROM cart INNER JOIN item ON cart.item_id=item.id WHERE user_id=?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int total=rs.getInt("total");
				return total;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
		return 0;
}

	public void DeleteCart(int usetId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="DELETE FROM cart WHERE user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,usetId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally  {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}
}
