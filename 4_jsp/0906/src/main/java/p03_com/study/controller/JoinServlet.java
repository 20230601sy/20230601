package p03_com.study.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import p03_com.study.dao.MemberDAO;
import p03_com.study.dto.MemberVO;

@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("03_5_join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		// System.out.print(vo);
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(vo);
		HttpSession session = request.getSession();
		if(result == 1) {
			// 회원가입 성공
			request.setAttribute("message", "회원가입 성공");
			session.setAttribute("userid", vo.getUserid());
		} else {
			// 회원가입 실패
			request.setAttribute("message", "회원가입 실패");
		}
		RequestDispatcher rd = request.getRequestDispatcher("03_4_login.jsp");
		rd.forward(request, response);
	}
}
