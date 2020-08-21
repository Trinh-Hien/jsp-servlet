package controller.user;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;
import model.bean.Member;
import model.bo.MemberBO;

/**
 * Servlet implementation class UpdateInformationServlet
 */
@WebServlet("/chinhsua")
public class UpdateInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("login");
			return;
		}
		MemberBO memberBO= new MemberBO();
		Account account= (Account) session.getAttribute("taikhoan");
		Member member= memberBO.getMemberByAccountId(account.getAccountId());
		request.setAttribute("member",member);
		if("submit".equals(request.getParameter("submit"))) {
			member.setFullName(request.getParameter("fullname"));
			member.setBirthday(LocalDate.parse(request.getParameter("birthday")));
			member.setGender(request.getParameter("gender"));
			member.setAddress(request.getParameter("address"));
			member.setNumberPhone(request.getParameter("phone"));
			memberBO.update(member);
			response.sendRedirect("thongtintaikhoan");
			return;
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/views/user/capnhatthongtin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
