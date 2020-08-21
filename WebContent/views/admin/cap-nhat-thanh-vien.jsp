<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<header class="panel-heading">Cập Nhật Thành Viên</header>
							<div class="panel-body">
									<form class="form-horizontal bucket-form" method="post"
										action="${pageContext.request.contextPath}/cap-nhat-thanh-vien">

										<div class="form-group">
											<label class="col-sm-3 control-label">Mã thành viên</label>
											<div class="col-sm-6">
												<input type="text" name="memberId" 
													value="${member.memberId}" readonly="readonly"
													placeholder="Nhập mã thành viên..." class="form-control">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">Họ tên</label>
											<div class="col-sm-6">
												<input type="text" name="fullName"
													value="${member.fullName}" required
													placeholder="Nhập họ tên đầy đủ..." class="form-control">
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">Ngày sinh</label>
											<div class="col-sm-6">
												<input type="date" name="birthday"
													value="${member.birthday}" required
													placeholder="Nhập ngày tháng năm sinh..."
													class="form-control">
											</div>
										</div>

										<div class="form-group">
											<!-- Category Product Parent -->
											<label class="col-sm-3 control-label col-lg-3"
												for="inputSuccess">Giới tính</label>
											<div class="col-lg-6">
												<select name="sex" class="form-control m-bot15">
													<option value="Nam">Nam</option>
													<option value="Nu">Nữ</option>
												</select>
											</div>
										</div>

										<div class="form-group">
											<label class="col-sm-3 control-label">Số điện thoại</label>
											<div class="col-sm-6">
												<input type="text" name="numberPhone"
													value="${member.numberPhone}"
													placeholder="Nhập số điện thoại..."
													class="form-control">
													 
											</div>
										</div>
										
										<div class="form-group">
											<label class="col-sm-3 control-label">Địa chỉ</label>
											<div class="col-sm-6">
												<input type="text" name="address" value="${member.address}"
													class="form-control">
													 
											</div>
										</div>
										<div class="form-group">
											<div class="col-lg-offset-3 col-lg-6">
												<button name="submit" class="btn btn-save"
													type="submit" value="submit">
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
		<!--main content end-->
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	$("#thanhvien").addClass("active");
	$("#danhsachthanhvien").addClass("active");
	</script>
</body>

</html>