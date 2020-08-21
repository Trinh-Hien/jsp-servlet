<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<table class="table">
			<tr>
				<th>Họ tên  </th>
				<td>${member.getFullName() }</td>
			</tr>
			<tr>
				<th>Ngày sinh  </th>
				<td>${member.getBirthday() }</td>
			</tr>
			<tr>
				<th>Địa chỉ  </th>
				<td>${member.getAddress() }</td>
			</tr>
			<tr>
				<th>Giới tính  </th>
				<td>${member.getGender() }</td>
			</tr>
			<tr>
				<th>Số điện thoại  </th>
				<td>${member.getNumberPhone() }</td>
			</tr>
		</table>
		<a href="thaydoimatkhau" class="btn btn-primary">Thay đổi mật khẩu</a>
		<a href="chinhsua?id=${member.getMemberId() }" class="btn btn-primary">Chỉnh sửa thông tin cá nhân</a>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
	$("#thongtin").addClass("active");
	</script>
</body>
</html>