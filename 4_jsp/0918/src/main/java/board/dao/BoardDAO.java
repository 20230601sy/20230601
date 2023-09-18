package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.util.DBManager;
import board.vo.BoardVO;

public class BoardDAO {
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> listAll(){
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<BoardVO> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement("select * from newboard order by num");
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNum(rs.getInt(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setReadcount(rs.getInt(7));
				vo.setWritedate(rs.getTimestamp(8));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	
	public void insert(BoardVO vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("insert into newboard values(newboard_seq.nextval, ?, ?, ?, ?, ?, 0, sysdate)");
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
	
	public BoardVO findBoardByNum(int num){
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			ps = conn.prepareStatement("select * from newboard where num=?");
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setNum(rs.getInt(1));
				vo.setPass(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setEmail(rs.getString(4));
				vo.setTitle(rs.getString(5));
				vo.setContent(rs.getString(6));
				vo.setReadcount(rs.getInt(7));
				vo.setWritedate(rs.getTimestamp(8));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return vo;
	}
	
	public void updateReadcount(int num) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update newboard set readcount=readcount+1 where num=?");
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
	
	public void update(BoardVO vo) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update newboard set pass=?, name=?, email=?, title=?, content=? where num=?");
			ps.setString(1, vo.getPass());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getEmail());
			ps.setString(4, vo.getTitle());
			ps.setString(5, vo.getContent());
			ps.setInt(6, vo.getNum());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
	
	public void delete(int num) {
		Connection conn = DBManager.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from newboard where num=?");
			ps.setInt(1, num);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps);
		}
	}
}
