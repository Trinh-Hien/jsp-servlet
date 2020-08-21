<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Thêm Dịch Vụ</title>
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
							<header class="panel-heading">Thêm Dịch Vụ</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="POST" enctype = "multipart/form-data"
									action="them-dich-vu">
									<div class="form-group">
										<label class="col-sm-12" id="notification" style="text-align: center"></label>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="serviceId" id="serviceId"
												placeholder="DVxxxxx" class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="serviceName"
												placeholder="Nhập tên dịch vụ..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại dịch vụ</label>
				                        <div class="col-lg-6">
				                            <select name="serviceType" class="form-control m-bot15">
				                                   <option value="Tập với HLV Nữ">Tập với HLV Nữ</option>
				                                   <option value="Tập luyện chuyên nghiệp">Tập luyện chuyên nghiệp</option>
				                                   <option value="Mua thiết bị">Mua thiết bị</option>
				                                   <option value="Ăn uống">Ăn uống</option>
				                            </select>
				                        </div>
				                    </div>
				                    
				                    <div class="form-group">
				                        <label class="col-sm-3 control-label">Hình</label>
				                        <div class="col-sm-6">
				                            <input type="file" size = "50" name="imageUrl" class="form-control">
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Phí dịch vụ</label>
										<div class="col-sm-6">
											<input type="number" name="price"
												placeholder="Nhập phí dịch vụ..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="Submit" />
											<a href="danh-sach-dich-vu" class="btn btn-danger">Cancel</a>
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

	<%@include file="/common/admin/js-resources.jsp" %>
	<script type="text/javascript">
	if(${error != null}){
		$("#notification").text("${error}");
        $("#notification").css("color", "red");
	}
	$("#serviceId").on("change", function () {
		   var equipmentId = $("#serviceId").val();
		   var patt = new RegExp("^DV[0-9]{5}$");
		   if (!(patt.test(equipmentId))) {
		       $("#notification").text("Mã DV: Có format là DVxxxxx (x: ký tự số)");
		       $("#notification").css("color", "red");
		       $(this).val("");
		       $(this).focus();
		    } else {
		       $("#notification").text("")
		      }
			});
	$("#dichvu").addClass("active");
	$("#themdichvu").addClass("active");
	</script>
</body>

</html>