package p2_unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; // 직렬화 역직렬화 스트림할 때 했다심 ㅋㅋㅋ
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		톰캣의 인코딩 방식이 1byte씩인데, 한글은 2byte기 때문에 한글 깨짐...인코딩 방식 변경 필요.
//		response.setCharacterEncoding("utf-8"); // get요청이냐 post 요청이냐에 따라서 달라지기도 하고 이런 식으로 넣어야 할 수도 있다심
//		나중엔 트리거처럼 필터라는 거를 만들어서 매번 서블릿을 만들 때마다 utf-8 바꿔달라고 하지 않고 한번에 걍 자동으로 작업하게끔 해두는 것도 할 거라심
//		그때까지는 매번 때려 넣어야 함... 걍 영어로 쓰자 케케케
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("	<h1>");
		out.println("		Hello Servelet text/html;charset=utf-8으로 넣으면 한글 안 깨짐~");
		out.println("	<h1>");
		out.println("<body>");
		out.println("<html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
