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
	<form action="${pageContext.request.contextPath}/danh-sach-nhan-vien"
		method="post">
		<section id="container">
			<%@include file="/common/admin/header.jsp"%>
			<%@include file="/common/admin/sidebar.jsp"%>
			<!--main content start-->
			<section id="main-content">
				<section class="wrapper">

					<div class="panel panel-default">
						<div class="panel-heading">Danh Sách Nhân Viên</div>
						<div class="row w3-res-tb">

							<div class="col-sm-3">
								<div class="input-group">
									<input type="text" class="input-sm form-control" id="search"
										id="search" placeholder="Search">
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th>Mã nhân viên</th>
										<th>Tên nhân viên</th>
										<th>SĐT</th>
										<th>Ngày sinh</th>
										<th>Giới tính</th>
										<th>Lương</th>
										<th>Ngày bắt đầu</th>
										<th>Hình ảnh</th>
										<th style="width: 250px;">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="employee">
										<tr>
											<td>${employee.getEmpId()}</td>
											<td>${employee.getEmpName()}</td>
											<td>${employee.getNumberPhone()}</td>
											<td>${employee.getBirthday()}</td>
											<td>${employee.getGender() }</td>
											<td>${employee.getSalary() }</td>
											<td>${employee.getStartDate() }</td>
											<td><img alt="" width="50px" height="50px"
												src="<c:url value="/resources/images/${employee.getIngUrl()}" />"></td>
											<td><a class="btn btn-primary"
												href="cap-nhat-nhan-vien?empId=${employee.getEmpId()}">
													<i class="fa fa-edit"></i> Update
											</a> &nbsp; <a class="btn btn-danger btn_delete"
												href="xoa-nhan-vien?empId=${employee.getEmpId()}"> <i
													class="fa fa-trash" aria-hidden="true"></i> Delete
											</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<footer class="panel-footer">
							<div class="row">
								<div class="col-sm-5 text-center">
									<small class="text-muted inline m-t-sm m-b-sm">showing
										${start+1 } - ${end } of ${rows } items</small>
								</div>
								<div class="col-sm-7 text-right text-center-xs">
									<ul class="pagination pagination-sm m-t-none m-b-none">
										<c:if test="${currentPage != 1}">
											<li class="page-item"><a class="page-link"
												href="danh-sach-nhan-vien?currentPage=${currentPage-1}">Previous</a></li>
										</c:if>

										<c:forEach begin="1" end="${noOfPages}" var="i">
											<c:choose>
												<c:when test="${currentPage eq i}">
													<li class="page-item active"><a class="page-link">
															${i} <span class="sr-only">(current)</span>
													</a></li>
												</c:when>
												<c:otherwise>
													<li class="page-item"><a class="page-link"
														href="danh-sach-nhan-vien?currentPage=${i}">${i}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>

										<c:if test="${currentPage lt noOfPages}">
											<li class="page-item"><a class="page-link"
												href="danh-sach-nhan-vien?currentPage=${currentPage+1}">Next</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</footer>
					</div>

				</section>
			</section>
			<!--main content end-->
		</section>
	</form>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>
<script type="text/javascript">
	$(".btn_delete").on('click', function(event) {
		if (confirm("Are you sure you want to delete?")) {
			return true;
		} else {
			event.preventDefault();
			return false;
		}
	});
	$("#nhanvien").addClass("active");
	$("#danhsachnhanvien").addClass("active");
	$("#search").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$(".table tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
</script>
</html>