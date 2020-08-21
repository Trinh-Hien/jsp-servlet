package controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
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
import model.bean.Member;
import model.bo.AccountBO;
import model.bo.CommonBo;

@WebServlet(urlPatterns = { "/them-thanh-vien" })
@MultipartConfig
public class AddMemberServlet extends HttpServlet {

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/them-thanh-vien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		AccountBO accountBO = new AccountBO();
		String accountName = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String fullname = request.getParameter("fullname");
		String birthDay = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String accountType = "User";
		Account account = new Account(accountName, password, accountType);
		Member member = new Member(fullname, LocalDate.parse(birthDay), gender, phone, address);
		if (!password.equals(repassword)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/them-thanh-vien.jsp");
			request.setAttribute("account", account);
			request.setAttribute("member", member);
			request.setAttribute("errorPassword", "Mật khẩu không khớp");
			dispatcher.forward(request, response);
			return;
		}
		List<String> accountNames = accountBO.getAccountName();
		if (Validate.isExitName(accountName, accountNames)) {
			account.setAccountName(null);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/admin/them-thanh-vien.jsp");
			request.setAttribute("account", account);
			request.setAttribute("repassword", repassword);
			request.setAttribute("member", member);
			request.setAttribute("errorName", "Tên đăng nhập đã đựơc dùng!");
			dispatcher.forward(request, response);
			return;
		}
		Part filePart = request.getPart("imgUrl");

		if (filePart.getSize() > 0) {
			String fileName = NameFile.getSubmittedFileName(filePart);
			InputStream fileContent = filePart.getInputStream();
			File uploads = new File(getServletContext().getInitParameter("file-upload"));
			File file = new File(uploads, fileName);
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			member.setImgUrl(NameFile.getSubmittedFileName(filePart));
		}

		try {
			CommonBo bo = new CommonBo();
			bo.registerAccount(account, member);
			response.sendRedirect("danh-sach-thanh-vien");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			request.setAttribute("error", "Hệ thống xảy ra lỗi. Vui lòng đăng kí sau.");
			dispatcher.forward(request, response);
		}

	}
}
