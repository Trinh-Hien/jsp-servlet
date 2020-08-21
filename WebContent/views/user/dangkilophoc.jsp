<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí lớp</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
<style type="text/css">
caption, h4 {
	caption-side: top;
	font-size: larger;
	font-style: italic;
	font-weight: bold
}
</style>
</head>
<body>
	<c:if test="${error !=null }">
		<script>alert("${error}");
</script>
	</c:if>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<h4>Đăng kí dịch vụ</h4>
		<form action="dangkilophoc" method="post">
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-2 col-form-label">Tên
					Lớp Học</label>
				<div class="col-sm-10">
					<select id="className" name="className" required class="form-control">
						<c:forEach items="${classes}" var="element">
						<option value="${element.getClassName() }">${element.getClassName() }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<button type="submit" value="submit" name="submit" onclick="return confirm('Are you sure class this service?')" class="btn btn-primary">Đăng kí</button>
		</form>
	</div>
	<hr>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<table class="table">
			<caption>Dịch vụ đã đăng kí</caption>
			<thead>
				<tr>
					<th scope="col">Tên Lớp</th>
					<th scope="col">Ngày đăng kí</th>
					<th scope="col">Ngày bắt đầu</th>
					<th scope="col">Số lượng tối đa</th>
					<th scope="col">Phí</th>
					<th scope="col">Trạng thái</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="element">
					<tr>
						<td scope="row">${element.get(0) }</td>
						<td scope="row">${element.get(1) }</td>
						<td scope="row">${element.get(2) }</td>
						<td scope="row">${element.get(3) }</td>
						<td scope="row">${element.get(4) }</td>
						<td scope="row">${element.get(5) }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
		$("#lophoc").addClass("active");
		$("#className").val("${lopHoc.getClassName()}").attr("selected",true);
	</script>
</body>
</html>