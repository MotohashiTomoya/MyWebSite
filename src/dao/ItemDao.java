package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.ItemDateBeans;
import db.DBManager;

public class ItemDao{
	public List<ItemDateBeans> findAll() {
		Connection conn = null;
		List<ItemDateBeans> Item = new ArrayList<ItemDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM item";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				String price = rs.getString("price");
				String fileName = rs.getString("file_name");
				ItemDateBeans item = new ItemDateBeans(id, name, detail, price, fileName);

				Item.add(item);
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
		return Item;
	}
	public void InsertInformation(String itemName,String itemDetail, String itemPrice , String image) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="INSERT INTO item(name,detail,price,file_name)VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,itemName );
			ps.setString(2,itemDetail);
			ps.setString(3,itemPrice );
			ps.setString(4,image);
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
	public ItemDateBeans findByItemDetail(String id ) {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM item WHERE id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				ItemDateBeans item = new ItemDateBeans();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setDetail(rs.getString("detail"));
				item.setPrice(rs.getString("price"));
				item.setFileName(rs.getString("file_name"));


				return item;
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
		return null;


	}
	public void DeleteItem(String Id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="DELETE FROM item WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Id);
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
	public List<ItemDateBeans> findSearch(String searchWord) {
		Connection conn = null;
		List<ItemDateBeans> itemList = new ArrayList<ItemDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備

			String sql = "SELECT * FROM item";



			if(!searchWord.equals("")) {
				sql += " WHERE name LIKE  '%" +searchWord + "%'";
			}

			System.out.println(sql);

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String detail = rs.getString("detail");
				String price = rs.getString("price");
				String fileName = rs.getString("file_name");
				ItemDateBeans item = new ItemDateBeans(id, name, detail, price, fileName);

				itemList.add(item);
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
		return itemList;
	}

	public void UpdateItem(String itemName,String itemDetail, String itemPrice , String image ,String itemId) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="UPDATE item SET name=?,detail=?,price=?,file_name=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,itemName );
			ps.setString(2,itemDetail);
			ps.setString(3,itemPrice );
			ps.setString(4,image);
			ps.setString(5,itemId);
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