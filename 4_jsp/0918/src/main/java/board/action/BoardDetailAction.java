package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDetailAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(request.getParameter("num"));
		dao.updateReadcount(num);
		request.setAttribute("board", dao.findBoardByNum(num));
		RequestDispatcher rd = request.getRequestDispatcher("board/boardDetail.jsp");
		rd.forward(request, response);
	}
}
