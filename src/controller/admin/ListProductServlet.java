package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Pagination;
import model.bean.Product;
import model.bo.ProductBO;

@WebServlet(urlPatterns = { "/danh-sach-san-pham" })
public class ListProductServlet extends HttpServlet {

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
		int currentPage = 1;
		if (req.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int rows = bo.numberOfRecord();
		int recordPerPage = 7;
		int start = Pagination.startPosition(currentPage, recordPerPage);
		int nOfPage = Pagination.noOfPage(rows, recordPerPage);
		int end = Pagination.endPosition(rows, start, recordPerPage);
		List<Product> equipments = bo.getProducts(start, recordPerPage);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/danh-sach-san-pham.jsp");
		req.setAttribute("list", equipments);
		req.setAttribute("start", start);
		req.setAttribute("end", end);
		req.setAttribute("currentPage", currentPage);
		req.setAttribute("noOfPages", nOfPage);
		req.setAttribute("rows", rows);
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
