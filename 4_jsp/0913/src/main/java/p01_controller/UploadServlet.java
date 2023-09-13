package p01_controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); // 교재는 page 이동 없이 바로 아웃시키려고 하나보다심, 이렇게 할 일은 없다심... 초기에 했던 그...
		PrintWriter out = response.getWriter();
		
		String savePath = "upload"; // webapp 폴더에 만든 폴더 이름
		int uploadFileSizeLimit = 5*1024*1024; // 최대 파일 크기 인트형 변수에, 값은 바이트 단위로 넣어야 함... 즉, 5MB 제한 걸은 거임
		String encType = "utf-8";
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		System.out.println("서버상의 실제 디렉토리 : " + uploadFilePath); // 서버상의 실제 디렉토리 : D:\Y\0913upload
		try {
			MultipartRequest multi = new MultipartRequest(
															request, 				// request 객체
															uploadFilePath,			// 서버에 저장할 파일 경로
															uploadFileSizeLimit,	// 업로드 파일의 최대 크기(byte 단위)
															encType,				// 인코딩 타입
															new DefaultFileRenamePolicy()
														); // 생성자 순서는 정해져 있기 때문에 꼭 정해진 대로 넣어야 함.
			// 객체를 multi에 저장했으니까 request.getParameter 하던 것들이... multi.getParameter가 됨
			String fileName = multi.getFilesystemName("uploadFile"); // 01_upload.jsp에서 input type file 태그에 설정한 name이 uploadFile 임
			if(fileName == null)
				System.out.println("파일 업로드 안함");
			else {
				out.print("<br> 글쓴이 : " + multi.getParameter("name"));
				out.print("<br> 제목 : " + multi.getParameter("name"));
				out.print("<br> 파일명 : " + fileName);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}