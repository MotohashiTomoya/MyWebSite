package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BuyDateBeans;
import db.DBManager;


//削除ボタンでDB内から情報を消す

public class BuyDao{
	public BuyDateBeans InsertInfomation(String itemId,int userId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="INSERT INTO buy(item_id,user_id)VALUES(?,?)";
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

	public static  ArrayList<BuyDateBeans> findcart(int userId) {
		Connection conn = null;
		ArrayList<BuyDateBeans> Buy = new ArrayList<BuyDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT * FROM buy INNER JOIN item ON buy.item_id=item.id WHERE user_id=?";


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userId);
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を
			// インスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				BuyDateBeans buy = new BuyDateBeans();
				buy.setId(rs.getInt("item_id"));
				buy.setUserId(rs.getInt("user_id"));
				buy.setName(rs.getString("name"));
				buy.setDetail(rs.getString("detail"));
				buy.setPrice(rs.getString("price"));
				buy.setFileName(rs.getString("file_name"));
				Buy.add(buy);
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
		return Buy;
}

	public static int totalPrice(int userId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT SUM(item.price) as total FROM buy INNER JOIN item ON buy.item_id=item.id WHERE user_id=?";


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


}
