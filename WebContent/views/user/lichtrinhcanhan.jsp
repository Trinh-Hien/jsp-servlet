<%@page import="model.bean.Schedule"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="common.Validate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lịch trình</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<table class=table>
			<tr>
				<th></th>
				<th scope="col">Thứ 2</th>
				<th scope="col">Thứ 3</th>
				<th scope="col">Thứ 4</th>
				<th scope="col">Thứ 5</th>
				<th scope="col">Thứ 6</th>
				<th scope="col">Thứ 7</th>
				<th scope="col">Chủ Nhật</th>
			</tr>
			<%
				List<Schedule> list = (List<Schedule>) request.getAttribute("list");
				if (!list.isEmpty()) {
					for (Schedule schedule : list) {
			%>
			<tr>
				<th><%=schedule.getStartTime()%></th>
				<%
					for (int i = 2; i <= 8; i++) {
								if (Validate.checkExit(i, schedule.getDay())) {
				%>
				<td scope="row"><%=schedule.getNameClass()%></td>
				<%
					} else {
				%>

				<td scope="row"></td>
				<%
					}
							}
				%>

			</tr>
			<%
				}
				}
			%>
		</table>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
		$("#lichtrinh").addClass("active");
	</script>
</body>
</html>