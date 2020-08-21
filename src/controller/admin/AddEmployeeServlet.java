package controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import common.NameFile;
import common.Validate;
import model.bean.Account;
import model.bean.Employee;
import model.bo.AccountBO;
import model.bo.EmployeeBO;

@WebServlet(urlPatterns = { "/them-nhan-vien" })
@MultipartConfig
public class AddEmployeeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session.getAttribute("taikhoan") == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-nhan-vien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		EmployeeBO bo = new EmployeeBO();
		AccountBO accountBO = new AccountBO();
		String empId = req.getParameter("empId");
		String accountName = req.getParameter("username");
		String password = req.getParameter("password");
		String repassword = req.getParameter("repassword");
		String accountType = req.getParameter("accountType");
		Account account = new Account(accountName, repassword, accountType);

		String empName = req.getParameter("empName");
		String numberPhone = req.getParameter("numberPhone");
		LocalDate birthday = LocalDate.parse(req.getParameter("birthday"));
		String gender = req.getParameter("gender");
		LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
		Float salary = Float.parseFloat(req.getParameter("salary"));
		Employee employee = new Employee(empId, empName, numberPhone, birthday, gender, startDate, salary);
		employee.setAccount(account);
		if (!password.equals(repassword)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-nhan-vien.jsp");
			req.setAttribute("account", account);
			req.setAttribute("employee", employee);
			req.setAttribute("errorPassword", "Mật khẩu không khớp");
			dispatcher.forward(req, resp);
			return;
		}
		if (bo.checkPrimary(empId)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-nhan-vien.jsp");
			employee.setEmpId(null);
			req.setAttribute("error", "Mã nhân viên đã tồn tại");
			req.setAttribute("account", account);
			req.setAttribute("repassword", repassword);
			req.setAttribute("employee", employee);
			dispatcher.forward(req, resp);
			return;
		}
		List<String> accountNames = accountBO.getAccountName();
		if (Validate.isExitName(accountName, accountNames)) {
			account.setAccountName(null);
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/them-nhan-vien.jsp");
			req.setAttribute("account", account);
			req.setAttribute("repassword", repassword);
			req.setAttribute("employee", employee);
			req.setAttribute("errorName", "Tên đăng nhập đã đựơc dùng!");
			dispatcher.forward(req, resp);
			return;
		}
		Part filePart = req.getPart("imgUrl");

		if (filePart.getSize() > 0) {
			String fileName = NameFile.getSubmittedFileName(filePart);
			InputStream fileContent = filePart.getInputStream();
			File uploads = new File(getServletContext().getInitParameter("file-upload"));
			File file = new File(uploads, fileName);
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			employee.setIngUrl(NameFile.getSubmittedFileName(filePart));
		}

		bo.insert(employee);
		resp.sendRedirect("danh-sach-nhan-vien");

	}

}
