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

				<div class="panel panel-default">
					<div class="panel-heading">Danh Sách Đăng Ký Dịch Vụ</div>
					<div class="row w3-res-tb">
						
						<div class="col-sm-3">
							<div class="input-group">
								<input type="text" class="input-sm form-control" id="search"
									placeholder="Search"> <span class="input-group-btn">
								</span>
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th>Mã Dịch Vụ</th>
									<th>Mã Thành viên</th>
									<th>Ngày đăng ký dịch vụ</th>
									<th>Số lượng</th>
									<th>Trạng Thái</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listRS}" var="rs">
									<tr>
										<td>${rs.serviceId }</td>
										<td>${rs.memberId }</td>
										<td>${rs.timeOfPurchase }</td>
										<td>${rs.amount }</td>
										<td>${rs.status }</td>
										<td>
										<a class="btn btn-primary"
											href="cap-nhat-dang-ky-dich-vu?id=${rs.registerServiceId}">
												<i class="fa fa-edit"></i> Update
										</a> &nbsp; 
										<a class="btn btn-danger"
											onclick="return confirm('Are you sure delete this service?');"
											href="xoa-dang-ky-dich-vu?id=${rs.registerServiceId}">
												<i class="fa fa-trash" aria-hidden="true"></i> Delete
										</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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

	<%@include file="/common/admin/js-resources.jsp" %>
	<script type="text/javascript">
	$("#search").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $(".table tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	  $("#dangki").addClass("active");
	  $("#dangkidichvu").addClass("active");
	</script>
</body>

</html>