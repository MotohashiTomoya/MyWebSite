package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.UserDateBeans;
import common.Code;
import db.DBManager;

public class UserDao {

	/**
	 * ログインIDとパスワードに紐づくユーザ情報を返す
	 * @param loginId
	 * @param password
	 * @return
	 */
	public UserDateBeans findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";

			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, Code.code(password));
			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			// 必要なデータのみインスタンスのフィールドに追加
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			int id=rs.getInt("id");
			return new UserDateBeans(loginIdData, nameData,id);

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
	}

	/**
	 * 全てのユーザ情報を取得する
	 * @return
	 */
	public List<UserDateBeans> findAll() {
		Connection conn = null;
		List<UserDateBeans> userList = new ArrayList<UserDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user WHERE login_id!='admin'";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				UserDateBeans user = new UserDateBeans(id, loginId, name, password, createDate);

				userList.add(user);
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
		return userList;
	}
	public void InsertInformation(String loginId, String password, String name) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="INSERT INTO user(login_id,name,password,create_date)VALUES(?,?,?,NOW())";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,loginId );
			ps.setString(2,name);
			ps.setString(3,Code.code(password));
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
	public int findBynewuserinfo(String loginId) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
//			サブリクエ
			String sql = "SELECT count(*)AS matchUser FROM user WHERE login_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			return rs.getInt("matchUser");
		}catch (SQLException e) {
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
		return 0;

	}
	public List<UserDateBeans> findSearch(String loginIdP, String userNameP) {
		Connection conn = null;
		List<UserDateBeans> userList = new ArrayList<UserDateBeans>();

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			// TODO: 未実装：管理者以外を取得するようSQLを変更する
			String sql = "SELECT * FROM user WHERE login_id!='admin'";


			if(!loginIdP.equals("")) {
				sql += " AND login_id = '" + loginIdP + "'";
			}
			if(!userNameP.equals("")) {
				sql += " AND name LIKE  '%" + userNameP + "%'";
			}

			System.out.println(sql);

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// 結果表に格納されたレコードの内容を
			// Userインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");

				UserDateBeans user = new UserDateBeans(id, loginId, name, password, createDate);

				userList.add(user);
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
		return userList;
	}

	public UserDateBeans findByUserDetail(String id ) {
		Connection conn = null;

		try {
			// データベースへ接続
			conn = DBManager.getConnection();

			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				UserDateBeans u = new UserDateBeans();
				u.setId(rs.getInt("id"));
				u.setLoginId(rs.getString("login_id"));
				u.setName(rs.getString("name"));
				u.setCreateDate(rs.getString("create_date"));


				return u;
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
	public void UpdateUser(String Id,  String password, String name) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="UPDATE user SET password=?,name=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Code.code(password));
			ps.setString(2,name);
			ps.setString(3,Id);
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
	public void UpdateUser2(String Id, String name) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="UPDATE user SET name=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1,name);
			ps.setString(2,Id);
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
	public void DeleteUser(String Id) {
		Connection conn = null;
		try {
			// データベースへ接続
			conn = DBManager.getConnection();
			String sql="DELETE FROM user WHERE id=?";
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
}