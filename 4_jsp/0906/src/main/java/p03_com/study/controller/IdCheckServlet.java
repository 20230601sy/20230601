package p03_com.study.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p03_com.study.dao.MemberDAO;

@WebServlet("/idcheck.do")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = MemberDAO.getInstance();
		String userid = request.getParameter("userid");
		int result = dao.confirmID(userid);
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		// 그냥 메세지로 구현해도 됨 구현하는 사람 마음... 서블릿 쪽에서 하는게 좀더 낫다심 헤헤 책이 마음에 안드는 거여
		RequestDispatcher rd = request.getRequestDispatcher("03_6_idCheck.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
