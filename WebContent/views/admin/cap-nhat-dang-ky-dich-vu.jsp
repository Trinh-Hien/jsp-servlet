<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
<%@include file="/common/admin/css-resources.jsp" %>
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
							<header class="panel-heading">Cập Nhật Đăng Ký Dịch Vụ</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="get"
									action="${pageContext.request.contextPath}/cap-nhat-dang-ky-dich-vu">
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã đăng kí dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="id"
												value="${rs.registerServiceId }" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="maDv"
												value="${rs.serviceId }" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã thành viên</label>
										<div class="col-sm-6">
											<input type="text" name="maTv"
											value="${rs.memberId }" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Thời gian đăng
											ký dịch vụ</label>
										<div class="col-sm-6">
											<input type="date" name="thoiGian" value="${rs.timeOfPurchase }" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Chi phí</label>
										<div class="col-sm-6">
											<input type="number" name="chiPhi" min="0"
												value="${rs.amount }" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Trạng thái phí</label>
										<div class="col-lg-6">
											<select id="status" name="status" class="form-control m-bot15">
												<option value="Chưa thanh toán">Chưa thanh toán</option>
												<option value="Đã thanh toán">Đã thanh toán</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" class="btn btn-save" type="submit"
												value="submit">
												<i class="glyphicon glyphicon-plus"></i> Save
											</button>
											<button name="cancel" class="btn btn-cancel" value="cancel"
												type="button">
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

	<%@include file="/common/admin/js-resources.jsp" %>
	<script type="text/javascript">
	$("#status").val("${rs.status}").attr("selected", true);
	$("#dangki").addClass("active");
	  $("#dangkidichvu").addClass("active");
	</script>
</body>

</html>