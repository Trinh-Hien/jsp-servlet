package controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Member;
import model.bo.MemberBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = { "/cap-nhat-thanh-vien" })
public class UpdateMemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        if (session.getAttribute("taikhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		int memberId = Integer.parseInt(req.getParameter("memberId"));
		MemberBO bo= new MemberBO();
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/cap-nhat-thanh-vien.jsp");
		req.setAttribute("member", bo.getMemberByMemberId(memberId));
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		MemberBO bo= new MemberBO();
		int memberId = Integer.parseInt(req.getParameter("memberId"));
		String fullName = (String) req.getParameter("fullName");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String gender = (String) req.getParameter("sex");
		String numberPhone = (String) req.getParameter("numberPhone");
		String address= req.getParameter("address");
		Member member= new Member(fullName, birthday, gender, numberPhone, address);
		member.setMemberId(memberId);
		bo.update(member);
		resp.sendRedirect("danh-sach-thanh-vien");
		
	}
}
