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

@WebServlet("/mypage.do")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyPageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("01_5_update.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EmpVO OriginVo  = (EmpVO)session.getAttribute("vo");
		
		EmpVO vo = new EmpVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(request.getParameter("gender"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEnter(OriginVo.getEnter());
		
		EmpDAO dao = EmpDAO.getInstance();
		String url="mypage.do";
		
		if(dao.updateUser(vo, OriginVo.getId()) == 1) {
			url="01_7_result.jsp";
			request.setAttribute("msg", "회원 정보가 수정되었습니다.");
			session.setAttribute("vo", vo);
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
