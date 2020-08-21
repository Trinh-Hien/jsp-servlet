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
							<header class="panel-heading">Thêm Lớp Tập</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-lop-hoc">
									<div class="form-group">
										<label class="col-sm-12" id="notification" style="text-align: center;color:red;">${error } ${errorDate }</label>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã lớp tập</label>
										<div class="col-sm-6">
											<input type="text" id="classId" name="classId" placeholder="Lxxxxx..." required
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên lớp tập</label>
										<div class="col-sm-6">
											<input type="text" name="className" placeholder="Tên lớp tập"
												class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Gói</label>
										<div class="col-lg-6">
											<select name="packageId" class="form-control m-bot15" required>
												<c:forEach items="${listGoi}" var="goi">
													<option value="${goi.packageId}">${goi.packageName}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3">Mã Nhân viên</label>
										<div class="col-lg-6">
											<select name="empId" class="form-control m-bot15" required>
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
											<input type="time" name ="startTime" id="startTime" >
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
											<input type="number" name="maxMember" min=3 id="maxMember"
												placeholder="Số lượng học viên của lớp tập"
												class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian bắt đầu khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess1" name="dateStart" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Thời gian kết thúc khóa tập</label>
										<div class="col-lg-6">
											<input type="date" id="inputSuccess2" name="dateEnd" required>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="Submit" name="submit" />
											<a href="danh-sach-lop-hoc" class="btn btn-danger"><i
												class="glyphicon glyphicon-remove"></i> Cancel</a>
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
	<script type="text/javascript">
	$("#classId").on("change", function () {
		   var classId = $("#classId").val();
		   var patt = new RegExp("^L[0-9]{5}$");
		   if (!(patt.test(classId))) {
		       $("#notification").text("Mã lớp tập: Có format là Lxxxxx (x: ký tự số)");
		       $("#notification").css("color", "red");
		       $(this).val("");
		       $(this).focus();
		    } else {
		       $("#notification").text("")
		      }
			});
	$("#maxMember").on("change", function () {
        var maxMember = $("#maxMember").val();
        if(!(parseInt(maxMember)>3)){
            $("#notification").text("Số lượng học viên phải lớn hơn 3");
            $("#notification").css("color", "red");
            $(this).val("");
            $(this).focus();
        } else {
            $("#notification").text("")
        }
    });
	$("#lophoc").addClass("active");
	$("#themlophoc").addClass("active");
	</script>

	<%@include file="/common/admin/js-resources.jsp"%>
</body>

</html>