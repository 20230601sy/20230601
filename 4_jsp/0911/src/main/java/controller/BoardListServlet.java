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
import util.Paging;

@WebServlet("/boardlist.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		String searchWord = request.getParameter("searchWord");
		int page = 1;
		Paging paging = new Paging();
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		paging.pageCalc(dao.cntBoard(searchWord), page);
		
		List<BoardVO> boardList = dao.getBoardList(searchWord, paging);		
		request.setAttribute("boardList", boardList);
		request.setAttribute("paging", paging);
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
