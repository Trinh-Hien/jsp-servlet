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
@WebServlet(urlPatterns = {"/cap-nhat-goi"})
public class UpdatePackageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        if (session.getAttribute("taikhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		PackageBO bo= new PackageBO();
		String packageId = req.getParameter("packageId");
		Package package1= bo.getAllById(packageId);
		req.setAttribute("package1", package1);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/cap-nhat-goi.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PackageBO bo= new PackageBO();
		req.setCharacterEncoding("UTF-8");
		String packageId = req.getParameter("packageId");
		String packageName = req.getParameter("packageName");
		String packageType = req.getParameter("packageType");
		String price = (String) req.getParameter("price");
		Package package1 = new Package(packageId, packageName, packageType, Float.parseFloat(price));
		bo.update(package1);	
		resp.sendRedirect(req.getContextPath() + "/danh-sach-goi");
	}
}
