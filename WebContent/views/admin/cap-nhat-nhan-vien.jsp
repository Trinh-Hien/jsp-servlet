<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/common/admin/css-resources.jsp"%>
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
							<header class="panel-heading">Cập Nhật Nhân Viên</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="${pageContext.request.contextPath}/cap-nhat-nhan-vien">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empId" value="${employee.empId}" readonly="readonly"
												placeholder="Nhập mã nhân viên..." class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên nhân viên</label>
										<div class="col-sm-6">
											<input type="text" name="empName" value="${employee.empName}"
												placeholder="Nhập họ tên nhân viên..." class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Số điện thoại</label>
										<div class="col-sm-6">
											<input type="text" name="numberPhone"
												value="${employee.numberPhone}"
												placeholder="Nhập số điện thoại của nhân viên..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày sinh</label>
										<div class="col-sm-6">
											<input type="text" name="birthday"
												value="${employee.birthday}"
												placeholder="Nhập ngày tháng năm sinh của nhân viên..."
												class="form-control" required>
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
											<input type="date" name="startDate" class="form-control" value="${employee.getStartDate()}" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Lương</label>
										<div class="col-sm-6">
											<input type="number" name="salary" class="form-control" value="${employee.getSalary() }" required>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" value="submit" class="btn btn-save" type="submit">
												<i class="glyphicon glyphicon-plus"></i> Update
											</button>
											<button name="cancel_brand_product" class="btn btn-cancel"
												type="button" onclick="history.go(-1);">
												<i class="glyphicon glyphicon-remove"></i> Cancel
											</button>
										</div>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>

			</section>
		</section>
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	$("#gender").val("${employee.getGender()}").attr("selected", true);
	$("#nhanvien").addClass("active");
	$("#danhsachnhanvien").addClass("active");
	</script>
</body>

</html>