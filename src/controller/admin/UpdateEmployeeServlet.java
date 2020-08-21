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

import model.bean.Employee;
import model.bo.EmployeeBO;

@WebServlet(urlPatterns = "/cap-nhat-nhan-vien")
public class UpdateEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
        if (session.getAttribute("taikhoan") == null) {
            resp.sendRedirect(req.getContextPath()+"/login");
            return;
        }
		String empId = req.getParameter("empId");
		EmployeeBO bo= new EmployeeBO(); 
		req.setAttribute("employee", bo.getEmployee(empId));
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/cap-nhat-nhan-vien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String empId = req.getParameter("empId");
		String empName = req.getParameter("empName");
		String numberPhone = req.getParameter("numberPhone");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
		String gender = req.getParameter("gender");
		LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
		Float salary = Float.parseFloat(req.getParameter("salary"));
		Employee employee= new Employee(empId, empName, numberPhone, birthday, gender, startDate, salary);
		EmployeeBO bo = new EmployeeBO();
		bo.update(employee);
		resp.sendRedirect("danh-sach-nhan-vien");
	}
}
