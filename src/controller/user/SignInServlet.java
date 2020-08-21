package controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Validate;
import model.bean.Account;
import model.bean.Member;
import model.bo.AccountBO;
import model.bo.CommonBo;

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/signup")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AccountBO accountBO = new AccountBO();
		String accountName = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String fullname = request.getParameter("fullname");
		String birthDay = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String accountType = "User";
		Account account = new Account(accountName, password, accountType);
		Member member = new Member(fullname, LocalDate.parse(birthDay), gender, phone, address);
		if (!password.equals(repassword)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			request.setAttribute("account", account);
			request.setAttribute("member", member);
			request.setAttribute("errorPassword", "Mật khẩu không khớp");
			dispatcher.forward(request, response);
			return;
		}
		List<String> accountNames = accountBO.getAccountName();
		if (Validate.isExitName(accountName, accountNames)) {
			account.setAccountName(null);
			RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
			request.setAttribute("account", account);
			request.setAttribute("repassword", repassword);
			request.setAttribute("member", member);
			request.setAttribute("errorName", "Tên đăng nhập đã đựơc dùng!");
			dispatcher.forward(request, response);
			return;
		}

		try {
			CommonBo bo= new CommonBo();
			bo.registerAccount(account, member);
			response.sendRedirect("login");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "Hệ thống xảy ra lỗi. Vui lòng đăng kí sau.");
			dispatcher.forward(request, response);
		}
		
	}

}
