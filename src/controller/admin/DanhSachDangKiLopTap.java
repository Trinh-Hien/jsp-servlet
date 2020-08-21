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

import model.bean.RegisterClass;
import model.bo.RegisterClassBO;

/**
 * Servlet implementation class DanhSachDangKiLopTap
 */
@WebServlet("/danh-sach-dang-ky-lop")
public class DanhSachDangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachDangKiLopTap() {
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
		List<RegisterClass> listRegisterClasses = registerClassBo.getAll();
		request.setAttribute("listRegisterClass", listRegisterClasses);


		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/danh-sach-dang-ky-lop.jsp");
		dispatcher.forward(request, response);
	}

}
