<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<form action="signup" method="post">
			<div class="form-group row">
			<label id="notification" style="text-align: center;color: red;" class="col-sm-12">${errorName} ${errorPassword }</label>
			</div>
			<h5>Thông tin tài khoản:</h5>
			<hr>
			<div class="form-group row">
				<label for="username" class="col-sm-2 col-form-label">Tên
					đăng nhập(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="username" value="${account.getAccountName() }"
						name="username" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="password" class="col-sm-2 col-form-label">Mật khẩu(*):</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password" value="${account.getPassword() }" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="repassword" class="col-sm-2 col-form-label">Nhập lại mật khẩu(*):</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="repassword" name="repassword" value="${repassword }" required>
				</div>
			</div>
			<h5>Thông tin cá nhân</h5>
			<hr>
			<div class="form-group row">
				<label for="fullname" class="col-sm-2 col-form-label">Họ
					tên(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="fullname" value="${member.getFullName() }"
						name="fullname" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="birthday" class="col-sm-2 col-form-label">Ngày
					sinh(*):</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="birthday" value="${member.getBirthday() }"
						name="birthday" required>
				</div>
			</div>
			<div class="form-group row">
				<!-- Category Product Parent -->
				<label class="col-sm-2 col-form-label" for="gender">Giới
					tính(*):</label>
				<div class="col-sm-10">
					<select name="gender" id="gender" class="form-control m-bot15" required>
						<option value="Nữ">Nữ</option>
						<option value="Nam">Nam</option>

					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="address" class="col-sm-2 col-form-label">Địa Chỉ(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address" value="${member.getAddress() }"
						name="address" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="phone" class="col-sm-2 col-form-label">Số điện thoại(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" value="${member.getNumberPhone() }"
						name="phone" required>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
	$("#gender").val("${member.getGender()}").attr("selected", true);
	$("#phone")
	.on(
			"change",
			function() {
				var phone = $("#soDienThoai").val();
				var patt = new RegExp(
						"^(090|091|098|031|035|038)[0-9]{7}$");
				if (!(patt.test(phone))) {
					$("#notification")
							.text(
									"Số điện thoại phải bắt đầu bằng(090,091,098,035,038) và có 10 chữ số");
					$("#notification").css("color", "red");
					$(this).val("");
					$(this).focus();
				} else {
					$("#notification").text("")
				}
			});
	</script>
</body>
</html>