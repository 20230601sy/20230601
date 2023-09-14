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

@WebServlet("/movieupdate.do")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MovieUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		MovieDAO dao = MovieDAO.getInstance();
		request.setAttribute("movie", dao.findByCode(code));
		RequestDispatcher rd = request.getRequestDispatcher("movieUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		ServletContext context = request.getServletContext();
		MultipartRequest multi = new MultipartRequest(request, context.getRealPath("upload"), 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		MovieVO vo = new MovieVO();
		vo.setCode(code);
		vo.setTitle(multi.getParameter("title"));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		vo.setDirector(multi.getParameter("director"));
		vo.setActor(multi.getParameter("actor"));
		String poster = multi.getFilesystemName("poster");
		if(poster == null)
			poster = multi.getParameter("originPoster");
		vo.setPoster(poster);
		vo.setSynopsis(multi.getParameter("synopsis"));
		MovieDAO dao = MovieDAO.getInstance();
		dao.updateMovie(vo);
		response.sendRedirect("movielist.do");
	}
}