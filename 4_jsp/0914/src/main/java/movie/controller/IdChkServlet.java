package movie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.UserDAO;

@WebServlet("/check")
public class IdChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IdChkServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("요청 잘 받았나~");
//		System.out.println(request.getParameter("id"));
		String id = request.getParameter("id");
		UserDAO dao = UserDAO.getInstance();
//		if(dao.chkId(id)) // 한글 깨져서 감 숫자로 하신 이유가 이거인가봄
//			response.getWriter().print(id + "는 사용할 수 없습니다.");
//		else
//			response.getWriter().print("사용 가능한 아이디입니다.");
		response.getWriter().print(dao.chkId(id));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
