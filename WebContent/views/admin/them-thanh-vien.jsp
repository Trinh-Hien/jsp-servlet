<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel| Thêm tành viên</title>
<%@include file="/common/admin/css-resources.jsp"%>
<style type="text/css">
h3{color:blue; }
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
							<header class="panel-heading">Thêm Thành Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post" enctype="multipart/form-data"
									action="${pageContext.request.contextPath}/them-thanh-vien">

									<div class="form-group row">
										<label id="notification"
											style="text-align: center; color: red;" class="col-sm-12">${errorName}
											${errorPassword }</label>
									</div>
									<h3>Thông tin tài khoản:</h3>
									<hr>
									<div class="form-group row">
										<label for="username" class="col-sm-3 control-label">Tên
											đăng nhập(*):</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="username"
												value="${account.getAccountName() }" name="username"
												required>
										</div>
									</div>
									<div class="form-group row">
										<label for="password" class="col-sm-3 control-label">Mật
											khẩu(*):</label>
										<div class="col-sm-6">
											<input type="password" class="form-control" id="password"
												name="password" value="${account.getPassword() }" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="repassword" class="col-sm-3 control-label">Nhập
											lại mật khẩu(*):</label>
										<div class="col-sm-6">
											<input type="password" class="form-control" id="repassword"
												name="repassword" value="${repassword }" required>
										</div>
									</div>
									<h3>Thông tin cá nhân</h3>
									<hr>
									<div class="form-group row">
										<label for="fullname" class="col-sm-3 control-label">Họ
											tên(*):</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fullname"
												value="${member.getFullName() }" name="fullname" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="birthday" class="col-sm-3 control-label">Ngày
											sinh(*):</label>
										<div class="col-sm-6">
											<input type="date" class="form-control" id="birthday"
												value="${member.getBirthday() }" name="birthday" required>
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
									<div class="form-group row">
										<label for="address" class="col-sm-3 control-label">Địa
											Chỉ(*):</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="address"
												value="${member.getAddress() }" name="address" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="phone" class="col-sm-3 control-label">Số
											điện thoại(*):</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="phone"
												value="${member.getNumberPhone() }" name="phone" required>
										</div>
									</div>
									<div class="form-group row">
										<label for="imgUrl" class="col-sm-3 control-label">Hình ảnh:</label>
										<div class="col-sm-6">
											<input type="file" class="form-control" id="imgUrl" name="imgUrl">
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="submit" name="submit" />
											<a href="danh-sach-thanh-vien" class="btn btn-danger"><i
												class="glyphicon glyphicon-remove"></i> Cancel</a>
										</div>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>

			</section>
			<!-- footer -->
			<!--<div class="footer">
                <div class="wthree-copyright">
                    <p>© 2017 Visitors. All rights reserved | Design by <a href="http://w3layouts.com">W3layouts</a></p>
                </div>
            </div>-->
			<!-- / footer -->
		</section>
		<!--main content end-->
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
		$("#memberId").on(
				"change",
				function() {
					var memberId = $("#memberId").val();
					var patt = new RegExp("^TV[0-9]{5}$");
					if (!(patt.test(memberId))) {
						$("#notification").text(
								"Mã TV: Có format là TBxxxxx (x: ký tự số)");
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
		$("#thanhvien").addClass("active");
		$("#themthanhvien").addClass("active");
	</script>
</body>

</html>