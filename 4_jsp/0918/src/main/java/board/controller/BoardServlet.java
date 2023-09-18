package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		
		// ActionFactory에 있는 command 매개변수로 가지는 getAction메서드를 호출
		// 리턴 받은 action을 실행시킴 (action.execute() 메서드 이름 통일 강제하기 위해서 인터페이스를 만들어버림)
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		if(action != null)
			action.execute(request, response);
		// 이렇게까지만 해두면 앞으로는 서블릿은 건드릴 필요업슴
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
