package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.BoardVO;
import util.DBConnection;
import util.Paging;

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
	
	public BoardVO getBoard(int no) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO vo = null;
		try {
			ps = conn.prepareStatement("select * from board where no=?");
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setId(rs.getString(4));
				vo.setPostdate(rs.getDate(5));
				vo.setVisitcount(rs.getInt(6));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return vo;
	}
	
	public void updateSQL(String sql, String[] values, int no) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			int idx=1;
			if(values != null) {
				idx += values.length;
				for(int i=1; i<=values.length; i++)
					ps.setString(i, values[i-1]);
			}
			if(no != -1)
				ps.setInt(idx, no);
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps);
		}
	}
	
	public void writeBoard(String id, String title, String content) {
		updateSQL("insert into board(no, id, title, content) values (board_seq.nextval, ?, ?, ?)", new String[]{id, title, content}, -1);
	}
	
	public void incVisitCnt(int no) {
		updateSQL("update board set visitcount = visitcount+1 where no=?", null, no);
	}
	
	public void updateBoard(int no, String title, String content) {
		updateSQL("update board set title=?, content=? where no=?", new String[]{title, content}, no);
	}
	
	public void deleteBoard(int no) {
		updateSQL("delete from board where no=?", null, no);
	}
	
	public int cntBoard() {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			ps = conn.prepareStatement("select count(*) from board");
			rs = ps.executeQuery();
			if(rs.next())
				result = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return result;
	}
	
	public List<BoardVO> getBoardList(int start, int end) {
		List<BoardVO> boardList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select  * from ( select tb.*, rownum rn from ( select * from board order by no desc) tb ) where rn between ? and ?");
//			select * from board order by no desc;
//			행번호를 알 수 없음
//			select 결과에 행번호를 추가 → rownum
//			행번호 보여주세요 하고난 다음 정렬하기 때문에...
//			select * from board order by no desc; 자체를 서브쿼리로 씀
//			select tb.*, rownum rn from
//				( select * from board order by no desc ) tb;
//			where rn between start and end 이 where은 from에 대한 조건이기 때문에... 다시 서브쿼리를 씀...
//			그래서 3중 select ㄷㄷㄷ
			ps.setInt(1, start);
			ps.setInt(2, end);
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
	
	public List<BoardVO> getBoardList(String searchWord, Paging paging) {
		List<BoardVO> boardList = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select  * from ( select tb.*, rownum rn from ( select * from board order by no desc) tb ) where rn between ? and ?";
			if(searchWord != null)
				sql = "select  * from ( select tb.*, rownum rn from ( select * from board " + "where title like ? " + "order by no desc) tb ) where rn between ? and ?";
			
			ps = conn.prepareStatement(sql);
			
			int start = 1;
			if(searchWord != null) {
				ps.setString(1, "%" + searchWord + "%");
				start = 2;
			}
			ps.setInt(start, paging.getStart());
			ps.setInt(start+1, paging.getEnd());
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
	
	public int cntBoard(String searchWord) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from board";
		if(searchWord != null)
			sql = "select count(*) from board where title like '%" + searchWord + "%'";
		int result = 0;
		try {	
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next())
				result = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(conn, ps, rs);
		}
		return result;
	}
}
