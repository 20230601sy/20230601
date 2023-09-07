package p03_com.study.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p03_com.study.dao.MemberDAO;
import p03_com.study.dto.MemberVO;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("03_4_login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String url = "03_4_login.jsp";
		MemberDAO dao = MemberDAO.getInstance();
		try {
			int result = dao.userCheck(id, pwd);
			//result 결과에 따라서 로그인 성공, 실패, result가 1이면 로그인 성공처리, 세션에 로그인한 사람의 정보를 남김, 로그인 성공페이지로 이동
			// 0, -1 로그인 실패 → 다시 로그인 페이지로 이동, 0 : 비밀번호가 틀림 message를 담아서 넘김, -1 : 아이디가 없음 message를 담아서 넘김
			if(result==1) {
				MemberVO vo = dao.getMember(id);
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", vo);
				request.setAttribute("message", "로그인 성공");
				// 로그인 성공 페이지로 이동, request 전달하려면 forward방식으로 해야함 sendRedirect 안됨
				url = "03_2_main.jsp"; // url만 바꿈
			} else if(result==0) {
				request.setAttribute("message", "비밀번호가 다름");
				// 로그인 페이지로 이동
			} else {
				request.setAttribute("message", "아이디가 없음");
				// 로그인 페이지로 이동
			}
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
