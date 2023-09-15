package movie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class PosterDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PosterDownloadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String title = request.getParameter("title") + ".jpg"; // 확장자 일단은 걍 jpg로 한다심
		String poster = request.getParameter("poster"); // 서버에 저장된 파일명
		
		try {
			File f = new File(path, poster); // (경로, 파일명)의 파일이 객체에 담김, File import 필요함...
			InputStream is = new FileInputStream(f); // 파일입출력스트림 써야 함. 파일을 서버쪽으로 가져온 거임.
			// 사용자 브라우저에 따라 인코딩 방식이 달라서(익스플로러가 인코딩방식이 다름 다른 건 다 동일한데 ㅡ_ㅡ)
			String client = request.getHeader("User-Agent"); // 요청을 날린 사람의 브라우저 정보를 client에 담음
			if(client.indexOf("WOW64") == -1) // WOW64(익스프롤러)가 포함된 위치를 리턴해주는 거 -1이면 없는 거니 익스프롤러가 아니라는 얘기임
				title = new String(title.getBytes("utf-8"),"iso-8859-1");
			else
				title = new String(title.getBytes("ksc5601"),"iso-8859-1");
			
			response.reset();
			response.setContentType("application/octet-stream"); // octet은 8비트 단위의 데이터라는 걸 의미한다심...
			response.setHeader("Content-Disposition", "attachment; filename=\""+title+"\"");
			response.setHeader("Content-length", ""+f.length()); // 문자값으로 들어가야 해서 ""+ 처리함
			OutputStream os = response.getOutputStream();
			byte[] b = new byte[(int)f.length()]; // 바이트단위로 전송이되다보니깐...
			int readBuffer = 0;
			
			while((readBuffer = is.read(b)) > 0) // 입력스트림에서 읽어온 값을 대입시키고, 대입시킨 값이 0보다 큰지 확인...
				os.write(b, 0, readBuffer);
			
			os.close();
			is.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
