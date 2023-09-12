package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.BoardDAO;
import VO.BoardVO;

@WebServlet("/boardlist.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		
//		List 전체 다 보여주는 거
//		List<BoardVO> boardList = dao.getBoardList();
//		request.setAttribute("boardList", boardList);
//		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
//		rd.forward(request, response);
		
//		List 잘라서 보여주는데 List 전체가 왔다갔다 하는 불필요한 거 ㅡㅡ
//		List<BoardVO> boardList = dao.getBoardList();
//		request.setAttribute("boardList", boardList);
//		String page = request.getParameter("page");
//		if(page==null)
//			page="1";
//		RequestDispatcher rd = request.getRequestDispatcher("boardList2.jsp?page=" + page);
//		rd.forward(request, response);
		
//		애초에 페이지 보내줄 때 List 잘라서 보내주는 거
		List<BoardVO> boardList = dao.getBoardList();		
		String page_ = request.getParameter("page");
		int page;
		if(page_==null)
			page=1;
		else
			page = Integer.parseInt(page_);
		
		List<BoardVO> selectList = boardList.subList(10*(page-1), Math.min(boardList.size(), 10*page)); 
		request.setAttribute("boardList", selectList);
		int pageNo = (int)((boardList.size()+9)/10); 
		request.setAttribute("pageNo", pageNo);
		RequestDispatcher rd = request.getRequestDispatcher("boardList3.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord");
		BoardDAO dao = BoardDAO.getInstance();
		List<BoardVO> boardList = dao.getBoardList(searchWord);
		
		request.setAttribute("boardList", boardList);
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
	}

}
