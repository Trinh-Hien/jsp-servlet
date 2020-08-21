package controller.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ClassGym;
import model.bean.Employee;
import model.bean.Package;
import model.bo.ClassBO;
import model.bo.EmployeeBO;
import model.bo.PackageBO;

/**
 * Servlet implementation class CapNhatLopTap
 */
@WebServlet("/cap-nhat-lop-hoc")
public class UpdateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");

		ClassBO bo = new ClassBO();
		PackageBO packageBO = new PackageBO();
		EmployeeBO employeeBO = new EmployeeBO();

		List<Package> listPackage = null;
		List<Employee> listEmployee = null;
		listPackage = packageBO.getAll();
		listEmployee = employeeBO.getEmployees();
		request.setAttribute("listGoi", listPackage);
		request.setAttribute("listEmp", listEmployee);

		String classId = request.getParameter("classId");
		ClassGym trainingClass = bo.getClassById(classId);
		request.setAttribute("lopTap", trainingClass);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/cap-nhat-lop-hoc.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ClassBO bo = new ClassBO();

		String classId = request.getParameter("classId");
		String className = request.getParameter("className");
		String packageId = request.getParameter("packageId");
		String empId = request.getParameter("empId");
		LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
		String schedule =String.join(",", request.getParameterValues("schedule"));
		System.out.println(schedule);
		int maxMember = Integer.parseInt(request.getParameter("maxMember"));
		LocalDate dateStart = LocalDate.parse(request.getParameter("dateStart"));// yyyy-mm-dd;
		LocalDate dateEnd = LocalDate.parse(request.getParameter("dateEnd"));
		String status = request.getParameter("status");
		ClassGym gym = new ClassGym(classId, className, packageId, empId, schedule, maxMember, dateStart, dateEnd,
				status, startTime);
		bo.update(gym);
		response.sendRedirect(request.getContextPath() + "/danh-sach-lop-hoc");
	}

}
