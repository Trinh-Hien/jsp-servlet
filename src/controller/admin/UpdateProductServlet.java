package controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Product;
import model.bo.ProductBO;

@WebServlet(urlPatterns = { "/cap-nhat-san-pham" })
public class UpdateProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("taikhoan") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		ProductBO bo = new ProductBO();
		String productId = req.getParameter("id");
		Product product = bo.getProduct(productId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/cap-nhat-san-pham.jsp");
		req.setAttribute("product", product);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ProductBO bo = new ProductBO();
		Product product = new Product();
		product.setProductId(req.getParameter("productId"));
		product.setProductName(req.getParameter("productName"));
		product.setProductType(req.getParameter("productType"));
		product.setImportDate(parseString(req.getParameter("importDate")));
		product.setWarrantyDate(parseString(req.getParameter("warrantyDate")));
		product.setStatus(req.getParameter("status"));
		product.setCost(Float.parseFloat(req.getParameter("cost")));
		bo.updateProduct(product);
		resp.sendRedirect("danh-sach-san-pham");
	}

	public LocalDate parseString(String date) {
		if (date != null) {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return null;
	}

}
