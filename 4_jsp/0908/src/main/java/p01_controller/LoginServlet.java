package p01_controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p01_dao.EmpDAO;
import p01_vo.EmpVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("01_2_login.jsp"); // 주소가 login.do에서 안 바뀌게 하기 위해서 forward 방식 (not sendredirect) 
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String lev = request.getParameter("lev");
		String url = "01_2_login.jsp";
		
		EmpDAO dao = EmpDAO.getInstance();
		EmpVO vo = dao.getUser(id, pass, lev);
		if(vo != null) {
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo);
			url = "01_4_main.jsp";
		} else {
			request.setAttribute("msg", "로그인 실패");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url); 
		rd.forward(request, response);
	}
}
