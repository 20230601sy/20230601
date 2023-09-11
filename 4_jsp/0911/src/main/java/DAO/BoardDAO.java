package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.BoardVO;
import util.DBConnection;

public class BoardDAO {
	private BoardDAO() {
		
	}
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	public List<BoardVO> getBoardList() {
		List<BoardVO> boardList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from board order by no desc");
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setId(rs.getString(4));
				vo.setPostdate(rs.getDate(5));
				vo.setVisitcount(rs.getInt(6));
				boardList.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return boardList;
	}
	
	public List<BoardVO> getBoardList(String searchWord) {
		List<BoardVO> boardList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// PreparedStatement에서 like 사용하기 https://m.blog.naver.com/formalpkh/40194182078
//			ps = conn.prepareStatement("select * from board where title like '%" + searchWord + "%' order by no desc");
//			ps = conn.prepareStatement("select * from board where title like '%' || ? || '%' order by no desc");
//			ps.setString(1, searchWord);
			ps = conn.prepareStatement("select * from board where title like ? order by no desc");
			ps.setString(1, "%" + searchWord + "%");
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setId(rs.getString(4));
				vo.setPostdate(rs.getDate(5));
				vo.setVisitcount(rs.getInt(6));
				boardList.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return boardList;
	}
}
