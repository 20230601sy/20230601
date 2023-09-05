package p1_test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
// "/test" 실제로 class명을 노출하지는 않으니까 변경하고 실행시키면 브라우저 주소창에 http://localhost:8181/0830/TestServlet 이게 변경됨 주소/프로젝트 명/어노테이션에 써져있는 내용
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int num1 = 20;
		int num2 = 10;
		int add = num1 + num2;
//		PrintWriter out = response.getWriter();
//		out.println("<html><head><title>Test</title></head><body><h1>hello servlet"+add+"</h1></body></html>");
//		옛날에는 여기 html 작업을 다 했다심, 이런 거 안 하려고 jsp 쓰는 거라심
//		한번에 다 써도 되고 솔직히 이런 거 다 안 써도 보이기는 한다심
		
//		HttpServletRequest request 로그인을 예로 들면 아이디랑 비번이 담기는 객체, 각종 요청에 관한 정보가 담기는 객체
//		HttpServletResponse response 응답 객체
//		PrintWriter 외에도 입출력스트림 PrintStream 같은 거도 있었는데 PrintWriter를 쓴 이유는 언어 제약이 적어서인가봄
		
		request.setAttribute("num1", num1); // key와 value로 속성 담는 거
		request.setAttribute("num2", num2);
		request.setAttribute("add", add);
		
		RequestDispatcher rd = request.getRequestDispatcher("helloworld.jsp"); // 담아놓은 걸 보내줄 jsp 파일명
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
