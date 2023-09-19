package p01_mail.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import p01_mail.smtp.MailSMTP;

@WebServlet("/send")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		MailSMTP mail = new MailSMTP();
		int result = mail.sendMail(to, subject, content);
		if(result == 1)
			request.setAttribute("msg", "메일 전송 성공");
		else
			request.setAttribute("msg", "메일 전송 실패");
		RequestDispatcher rd = request.getRequestDispatcher("01_sendMail.jsp");
		rd.forward(request, response);
	}

}
