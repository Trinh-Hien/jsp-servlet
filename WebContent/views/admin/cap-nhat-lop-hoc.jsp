<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
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
							<header class="panel-heading">Cập Nhật Lớp Học</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-lop-hoc">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="classId" value="${lopTap.classId}"
												readonly="readonly" class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="className"
												value="${lopTap.className}" class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Gói</label>
										<div class="col-lg-6">
											<select name="packageId" class="form-control m-bot15" required>
												<c:forEach items="${listGoi}" var="goi">
													<option value="${goi.packageId}" <c:if test="${goi.packageId == lopTap.packageId}">selected="selected"</c:if> >${goi.packageName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Mã Nhân viên</label>
										<div class="col-lg-6">
											<select name="empId" id="empId" class="form-control m-bot15" required>
												<c:forEach items="${listEmp}" var="emp">
													<option value="${emp.empId}">${emp.empName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="startTime">Thời gian Biểu</label>
										<div class="col-lg-6">
											<input type="time" name ="startTime" id="startTime" value="${lopTap.startTime}" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label col-lg-3"></label>
										<div class="col-lg-6">
											<input type="checkbox" id="vehicle1" name="schedule" value="2"> 
											<label for="vehicle1">Thứ 2</label> 
											<input type="checkbox" id="vehicle2" name="schedule" value="3"> 
											<label for="vehicle2">Thứ 3</label> 
											<input type="checkbox" id="vehicle3" name="schedule" value="4">
											<label for="vehicle3">Thứ 4</label> 
											<input type="checkbox" id="vehicle4" name="schedule" value="5"> 
											<label for="vehicle4">Thứ 5</label> 
											<input type="checkbox" id="vehicle5" name="schedule" value="6"> 
											<label for="vehicle5">Thứ 6</label> 
											<input type="checkbox" id="vehicle6" name="schedule" value="7"> 
											<label for="vehicle6">Thứ 7</label> 
											<input type="checkbox" id="vehicle7" name="schedule" value="8"> 
											<label for="vehicle7">Chủ nhật</label>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Số lượng học
											viên</label>
										<div class="col-sm-6">
											<input type="number" name="maxMember" min=3
												value="${lopTap.maxMember}" class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian bắt đầu khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess1" name="dateStart"
												value="${lopTap.dateStart}" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian kết thúc khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess2" name="dateEnd" required
												value="${lopTap.dateEnd}">
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Trạng thái</label>
										<div class="col-lg-6">
											<select name="status" id="status" class="form-control m-bot15">
												<option value="Đang mở">Đang mở</option>
												<option value="Đã hủy">Đã hủy</option>
												<option value="Đang diễn ra">Đang diễn ra</option>
												<option value="Đã kết thúc">Đã kết thúc</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="submit" value="submit" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-plus"></i> Update
											</button>
											<button name="cancel" value="cancel" class="btn btn-cancel"
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
	$("#empId").val("${lopTap.empId}").attr("selected",true);
	$("#status").val("${lopTap.status}").attr("selected",true);
	  $("#danhsachlophoc").addClass("active");
	  $("#lophoc").addClass("active");
	</script>
</body>

</html>