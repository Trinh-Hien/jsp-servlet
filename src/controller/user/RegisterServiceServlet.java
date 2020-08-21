package controller.user;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.RegisterService;
import model.bean.Service;
import model.bo.MemberBO;
import model.bo.RegisterServiceBO;
import model.bo.ServiceBO;

/**
 * Servlet implementation class RegisterServiceServlet
 */
@WebServlet("/dangkidichvu")
public class RegisterServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServiceServlet() {
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
		ServiceBO bo = new ServiceBO();
		RegisterServiceBO registerServiceBO = new RegisterServiceBO();
		MemberBO memberBO = new MemberBO();
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("login");
			return;
		}
		if ("submit".equals(request.getParameter("submit"))) {
			int amount = Integer.parseInt(request.getParameter("amount"));
			String serviceId = bo.getServiceId(request.getParameter("serviceName"));
			Account account = (Account) session.getAttribute("taikhoan");
			int memberId = memberBO.getMemberByAccountId(account.getAccountId()).getMemberId();
			LocalDate time = LocalDate.now();
			String status = "Chưa thanh toán";
			RegisterService registerService = new RegisterService(serviceId, memberId, time, amount, status);
			registerServiceBO.insertRegisterService(registerService);
		}
		String serviceId = request.getParameter("id");
		if (serviceId != null) {
			request.setAttribute("service", bo.searchById(serviceId));
		}
		List<Service> services = bo.getAll();
		System.out.println(services.size());
		request.setAttribute("services", services);
		Account account = (Account) session.getAttribute("taikhoan");
		request.setAttribute("list", registerServiceBO.getRegisterService(account.getAccountId()));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/user/dangkidichvu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
