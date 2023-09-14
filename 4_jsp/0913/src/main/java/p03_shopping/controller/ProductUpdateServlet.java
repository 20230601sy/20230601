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

@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		ProductDAO dao = ProductDAO.getInstance();
		request.setAttribute("product", dao.getProduct(code));
		RequestDispatcher rd = request.getRequestDispatcher("03_product/productUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		ServletContext context = getServletContext();
		MultipartRequest multi = new MultipartRequest(
														request,
														context.getRealPath("03_upload"),
														10*1024*1024,
														"utf-8",
														new DefaultFileRenamePolicy()
													);
		ProductVO vo = new ProductVO();
		vo.setCode(code);
		vo.setName(multi.getParameter("name"));
		vo.setPrice(Integer.parseInt(multi.getParameter("price")));
		// 여기서 처리할 건가 아님 dao??? dao!!! 흐음... jsp에서 hidden 갖구 오시게 하시는 거면 여기서 처리하시려나 봄...
		String picutreUrl = multi.getFilesystemName("pictureUrl");
		if(picutreUrl == null)
			picutreUrl = multi.getFilesystemName("originPictureUrl");
		vo.setPictureUrl(picutreUrl);
		vo.setDescription(multi.getParameter("description"));
		ProductDAO dao = ProductDAO.getInstance();
		dao.updateProduct(vo);
		response.sendRedirect("productList.do");
//		RequestDispatcher rd = request.getRequestDispatcher("productUpdate.do?code="+code);
//		rd.forward(request, response);
	}
}