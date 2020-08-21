<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>TVT Fitness | Cập Nhật Gói</title>
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
							<header class="panel-heading">Cập Nhật Gói</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="post"
									action="cap-nhat-goi">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageId" value="${package1.getPackageId()}" 
											style="color:#FF0000;}" readonly="readonly" class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên gói</label>
										<div class="col-sm-6">
											<input type="text" name="packageName" value="${package1.getPackageName()}"
												placeholder="Nhập tên gói..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group"><!-- Category Product Parent -->
				                        <label class="col-sm-3 control-label col-lg-3" for="inputSuccess">Loại gói</label>
				                        <div class="col-lg-6">
				                            <select name="packageType" class="form-control m-bot15">
				                                   <option value="Gói tập vô thời hạn">Gói tập vô thời hạn</option>
				                                   <option value="Gói tập 1 tháng">Gói tập 1 tháng</option>
				                                   <option value="Gói bình thường">Gói bình thường</option>
				                            </select>
				                        </div>
				                    </div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Chi phí gói</label>
										<div class="col-sm-6">
											<input type="text" name="price" value="${package1.getPrice()}"
												placeholder="Nhập phí của gói..." class="form-control" required>
										</div>
									</div>
									
									<div class="form-group">
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
	$("#goi").addClass("active");
	  $("#danhsachgoi").addClass("active");
	</script>
</body>

</html>