package p01_dao;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import p01_vo.EmpVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpDAO {
	private EmpDAO() {
		
	}
	private static EmpDAO instance = new EmpDAO();
	public static EmpDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
/*	public boolean userCheck(String id, String pass, String lev) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select * from employees where id=? and pass=? and lev=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, lev);
			rs = ps.executeQuery();
			if(rs.next())
				return true;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public EmpVO getUser(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmpVO vo = new EmpVO();
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select * from employees where id=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
*/
	public EmpVO getUser(String id, String pass, String lev) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmpVO vo = new EmpVO();
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("select * from employees where id=? and pass=? and lev=?");
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, lev);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));
				vo.setGender(rs.getString("gender"));
				vo.setPhone(rs.getString("phone"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}
	
	public int updateUser(EmpVO vo, String OriginId) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("update employees set id=?, pass=?, name=?, lev=?, gender=?, phone=? where id=?");
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getLev());
			ps.setString(5, vo.getGender());
			ps.setString(6, vo.getPhone());
			ps.setString(7, OriginId);
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int insertUser(EmpVO vo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnection();
//			ps = conn.prepareStatement("insert into employees values=(?, ?, ?, ?, ?, ?, ?)");
			ps = conn.prepareStatement("insert into employees values=(?, ?, ?, ?, SYSDATE, ?, ?)");
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getLev());
			ps.setString(5, vo.getGender());
			ps.setString(6, vo.getPhone());
//			ps.setString(5, vo.getEnter().toString());
//			ps.setString(6, vo.getGender());
//			ps.setString(7, vo.getPhone());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}