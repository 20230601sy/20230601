package p8_join;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		String societyId1 = request.getParameter("societyId1");
		String societyId2 = request.getParameter("societyId2");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String mailId = request.getParameter("mailId");
		String mailDomain1 = request.getParameter("mailDomain1");
		String mailDomain2 = request.getParameter("mailDomain2");
		String mailDomain = mailDomain1!=""? mailDomain1 : mailDomain2; 
		String zip = request.getParameter("zip");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String[] interests = request.getParameterValues("interests");
		
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		out.print("<p>이름 : <b>" + name + "</b></p>");
		out.print("<p>주민번호 : <b>" + societyId1 + "-" + societyId2 + "</b></p>");
		out.print("<p>아이디 : <b>" + id + "</b></p>");
		out.print("<p>비밀번호 : <b>" + pw + "</b></p>");
		out.print("<p>이메일 : <b>" + mailId + "@" + mailDomain + "</b></p>");
		out.print("<p>우편번호 : <b>" + zip + "</b></p>");
		out.print("<p>주소 : <b>" + address1 + " " + address2 + "</b></p>");
		out.print("<p>핸드폰번호 : <b>" + phone + "</b></p>");
		out.print("<p>직업 : <b>" + job + "</b></p>");
		out.print("<p>관심분야 : <b>");
		if(interests!=null)
			for(String i : interests)
				out.print(i + " ");
		out.print("</b></p>");
		out.print("</body></html>");
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}