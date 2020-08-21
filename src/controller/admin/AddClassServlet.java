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

@WebServlet("/them-lop-hoc")
public class AddClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddClassServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		PackageBO packageBO = new PackageBO();
		EmployeeBO employeeBO = new EmployeeBO();
		List<Package> listPackage = packageBO.getAll();
		List<Employee> listEmployee = employeeBO.getEmployees();
		request.setAttribute("listGoi", listPackage);
		request.setAttribute("listEmp", listEmployee);
		request.setCharacterEncoding("UTF-8");

		if ("Submit".equals(request.getParameter("submit"))) {
			ClassBO bo = new ClassBO();
			String classId = request.getParameter("classId");
			String className = request.getParameter("className");
			String packageId = request.getParameter("packageId");
			String empId = request.getParameter("empId");
			LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
			String schedule = String.join(",", request.getParameterValues("schedule"));
			System.out.println(schedule);
			int maxMember = Integer.parseInt(request.getParameter("maxMember"));
			LocalDate dateStart = LocalDate.parse(request.getParameter("dateStart"));// yyyy-mm-dd;
			LocalDate dateEnd = LocalDate.parse(request.getParameter("dateEnd"));
			String status = "Đang mở";
			if (bo.checkPrimaryKey(classId)) {
				request.setAttribute("error", "Mã lớp đã tồn tại mời nhập mã khác");
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/them-lop-hoc.jsp");
				dispatcher.forward(request, response);
				return;
			}

			if (!dateEnd.isAfter(dateStart)) {
				request.setAttribute("errorDate",
						"Thời gian bắt đầu khóa tập không được lớn hơn ngày kết thúc hoặc nhỏ hơn ngày hiện tại");
				RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/them-lop-hoc.jsp");
				dispatcher.forward(request, response);
				return;
			}
			ClassGym classGym = new ClassGym(classId, className, packageId, empId, schedule, maxMember, dateStart,
					dateEnd, status, startTime);
			bo.insert(classGym);
			response.sendRedirect("danh-sach-lop-hoc");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/them-lop-hoc.jsp");
			dispatcher.forward(request, response);

		}

	}

}
