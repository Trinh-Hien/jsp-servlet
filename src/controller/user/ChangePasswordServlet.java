package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bo.AccountBO;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/thaydoimatkhau")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("login");
			return;
		}
		Account account = (Account) session.getAttribute("taikhoan");
		AccountBO bo = new AccountBO();
		if ("submit".equals(request.getParameter("submit"))) {
			String accountName = request.getParameter("username");
			String olderPassword = request.getParameter("password");
			String newPasword = request.getParameter("newpassword");
			String rePassword = request.getParameter("repassword");
			if (!olderPassword.equals(account.getPassword())) {
				request.setAttribute("error", "Mật khẩu hiện tại không đúng");
			} else if (!newPasword.equals(rePassword)) {
				request.setAttribute("error", "Mật khẩu nhập lại không khớp!");
			} else {
				account.setAccountName(accountName);
				account.setPassword(newPasword);
				bo.updateAccount(account);
				session.invalidate();
				response.sendRedirect("login");
				return;
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/thaydoimatkhau.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
