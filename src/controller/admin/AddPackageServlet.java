package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.PackageBO;
import model.bean.Package;

@WebServlet(urlPatterns = { "/them-goi" })
public class AddPackageServlet extends HttpServlet {

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-goi.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PackageBO bo = new PackageBO();
		req.setCharacterEncoding("UTF-8");
		String packageId = req.getParameter("packageId");
		if(bo.checkPrimary(packageId)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-goi.jsp");
			req.setAttribute("error", "Mã gói đã tồn tại");
			dispatcher.forward(req, resp);
		}
		String packageName = req.getParameter("packageName");
		String packageType = req.getParameter("packageType");
		String packagePrice = req.getParameter("price");
		Package package1 = new Package(packageId, packageName, packageType, Float.parseFloat(packagePrice));
		bo.insert(package1);
		req.setAttribute("package", package1);
		resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
	}
}
