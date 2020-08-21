<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
<link href='<c:url value="/resources/css/owl.carousel.min.css"/>' rel="stylesheet">
<link href='<c:url value="/resources/css/owl.theme.default.min.css"/>' rel="stylesheet">
<style type="text/css">
 .card-img-top{
   width: 100%!important;
   height: 200px!important;
   object-fit: cover;
}
</style>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container mt-5 mb-5" style="margin-top: 50px; margin-bottom: 50px;">
		<h3>PT:</h3>
		<div class="owl-carousel owl-theme">
			<c:forEach items="${employeeList }" var="element">
			<div class="ml-2 mr-2">
			
				<div class="card">
					<img class="card-img-top" alt="" src='<c:url value="/resources/images/${element.getIngUrl()}" />'>
					<div class="card-body">
						<h4 class="card-title">${element.getEmpName() }</h4>
						Gym Trainer
					</div>
				</div>
				
			</div>	
			</c:forEach>
		</div>
	</div>
	<div class="container mt-5 mb-5" style="margin-top: 50px; margin-bottom: 50px;">
		<h3>Gói tập :</h3>
		<div class="owl-carousel owl-theme">
			<c:forEach items="${pakages }" var="element">
			<div class="ml-2 mr-2">
			
				<div class="card bg-success text-white">
					<div class="card-body text-center">
						<h4 class="card-title">${element.getPackageName() }</h4>
						<h6 class="card-subtitle mb-2">${element.getPrice()}vnđ</h6>
					</div>
				</div>
				
			</div>	
			</c:forEach>
		</div>
	</div>
	
	<div class="container mt-5 mb-5" style="margin-top: 50px; margin-bottom: 50px;">
		<h3>Dịch vụ :</h3>
		<div class="owl-carousel owl-theme">
			<c:forEach items="${services }" var="element">
			<div class="ml-2 mr-2">
			
				<div class="card">
					<img class="card-img-top" alt="" src='<c:url value="/resources/images/${element.getImageUrl()}" />'>
					<div class="card-body">
						<h4 class="card-title">${element.getServiceName() }</h4>
						${element.getPrice()} vnđ
						<a href="dangkidichvu?id=${element.getServiceId()}" class="btn btn-primary stretched-link">Đăng kí</a>
					</div>
				</div>
				
			</div>	
			</c:forEach>
		</div>
	</div>
	<div class="container mt-5 mb-5" style="margin-top: 50px; margin-bottom: 50px;">
		<h3>Lớp tập :</h3>
		<div class="owl-carousel owl-theme">
			<c:forEach items="${classes }" var="element">
			<div class="ml-2 mr-2">		
				<div class="card bg-secondary text-white">
					<h5 class="card-title">${element.getClassName() }</h5>
					 <h6 class="card-subtitle mb-2">${element.getEmpId()}</h6>
					<div class="card-body">
						<p>Ngày bắt đầu: ${element.getDateStart() }</p>
						<p>Ngày kết thúc: ${element.getDateEnd() }</p>
						<p>Thứ: ${element.getSchedule() }</p>
						<p>Lúc: ${element.getStartTime() }</p>
						<a href="dangkilophoc?id=${element.getClassId()}" class="btn btn-primary stretched-link">Đăng kí</a>
					</div>
				</div>
				
			</div>	
			</c:forEach>
		</div>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script src='<c:url value="/resources/js/owl.carousel.min.js"/>'></script>
	<script type="text/javascript">
		$("#trangchu").addClass("active");
		$(".owl-carousel").owlCarousel({
			autoplay: true,
			autoplayHoverPause:true,
			items: 4 
		});
	</script>
</body>
</html>