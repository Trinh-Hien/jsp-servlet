<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/common/admin/css-resources.jsp"%>
<style type="text/css">
h3{
color:blue;
}
</style>
</head>

<body>
	<section id="container">
		<%@include file="/common/admin/header.jsp"%>
		<%@include file="/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading">Thêm Nhân Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/them-nhan-vien">
									<div class="form-group row">
										<label id="notification"
											style="text-align: center; color: red;" class="col-sm-12">${errorName}
											${errorPassword } ${error }</label>
									</div>
									<h3>Thông tin tài khoản:</h3>
									<hr>
									<div class="form-group">
										<label for="username" class="col-sm-3 control-label">Tên
											đăng nhập(*):</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="username" value="${account.getAccountName() }"
												name="username" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="col-sm-3 control-label">Mật
											khẩu(*):</label>
										<div class="col-sm-6">
											<input type="password" class="form-control" id="password" value="${account.getPassword() }"
												name="password" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="repassword" class="col-sm-3 control-label">Nhập
											lại mật khẩu(*):</label>
										<div class="col-sm-6">
											<input type="password" class="form-control" id="repassword" value="${repassword }"
												name="repassword" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="accountType" class="col-sm-3 control-label">Loại tài khoản:</label>
										<div class="col-sm-6">
											<select name="accountType" id="accountType" required class="form-control">
												<option value="PT">PT</option>
												<option value="Administrator">Administrator</option>
												<option value="Employee">Employee</option>
											</select>
										</div>
									</div>
									<h3>Thông tin nhân viên:</h3>
									<hr>
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empId" id="empId" value="${employee.getEmpId() }"
												placeholder="Nhập mã nhân viên..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empName"  value="${employee.getEmpName() }"
												placeholder="Nhập họ tên nhân viên..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số điện thoại</label>
										<div class="col-sm-6">
											<input type="text" name="numberPhone" id="soDienThoai"  value="${employee.getNumberPhone() }"
												placeholder="Nhập số điện thoại của nhân viên..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày sinh</label>
										<div class="col-sm-6">
											<input type="date" name="birthday" class="form-control" value="${employee.getBirthday() }" required>
										</div>
									</div>
									<div class="form-group row">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label" for="gender">Giới
											tính(*):</label>
										<div class="col-sm-6">
											<select name="gender" id="gender"
												class="form-control m-bot15" required>
												<option value="Nữ">Nữ</option>
												<option value="Nam">Nam</option>

											</select>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày bắt đầu</label>
										<div class="col-sm-6">
											<input type="date" name="startDate" class="form-control" value="${employee.getStartDate() }" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Lương</label>
										<div class="col-sm-6">
											<input type="number" name="salary" class="form-control" value="${employee.getSalary() }" required>
										</div>
									</div>
									<div class="form-group">
										<!-- Product Image -->
										<label class="col-sm-3 control-label">Hình ảnh</label>
										<div class="col-sm-6">
											<input type="file" name="imgUrl" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="Submit" name="submit" />
											<a href="danh-sach-nhan-vien" class="btn btn-danger"><i
												class="glyphicon glyphicon-remove"></i> Cancel</a>
										</div>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>

			</section>
		</section>
		<!--main content end-->
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	$("#accountType").val("${account.getAccountType()}").attr("selected", true);
	$("#gender").val("${employee.getGender()}").attr("selected", true);
		$("#empId").on(
				"change",
				function() {
					var memberId = $("#empId").val();
					var patt = new RegExp("^NV[0-9]{5}$");
					if (!(patt.test(memberId))) {
						$("#notification").text(
								"Mã NV: Có format là NVxxxxx (x: ký tự số)");
						$("#notification").css("color", "red");
						$(this).val("");
						$(this).focus();
					} else {
						$("#notification").text("")
					}
				});
		$("#soDienThoai")
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
		$("#nhanvien").addClass("active");
		$("#themnhanvien").addClass("active");
	</script>
</body>

</html>