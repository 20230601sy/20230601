package movie.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import movie.dao.MovieDAO;
import movie.vo.MovieVO;

@WebServlet("/moviewrite")
public class MovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("movieWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		MultipartRequest multi = new MultipartRequest(request, context.getRealPath("upload"), 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		MovieVO vo = new MovieVO();
		vo.setTitle(multi.getParameter("title"));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		vo.setDirector(multi.getParameter("director"));
		vo.setActor(multi.getParameter("actor"));
		vo.setPoster(multi.getFilesystemName("poster"));
		vo.setSynopsis(multi.getParameter("synopsis"));
		MovieDAO dao = MovieDAO.getInstance();
		dao.insertMovie(vo);
		response.sendRedirect("movielist");
	}
}