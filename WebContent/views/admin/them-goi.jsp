<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Thêm Gói Tập</title>
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
							<header class="panel-heading">Thêm Gói</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-goi">
									<div class="form-group">
										<label class="col-sm-12" id="notification" style="text-align: center;color: red;"></label>
										
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageId" id="packageId"
												placeholder="GTxxxxx..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageName"
												placeholder="Nhập tên gói..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại gói</label>
				                        <div class="col-lg-6">
				                            <select name="packageType" class="form-control m-bot15">
				                                   <option value="Gói tập vô thời hạn">Gói tập vô thời hạn</option>
				                                   <option value="Gói tập 1 tháng">Gói tập 1 tháng</option>
				                                   <option value="Gói tập bình thường">Gói bình thường</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Chi phí gói</label>
										<div class="col-sm-6">
											<input type="number" name="price"
												placeholder="Nhập phí của gói..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="Submit" />
											 <a href="danh-sach-goi" class="btn btn-danger">Cancel</a>
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
	if(${error != null}){
		$("#notification").text("${error}");
        $("#notification").css("color", "red");
	}
	$("#packageId").on("change", function () {
		   var equipmentId = $("#packageId").val();
		   var patt = new RegExp("^GT[0-9]{5}$");
		   if (!(patt.test(equipmentId))) {
		       $("#notification").text("Mã GT: Có format là GTxxxxx (x: ký tự số)");
		       $("#notification").css("color", "red");
		       $(this).val("");
		       $(this).focus();
		    } else {
		       $("#notification").text("")
		      }
			});
	$("#goi").addClass("active");
	$("#themgoi").addClass("active");
	</script>
</body>

</html>