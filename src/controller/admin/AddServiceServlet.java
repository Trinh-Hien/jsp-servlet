package controller.admin;

import java.io.File;
//import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Service;
import model.bo.ServiceBO;

@WebServlet(urlPatterns = { "/them-dich-vu" })
@MultipartConfig
public class AddServiceServlet extends HttpServlet {

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
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/them-dich-vu.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		ServiceBO bo= new ServiceBO();
		Service service= new Service();
		String serviceId=req.getParameter("serviceId");
		if(bo.checkPrimary(serviceId)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/them-dich-vu.jsp");
			req.setAttribute("error", "Mã dịch vụ đã tồn tại");
			dispatcher.forward(req, resp);
			return;
		}
		String serviceName= req.getParameter("serviceName");
		String serviceType= req.getParameter("serviceType");
		Part filePart = req.getPart("imageUrl");
		
		if(filePart.getSize()>0) {
			String fileName = getSubmittedFileName(filePart);
			InputStream fileContent = filePart.getInputStream();
			File uploads = new File(getServletContext().getInitParameter("file-upload"));
			File file = new File(uploads, fileName);
			Files.copy(fileContent, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
			service.setImageUrl(getSubmittedFileName(filePart));
		}
		Float price= Float.parseFloat(req.getParameter("price"));
		service.setServiceId(serviceId);
		service.setServiceName(serviceName);
		service.setServiceType(serviceType);
		service.setPrice(price);
		bo.insert(service);
		resp.sendRedirect("danh-sach-dich-vu");
	}
	
	private String getSubmittedFileName(Part part) {
		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

}
