package movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.dao.MovieDAO;

@WebServlet("/moviedetail")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		MovieDAO dao = MovieDAO.getInstance();
		request.setAttribute("movie", dao.findByCode(code));
		RequestDispatcher rd = request.getRequestDispatcher("movieDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}