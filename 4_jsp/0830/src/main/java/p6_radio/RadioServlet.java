package p6_radio;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RadioServlet")
public class RadioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RadioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String gender = request.getParameter("gender");
		String chk_mail = request.getParameter("chk_mail");
		String content = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<p>당신이 입력한 정보입니다.</p><hr>");
		out.print("<p>성별 : <b>" + gender + "</b></p>");
		out.print("<p>메일 정보 수신 여부 : <b>" + chk_mail + "</b></p>");
		out.print("<p>가입 인사 : <br><pre><b>" + content + "</b></pre></p>");
		out.print("<a href='javascript:history.go(-1)'>다시</a>");
		out.print("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
