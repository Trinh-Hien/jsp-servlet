<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Thêm sản phẩm</title>
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
							<header class="panel-heading">Thêm sản phẩm</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="them-san-pham" enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-sm-12" id="notification"
											style="text-align: center;"></label>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Mã sản phẩm</label>
										<div class="col-sm-6">
											<input type="text" id="productId" name="productId"
												required="required" placeholder="Nhập mã sản phẩm..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Tên sản phẩm</label>
										<div class="col-sm-6">
											<input type="text" name="productName"
												placeholder="Nhập tên sản phẩm..." class="form-control"
												required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-6">
											<input type="text" name="cost" id="cost" placeholder="Giá..."
												class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<!-- Category Product Parent -->
										<label class="col-sm-3 control-label col-lg-3"
											for="inputSuccess">Loại sản phẩm</label>
										<div class="col-sm-6">
											<input type="text" name="productType"
												placeholder="Loại sản phẩm..." class="form-control" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Hình ảnh</label>
										<div class="col-sm-6">
											<input type="file" name="imageUrl" placeholder="Hình ảnh..."
												class="form-control">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày nhập</label>
										<div class="col-sm-6">
											<input type="date" name="importDate"
												placeholder="Nhập ngày nhập..." class="form-control"
												required>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Thời hạn bảo
											hành</label>
										<div class="col-sm-6">
											<input type="date" name="warrantyDate"
												placeholder="Nhập thời gian bảo hành..."
												class="form-control" required>
										</div>
									</div>

									<div class="form-group ">
										<label class="control-label col-lg-3">Số lượng</label>
										<div class="col-lg-6">
											<input type="number" name="quantity" value="1" id="quantity"
												placeholder="Số lượng..." class="form-control" required>
										</div>
									</div>
									<div class="form-group ">
										<label class="control-label col-lg-3">Trạng thái</label>
										<div class="col-lg-6">
											<input type="text" name="status" placeholder="Trạng thái..."
												class="form-control" required>
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<input type="submit" class="btn btn-primary" value="submit" />
											<a href="danh-sach-san-pham" class="btn btn-danger"><i
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
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	if(${error != null}){
		$("#notification").text("${error}");
        $("#notification").css("color", "red");
	}
	$("#productId").on("change", function () {
	   var equipmentId = $("#productId").val();
	   var patt = new RegExp("^SP[0-9]{4}$");
	   if (!(patt.test(equipmentId))) {
	       $("#notification").text("Mã SP: Có format là SPxxxx (x: ký tự số)");
	       $("#notification").css("color", "red");
	       $(this).val("");
	       $(this).focus();
	    } else {
	       $("#notification").text("")
	      }
		});
	$("#cost").on("change", function () {
        var cost = $("#cost").val();
        if(!(parseFloat(cost)>0)){
            $("#notification").text("Giá phải là 1 số lớn hơn 0");
            $("#notification").css("color", "red");
            $(this).val("");
            $(this).focus();
        } else {
            $("#notification").text("")
        }
    });
	$("#quantity").on("change", function () {
        var quantity = $("#quantity").val();
        if(!(parseInt(quantity)>0)){
            $("#notification").text("Số lượng là 1 số lớn hơn 0");
            $("#notification").css("color", "red");
            $(this).val("");
            $(this).focus();
        } else {
            $("#notification").text("")
        }
    });
	$("#sanpham").addClass("active");
	$("#themsanpham").addClass("active");
</script>
</body>

</html>