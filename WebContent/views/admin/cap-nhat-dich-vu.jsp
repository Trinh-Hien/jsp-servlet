<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Admin Panel</title>
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
							<header class="panel-heading">Cập Nhật Dịch Vụ</header>
							<div class="panel-body">
								<form class="form-horizontal bucket-form" method="POST"
									action="cap-nhat-dich-vu">

									<div class="form-group">
										<label class="col-sm-3 control-label">Mã dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="serviceId" value="${service.getServiceId()}" 
											style="color:#FF0000;}" readonly="readonly" class="form-control">
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-sm-3 control-label">Tên dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="serviceName"
												value="${service.getServiceName()}" class="form-control" required>
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
										<label class="col-sm-3 control-label">Phí dịch vụ</label>
										<div class="col-sm-6">
											<input type="text" name="price" value="${service.getPrice()}" class="form-control" required>
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
		<!--main content end-->
	</section>

	<%@include file="/common/admin/js-resources.jsp" %>
	<script type="text/javascript">
	  $("#dichvu").addClass("active");
	  $("#danhsachdv").addClass("active");
	</script>
</body>

</html>