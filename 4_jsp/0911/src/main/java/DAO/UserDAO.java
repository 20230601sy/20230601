package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import VO.UserVO;
import util.DBConnection;

public class UserDAO {
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance(){
		return instance;
	}
	public UserVO chkUser(String id, String pw) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserVO vo = null;
		try {
			ps = conn.prepareStatement("select * from boarduser where id=? and pw=?");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new UserVO();
				vo.setId(id);
				vo.setPw(pw);
				vo.setName(rs.getString(3));
				vo.setRegidate(rs.getDate(4));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return vo;
	}
}
