package p02_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/multi.do")
public class MultiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MultiServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		try {
			MultipartRequest multi = new MultipartRequest(
															request,
															context.getRealPath("upload"),
															5 * 1024 * 1024,
															"utf-8",
															new DefaultFileRenamePolicy()
														);
			Enumeration files = multi.getFileNames(); // 제네릭은 일단 생략하자심
			while(files.hasMoreElements()) { // 이건 다음 게 있냐 없냐만 판단
				String file = (String) files.nextElement(); // 넣으면 다음 반복으로 넘어감
				String fileName = multi.getFilesystemName(file);
				String oriFileName = multi.getOriginalFileName(file);
				out.print("<br> file : " + file + "		/ fileName : " + fileName + "		/ oriFileName : " + oriFileName);
//				출력결과
//				file : uploadFile03 / fileName : comma.png / oriFileName : comma.png
//				file : uploadFile02 / fileName : callvideo.png / oriFileName : callvideo.png
//				file : uploadFile01 / fileName : call1.png / oriFileName : call.png
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}