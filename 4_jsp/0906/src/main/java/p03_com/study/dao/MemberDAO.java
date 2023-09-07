package p03_com.study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import p03_com.study.dto.MemberVO;

public class MemberDAO {
	private MemberDAO() {
		
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		return conn;
	}
	
	public int userCheck(String userid, String pwd) throws SQLException {
		int result = -1;
		String sql = "select pwd from member where userid=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			rs.next();
			if(rs.getString("pwd") != null && pwd.equals(rs.getString("pwd"))) {
				result = 1;
			} else if(rs.getString("pwd") != null) {
				result = -1;
			} else {
				result = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close(); // 이것도 예외 처리해야 해서 throws SQLException 처리함
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}
		
		return result;
	}
	
	public MemberVO getMember(String userid) throws SQLException {
		MemberVO mVo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where userid=?";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
				mVo = new MemberVO();
				mVo.setName(rs.getString("name"));
				mVo.setUserid(rs.getString("userid"));
				mVo.setPwd(rs.getString("pwd"));
				mVo.setEmail(rs.getString("email"));
				mVo.setPhone(rs.getString("phone"));
				mVo.setAdmin(rs.getInt("admin"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		}
		
		return mVo;
	}
	
	public int confirmID(String userid) {
		int result = -1; // 중복된 아이디가 있으면 1 없으면 -1
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select userid from member where userid=?";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int insertMember(MemberVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getUserid());
			ps.setString(3, vo.getPwd());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getPhone());
			ps.setInt(6, vo.getAdmin());
			
			result = ps.executeUpdate(); // executeUpdate는 레코드 수를 리턴 시킴~
			// insert 삽입된 레코드 수 리턴 시킴, delete 삭제를 성공한 레코드 수 리턴 시킴, update 업데이트를 성공한 레코드 수를 리턴시킴
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
		
		/*
		 * 이제....
		 * 회원가입 페이지에서 입력한 파라미터를 서블릿으로 요청 날림
		 * 서블릿에서 요청받은 파라미터드를 빼와서 vo 객체에 넣음
		 * vo객체를 insertMember메서드에 보냄
		 * 결과를 리턴 -1, 0, 1
		 * 결과 값을 가지고 회원가입 성공, 실패여부를 처리
		 * 다시 로그인 페이지로 이동
		 */
		
	}
	
	public int updateMember(MemberVO vo) {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update member set pwd=?, email=?, phone=?, admin=? where userid=?";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getPwd());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getPhone());
			ps.setInt(4, vo.getAdmin());
			ps.setString(5, vo.getUserid());
			
			result = ps.executeUpdate();
			System.out.print(vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void deleteMember(String userid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from member where userid=?";
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
