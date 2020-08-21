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

import model.bean.RegisterService;
import model.bo.RegisterServiceBO;


/**
 * Servlet implementation class CapNhapDangKyDichVu
 */
@WebServlet("/cap-nhat-dang-ky-dich-vu")
public class CapNhapDangKyDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CapNhapDangKyDichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// kiem tra da dang nhap chua
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		RegisterServiceBO registerServiceBO = new RegisterServiceBO();
		int id = Integer.parseInt(request.getParameter("id"));
		RegisterService registerService = registerServiceBO.getRegisterServiceById(id);
		request.setAttribute("rs", registerService);
		if ("submit".equals(request.getParameter("submit"))) {
			String maDv = request.getParameter("maDv");
			int maTv = Integer.parseInt(request.getParameter("maTv"));
			LocalDate registerDate = LocalDate.parse(request.getParameter("thoiGian"));
			int amount = Integer.parseInt(request.getParameter("chiPhi"));
			String status= request.getParameter("status");
			RegisterService rs= new RegisterService(id, maDv, maTv, registerDate, amount, status);
			registerServiceBO.update(rs);
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-dich-vu");
		} else if ("cancel".equals(request.getParameter("cancel"))) {
			response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-dich-vu");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/cap-nhat-dang-ky-dich-vu.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
