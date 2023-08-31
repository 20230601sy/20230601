package p7_checkbox;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CheckboxServlet")
public class CheckboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckboxServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String[] items = request.getParameterValues("item"); // checkbox는 여러 개가 같은 이름으로 담겨있음 /CheckboxServlet?item=가방&item=시계
		String job = request.getParameter("job");
		
		PrintWriter out = response.getWriter();
		if(items == null) {
			out.print("<html><body><p>선택한 항목이 없습니다.</p></body></html>");
			return;
		}
		out.print("<html><body><p>당신이 선택한 항목입니다.</p><hr><p>");
		for(String item : items)
			out.print(item + " ");
		out.print("</p><hr>"
				+ "<p>" + job + "</p>"
				+ "</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
