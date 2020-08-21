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
	<form action="${pageContext.request.contextPath}/danh-sach-thanh-vien"
		method="post">
		<section id="container">
			<%@include file="/common/admin/header.jsp"%>
			<%@include file="/common/admin/sidebar.jsp"%>
			<!--main content start-->
			<section id="main-content">
				<section class="wrapper">

					<div class="panel panel-default">
						<div class="panel-heading">Danh Sách Thành Viên</div>
						<div class="row w3-res-tb">
							<div class="col-sm-3">
								<div class="input-group">
									<input type="text" class="input-sm form-control" id="search"
										placeholder="Search"> <span class="input-group-btn">
										<button class="btn btn-sm btn-default" type="submit">Go!</button>
									</span>
								</div>
							</div>
						</div>
						<div class="table-responsive">
							<table class="table table-striped b-t b-light">
								<thead>
									<tr>
										<th>Họ tên</th>
										<th>Ngày sinh</th>
										<th>Địa chỉ</th>
										<th>Giới tính</th>
										<th>SĐT</th>
										<th>Hình ảnh</th>
										<th style="width: 250px;">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="member">
										<tr>
											<td>${member.fullName}</td>
											<td>${member.birthday}</td>
											<td>${member.address}</td>
											<td>${member.gender}</td>
											<td>${member.numberPhone}</td>
											<td><img height="50px" width="50px"
												src="resources/images/${member.imgUrl}"></td>
											<td><a class="btn btn-primary"
												href="cap-nhat-thanh-vien?memberId=${member.memberId}">
													<i class="fa fa-edit"></i> Update
											</a> &nbsp; <a class="btn btn-danger btn_delete"
												href="xoa-thanh-vien?id=${member.accountId}"> <i
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
												href="danh-sach-thanh-vien?currentPage=${currentPage-1}">Previous</a></li>
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
														href="danh-sach-thanh-vien?currentPage=${i}">${i}</a></li>
												</c:otherwise>
											</c:choose>
										</c:forEach>

										<c:if test="${currentPage lt noOfPages}">
											<li class="page-item"><a class="page-link"
												href="danh-sach-thanh-vien?currentPage=${currentPage+1}">Next</a></li>
										</c:if>
									</ul>
								</div>
							</div>
						</footer>
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
	</form>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>
<script>
	$(".btn_delete").on('click', function(event) {
		if (confirm("Are you sure you want to delete?")) {
			return true;
		} else {
			event.preventDefault();
			return false;
		}
	});
	$("#search").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$(".table tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
	$("#thanhvien").addClass("active");
	$("#danhsachthanhvien").addClass("active");
</script>
</html>