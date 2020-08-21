<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Danh Sách Gói</title>
<%@include file="/common/admin/css-resources.jsp"%>
</head>

<body>
	<section id="container">
		<%@include file="/common/admin/header.jsp"%>
		<%@include file="/common/admin/sidebar.jsp"%>
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">

				<div class="panel panel-default">
					<div class="panel-heading">Danh Sách Gói</div>
					<div class="row w3-res-tb">
						<div class="col-sm-6">
							<div class="input-group">
								<input type="text" class="input-sm form-control" id="search"
									placeholder="Search" id="search">
							</div>
						</div>
					</div>
					<div class="table-responsive">
						<table class="table table-striped b-t b-light">
							<thead>
								<tr>
									<th>Mã gói</th>
									<th>Tên gói</th>
									<th>Loại gói</th>
									<th>Phí gói</th>
									<th style="width: 250px;">Chức năng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${packageList}" var="packagelist">
									<tr>
										<td>${packagelist.getPackageId()}</td>
										<td>${packagelist.getPackageName()}</td>
										<td>${packagelist.getPackageType()}</td>
										<td>${packagelist.getPrice()}</td>
										<td><a class="btn btn-primary"
											href="cap-nhat-goi?packageId=${packagelist.getPackageId()}">
												<i class="fa fa-edit"></i> Update
										</a> &nbsp; <a class="btn btn-danger"
											onclick="return confirm('Are you sure delete this package?')"
											href="xoa-goi?packageId=${packagelist.getPackageId()}"> <i
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
											href="danh-sach-goi?currentPage=${currentPage-1}">Previous</a></li>
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
													href="danh-sach-goi?currentPage=${i}">${i}</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test="${currentPage lt noOfPages}">
										<li class="page-item"><a class="page-link"
											href="danh-sach-goi?currentPage=${currentPage+1}">Next</a></li>
									</c:if>
								</ul>
							</div>
						</div>
					</footer>
				</div>

			</section>

		</section>
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	$("#search").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $(".table tr").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	  $("#goi").addClass("active");
	  $("#danhsachgoi").addClass("active");
	</script>
</body>

</html>