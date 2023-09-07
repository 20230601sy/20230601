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

@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 정보수정 페이지로 이동
		 * 정보수정 페이지에는 현재 로그인한 사용자의 정보가 다 출력
		 * 로그인한 사람의 정보를 세션, 리퀘스트 객체에 담고 정보수정 페이지로 이동을 해줘야 함
		 * 지금 작업한 프로젝트는 이미 세션에 그 정보가 다 담겨있음
		 * 페이지 이동할 때 로그인한 사람의 아이디를 파라미터로 보냄
		 * 그 아이디를 이용해서 DB에서 정보를 빼옴
		 * 빼온 정보를 리퀘스트 객체에 담음 → 페이지 이동
		 */
		String userid = request.getParameter("userid");
		MemberDAO dao = MemberDAO.getInstance();
		try {
			MemberVO vo = dao.getMember(userid);
			request.setAttribute("vo", vo);
			RequestDispatcher rd = request.getRequestDispatcher("03_7_memberUpdate.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(request.getParameter("pwd"));
		vo.setEmail(request.getParameter("email"));
		vo.setPhone(request.getParameter("phone"));
		vo.setAdmin(Integer.parseInt(request.getParameter("admin")));
		
		MemberDAO dao = MemberDAO.getInstance();
		HttpSession session = request.getSession();
//		int result = dao.updateMember(vo);
		if(dao.updateMember(vo) == 1) {
			session.setAttribute("loginUser", vo); // DB만 수정하고 session 정보 업데이트 안 하면 나중에 문제가 생길 수 있음~
			request.setAttribute("message", "정보수정 성공");
		} else {
			request.setAttribute("message", "정보수정 실패");
		}
//		RequestDispatcher rd = request.getRequestDispatcher("03_4_login.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("03_2_main.jsp");
		rd.forward(request, response);
	}
}
