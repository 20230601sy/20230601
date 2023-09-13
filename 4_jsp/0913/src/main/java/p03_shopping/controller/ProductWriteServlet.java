package p03_shopping.controller;

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

import p03_shopping.dao.ProductDAO;
import p03_shopping.vo.ProductVO;

@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("03_product/productWrite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 받아온 파일을 서버에 저장 (webapp > 03_upload 폴더 생성함)
		ServletContext context = getServletContext();
		MultipartRequest multi = new MultipartRequest(
														request,
														context.getRealPath("03_upload"),
														10*1024*1024,
														"utf-8",
														new DefaultFileRenamePolicy()
													);
		ProductVO vo = new ProductVO();
		vo.setName(multi.getParameter("name"));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
//		vo.setPictureUrl(multi.getParameter("pictureUrl"));
		vo.setPictureUrl(multi.getFilesystemName("pictureUrl"));
		vo.setDescription(multi.getParameter("description"));
		
		// 파라미터로 받아온 데이터를 DB에 저장
		ProductDAO dao = ProductDAO.getInstance();
		dao.insertProduct(vo);
		
		// 둘다 완료가 되면 목록페이지로 이동
		response.sendRedirect("productList.do");
	}

}
