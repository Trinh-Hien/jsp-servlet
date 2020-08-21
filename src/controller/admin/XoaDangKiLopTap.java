package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.RegisterClassBO;


/**
 * Servlet implementation class XoaDangKiLopTap
 */
@WebServlet("/xoa-dang-ky-lop-tap")
public class XoaDangKiLopTap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XoaDangKiLopTap() {
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

		RegisterClassBO registerClassBo = new RegisterClassBO();

		String classId = request.getParameter("classId");
		int memberId= Integer.parseInt(request.getParameter("memberId"));

		registerClassBo.delete(classId, memberId);

		response.sendRedirect(request.getContextPath() + "/danh-sach-dang-ky-lop");
	}

}
