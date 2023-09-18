package board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실재 구현해야 하는 내용이 들어갈 곳
		// 기존에는 서블릿에서 했던 건데... 이제 클래스 메서드로...
		List<BoardVO> list = new ArrayList<>();
		BoardDAO dao = BoardDAO.getInstance();
		list = dao.listAll();
		request.setAttribute("boards", list);
		RequestDispatcher rd = request.getRequestDispatcher("board/boardList.jsp");
		rd.forward(request, response);
	}

}
