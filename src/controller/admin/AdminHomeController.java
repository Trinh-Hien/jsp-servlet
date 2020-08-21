package controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.ClassBO;
import model.bo.EmployeeBO;
import model.bo.MemberBO;
import model.bo.ServiceBO;

/**
 * @author dat18
 *
 */
@WebServlet(urlPatterns = {"/admin-home"})
public class AdminHomeController extends HttpServlet {

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
        req.setAttribute("numberEmployee", new EmployeeBO().numberOfRecord());
        req.setAttribute("numberMember", new MemberBO().numberOfRecord());
        req.setAttribute("service", new ServiceBO().numberOfRecord());
        req.setAttribute("classes", new ClassBO().numberOfRecord());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/admin-home.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
