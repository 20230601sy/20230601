package p4_unit03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
//		String age = request.getParameter("age"); // parameter로 받아온 거는 일단 문자라서 명시적 형변환해야 함, 그리고 입력을 안 했을 때의 처리...서버나 클라이언트 모두 할 수 있는데,,, 일반적으로는 입력안했을 때는 전송 자체를 못하게 함. 자바스크립트로 하겠죠라심ㅋㅋㅋ
		int age = Integer.parseInt(request.getParameter("age"));
		PrintWriter out = response.getWriter();
		out.print("<html><body>"
					+ "<h1>아이디 : " + id + "</h1>"
					+ "<h1>나이 : " + age + "</h1>"
					+ "<h1>" + (age>18 ? "성인" : "청소년") + "</h1>"
				+ "</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
