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
import model.bean.Member;
import model.bo.MemberBO;
import model.bo.ScheduleBO;

/**
 * Servlet implementation class SchedulePersónervlet
 */
@WebServlet("/lichtrinhcanhan")
public class SchedulePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulePersonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect("login");
			return;
		}
		ScheduleBO bo = new ScheduleBO();
		MemberBO memberBO= new MemberBO();
		Account account= (Account) session.getAttribute("taikhoan");
		Member member = memberBO.getMemberByAccountId(account.getAccountId());
		int id=member.getMemberId();
		RequestDispatcher dispatcher= request.getRequestDispatcher("/views/user/lichtrinhcanhan.jsp");
		request.setAttribute("list", bo.getList(id));
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
