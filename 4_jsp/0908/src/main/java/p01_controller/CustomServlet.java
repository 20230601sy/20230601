package p01_controller;

import java.io.IOException;
//import java.util.Date;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p01_dao.EmpDAO;
import p01_vo.EmpVO;

@WebServlet("/custom.do")
public class CustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CustomServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("01_6_insert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpVO vo = new EmpVO();
		vo.setId(request.getParameter("id"));
		vo.setPass(request.getParameter("pass"));
		vo.setName(request.getParameter("name"));
		vo.setLev(request.getParameter("lev"));
		vo.setGender(request.getParameter("gender"));
		vo.setPhone(request.getParameter("phone"));
		vo.setEnter(new Date());
		
		EmpDAO dao = EmpDAO.getInstance();
		String url="custom.do";
		
		if(dao.insertUser(vo) == 1) {
			url="01_7_result.jsp";
			request.setAttribute("msg", "회원 등록에 성공했습니다.");
			request.setAttribute("vo", vo); // 헤헤 원래 이러면 안 된다심ㅋㅋㅋ
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
