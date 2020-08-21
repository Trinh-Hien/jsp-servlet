package controller.admin;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RegisterClass;
import model.bo.RegisterClassBO;
/**
 * Servlet implementation class CapNhatDangKiLopTap
 */
@WebServlet("/cap-nhat-dang-ky-lop")
public class CapNhatDangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhatDangKiLopTap() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		RegisterClassBO registerClassBo = new RegisterClassBO();
		int memberId = Integer.parseInt(request.getParameter("memberId"));
		String classId= request.getParameter("classId");
		RegisterClass registerClass = registerClassBo.getRegisterClass(memberId, classId);
		request.setAttribute("rc", registerClass);
		if ("submit".equals(request.getParameter("submit"))) {
			LocalDate registerDate = LocalDate.parse(request.getParameter("registerDate"));
			String payStatus = request.getParameter("payStatus");
			registerClassBo.update(new RegisterClass(memberId, classId, registerDate, payStatus));
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
		} else {

			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/cap-nhat-dang-ky-lop.jsp");
			dispatcher.forward(request, response);
		}

	}

}
