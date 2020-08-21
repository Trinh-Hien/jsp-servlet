<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi mật khẩu</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		
		<form action="thaydoimatkhau" method="post">
			<div class="form-group row">
			<label id="notification" style="text-align: center;color: red;" class="col-sm-12">${errorName} ${errorPassword }</label>
			</div>
			<h5>Thông tin tài khoản:</h5>
			<hr>
			<div class="form-group row">
				<label for="username" class="col-sm-12" style="color: red;text-align: center;">${error }</label>
			</div>
			<div class="form-group row">
				<label for="username" class="col-sm-2 col-form-label">Tên
					đăng nhập(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username" value="${taikhoan.getAccountName() }"
						name="username" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Mật khẩu hiện tai(*):</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="newpassword" class="col-sm-2 col-form-label">Mật khẩu mới(*):</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="newpassword" name="newpassword" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="repassword" class="col-sm-2 col-form-label">Nhập lại mật khẩu(*):</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="repassword" name="repassword" required>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="submit" value="submit">Lưu thay đổi</button>
			</form>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
	$("#thongtin").addClass("active");
	</script>
</body>
</html>