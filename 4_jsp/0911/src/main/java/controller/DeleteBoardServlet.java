package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BoardDAO;
import VO.BoardVO;
import VO.UserVO;

@WebServlet("/deleteboard.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteBoardServlet() {
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
		if(boardId.equals(userId))
			dao.deleteBoard(no);
		response.sendRedirect("boardlist.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}