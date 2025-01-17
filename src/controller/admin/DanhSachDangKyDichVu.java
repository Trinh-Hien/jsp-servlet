package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.RegisterService;
import model.bo.RegisterServiceBO;

/**
 * Servlet implementation class DanhSachDangKyDichVu
 */
@WebServlet("/danh-sach-dang-ky-dich-vu")
public class DanhSachDangKyDichVu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDangKyDichVu() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        if (session.getAttribute("taikhoan") == null) {
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
		RegisterServiceBO registerServiceBO = new RegisterServiceBO();
		List<RegisterService> list = registerServiceBO.getAll();
		request.setAttribute("listRS", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/admin/danh-sach-dang-ky-dich-vu.jsp");
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
