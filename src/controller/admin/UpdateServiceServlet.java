package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Service;
import model.bo.ServiceBO;

@WebServlet(urlPatterns = { "/cap-nhat-dich-vu" })
public class UpdateServiceServlet extends HttpServlet {

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
		ServiceBO bo = new ServiceBO();
		req.setAttribute("service", bo.searchById(req.getParameter("id")));
		RequestDispatcher dispatcher = req.getServletContext()
				.getRequestDispatcher("/views/admin/cap-nhat-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ServiceBO bo = new ServiceBO();
		Service service = new Service();
		service.setServiceId(req.getParameter("serviceId"));
		service.setServiceName(req.getParameter("serviceName"));
		service.setServiceType(req.getParameter("serviceType"));
		service.setPrice(Float.parseFloat(req.getParameter("price")));
		bo.update(service);
		resp.sendRedirect("danh-sach-dich-vu");

	}

}