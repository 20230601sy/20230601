package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import VO.BoardVO;
import VO.UserVO;

@WebServlet("/updateboard.do")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boardVo = dao.getBoard(no);
		String boardId = boardVo.getId();
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("loginUser");
		String userId = userVo.getId();
		String url = "detail.jsp";
		if(boardId.equals(userId)) {
			request.setAttribute("detailBoard", boardVo); 
			url = "updateBoard.jsp" ;
		}
		RequestDispatcher rd = request.getRequestDispatcher(url + "?no=" + no);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO boardVo = dao.getBoard(no);
		String boardId = boardVo.getId();
		HttpSession session = request.getSession();
		UserVO userVo = (UserVO) session.getAttribute("loginUser");
		String userId = userVo.getId();
		if(boardId.equals(userId))
			dao.updateBoard(no, title, content);
		response.sendRedirect("boardlist.do");
	}
}