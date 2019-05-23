package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.BuyDateBeans;
import db.DBManager;

public class BuyDao{
	public static int insertBuy(BuyDateBeans bdb) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		int autoIncKey = -1;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO buy(user_id,create_date) VALUES(?,NOW())",
					Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bdb.getUserId());
			st.executeUpdate();

			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				autoIncKey = rs.getInt(1);
			}
			System.out.println("inserting buy-datas has been completed");

			return autoIncKey;
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