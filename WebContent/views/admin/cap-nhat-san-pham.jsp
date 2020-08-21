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
							<header class="panel-heading">Cập Nhật Sản Phẩm</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-san-pham">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã sản phẩm</label>
										<div class="col-sm-6">
											<input type="text" name="productId" value="${product.getProductId() }"
												placeholder="Nhập mã sản phẩm..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên sản phẩm</label>
										<div class="col-sm-6">
											<input type="text" name="productName" value="${product.getProductName() }"
												placeholder="Nhập tên sản phẩm..." class="form-control" required>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label">Giá</label>
										<div class="col-sm-6">
											<input type="text" name="cost" value="${product.getCost () }"
												placeholder="Nhập giá..." class="form-control">
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại sản phẩm</label>
				                        <div class="col-lg-6">
				                            <input type="text" name="productType" value="${product.getProductType() }"
												placeholder="Loại sản phẩm..." class="form-control" required>
				                        </div>
				                    </div>

									<div class="form-group">
										<label class="col-sm-3 control-label">Ngày nhập</label>
										<div class="col-sm-6">
											<input type="date" name="importDate" value="${product.getImportDate() }"
												placeholder="Nhập ngày nhập ..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Thời hạn bảo hành</label>
										<div class="col-sm-6">
											<input type="date" name="warrantyDate"  value="${product.getWarrantyDate() }"
												placeholder="Thời gian bảo hành..." class="form-control" required>
										</div>
									</div>	
									<div class="form-group ">
										<label class="control-label col-lg-3">Số lượng</label>
										<div class="col-lg-6">
											<input type="number" name="quantity" value=${product.getQuantity() }
												placeholder="Số lượng..." class="form-control" required>
										</div>
									</div>
									<div class="form-group ">
										<label class="control-label col-lg-3">Trạng thái</label>
										<div class="col-lg-6">
											<input type="text" name="status" value="${product.getStatus() }"
												placeholder="Trạng thái..." class="form-control" required>
										</div>
									</div>			
									<div class="form-group">
										<div class="col-lg-offset-3 col-lg-6">
											<button name="add_brand_product" class="btn btn-save"
												type="submit">
												<i class="glyphicon glyphicon-edit"></i> Update
											</button>
											<button name="cancel_brand_product" class="btn btn-cancel"
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
	$("#sanpham").addClass("active");
	$("#danhsachsanpham").addClass("active");
	</script>
</body>

</html>