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
import model.bean.RegisterClass;
import model.bo.ClassBO;
import model.bo.MemberBO;
import model.bo.RegisterClassBO;

/**
 * Servlet implementation class RegisterClassServlet
 */
@WebServlet("/dangkilophoc")
public class RegisterClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClassBO classBO= new ClassBO();
		RegisterClassBO registerClassBO= new RegisterClassBO();
		MemberBO memberBO= new MemberBO();
		HttpSession session = request.getSession();
		
        if (session.getAttribute("taikhoan") == null) {
            response.sendRedirect("login");
            return;
        }
        Account account = (Account) session.getAttribute("taikhoan");
    	int memberId = memberBO.getMemberByAccountId(account.getAccountId()).getMemberId();
        if(request.getParameter("id")!= null) {
        	request.setAttribute("lopHoc", classBO.getClassById(request.getParameter("id")));
        }
        if("submit".equals(request.getParameter("submit"))) {
        	String classId= classBO.getClassId(request.getParameter("className"));
        	int maxMember= classBO.getMaxMaember(classId);
        	int numberOfRegisted= registerClassBO.getNumberOfRegisted(classId);
        	if(numberOfRegisted >= maxMember) {
        		request.setAttribute("error", "Lớp đã đủ thành viên");
        	}else if(registerClassBO.checkPrimarykey(memberId, classId)) {
        		request.setAttribute("error", "Bạn đã là thành viên của lớp này.");
        	}else {
        		RegisterClass registerClass= new RegisterClass(memberId, classId, LocalDate.now(), "Chưa thanh toán");
        		registerClassBO.insert(registerClass);
        	}
        }
        List<List<String>> list= registerClassBO.getDetail(memberId);
        request.setAttribute("list", list);
		RequestDispatcher dispatcher= request.getRequestDispatcher("/views/user/dangkilophoc.jsp");
		request.setAttribute("classes", classBO.getClassOpen());
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
