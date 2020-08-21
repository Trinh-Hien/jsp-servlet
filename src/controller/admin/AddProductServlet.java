package controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Product;
import model.bo.ProductBO;
@WebServlet(urlPatterns = { "/them-san-pham" })
@MultipartConfig
public class AddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("taikhoan") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-san-pham.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ProductBO bo = new ProductBO();
		Product product = new Product();
		String productId= req.getParameter("productId");
		if(bo.checkPrimary(productId)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-san-pham.jsp");
			req.setAttribute("error", "Mã sản phẩm đã tồn tại");
			dispatcher.forward(req, resp);
			return;
		}
		Part filePart = req.getPart("imageUrl");
		
		if(filePart.getSize()>0) {
			String fileName = getSubmittedFileName(filePart);
			InputStream fileContent = filePart.getInputStream();
			File uploads = new File(getServletContext().getInitParameter("file-upload"));
			File file = new File(uploads, fileName);
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			product.setImageUrl(getSubmittedFileName(filePart));
		}
		product.setProductId(productId);
		product.setProductName(req.getParameter("productName"));
		product.setProductType(req.getParameter("productType"));
		product.setImportDate(parseString(req.getParameter("importDate")));
		product.setWarrantyDate(parseString(req.getParameter("warrantyDate")));	
		product.setStatus(req.getParameter("status"));
		product.setQuantity(Integer.parseInt(req.getParameter("quantity")));
		product.setCost(Float.parseFloat(req.getParameter("cost")));
		bo.insertProduct(product);
		resp.sendRedirect("danh-sach-san-pham");

	}

	private String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE
																													// fix.
			}
		}
		return null;
	}

	public LocalDate parseString(String date) {
		if (date != null) {
			return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return null;
	}

}
