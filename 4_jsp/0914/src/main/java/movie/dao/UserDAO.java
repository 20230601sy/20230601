package movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import movie.util.DBManager;
import movie.vo.UserVO;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	public UserVO chkUser(String id, String pw) {
		UserVO vo = null;
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from movieuser where id=? and pw=?");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO();
				vo.setId(rs.getString(1));
				vo.setPw(rs.getString(2));
				vo.setLv(rs.getString(3));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return vo;
	}
	
	public boolean chkId(String id) {
		boolean result = false;
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from movieuser where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next())
				result = true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return result;
	}
}