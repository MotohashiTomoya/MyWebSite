package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.BuyDetailDateBeans;
import db.DBManager;
public class BuyDetailDao {

public static void insertBuyDetail(BuyDetailDateBeans bddb) throws SQLException {
	Connection con = null;
	PreparedStatement st = null;
	try {
		con = DBManager.getConnection();
		st = con.prepareStatement(
				"INSERT INTO buy_detail(buy_id,item_id) VALUES(?,?)");
		st.setInt(1, bddb.getBuyId());
		st.setInt(2, bddb.getItemId());
		st.executeUpdate();

	} catch (SQLException e) {
		System.out.println(e.getMessage());
		throw new SQLException(e);
	} finally {
		if (con != null) {
			con.close();
		}
	}
}
}