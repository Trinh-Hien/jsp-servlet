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
				<!-- //market-->
				<div class="market-updates">
					<div class="col-md-3 market-update-gd">
						<div class="market-update-block clr-block-2">
							<div class="col-md-4 market-update-right">
								<i class="fa fa-eye"> </i>
							</div>
							<div class="col-md-8 market-update-left">
								<h4>Employee</h4>
								<h3>${numberEmployee}</h3>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="col-md-3 market-update-gd">
						<div class="market-update-block clr-block-1">
							<div class="col-md-4 market-update-right">
								<i class="fa fa-users"></i>
							</div>
							<div class="col-md-8 market-update-left">
								<h4>Users</h4>
								<h3>${numberMember }</h3>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="col-md-3 market-update-gd">
						<div class="market-update-block clr-block-3">
							<div class="col-md-4 market-update-right">
								<i class="fa fa-usd"></i>
							</div>
							<div class="col-md-8 market-update-left">
								<h4>Service</h4>
								<h3>${service }</h3>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="col-md-3 market-update-gd">
						<div class="market-update-block clr-block-4">
							<div class="col-md-4 market-update-right">
								<i class="fa fa-shopping-cart" aria-hidden="true"></i>
							</div>
							<div class="col-md-8 market-update-left">
								<h4>Class</h4>
								<h3>${classes }</h3>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="agil-info-calendar">
					<!-- calendar -->
					<div class="col-md-6 agile-calendar">
						<div class="calendar-widget">
							<div class="panel-heading ui-sortable-handle">
								<span class="panel-icon"> <i class="fa fa-calendar-o"></i>
								</span> <span class="panel-title"> Calendar Widget</span>
							</div>
							<!-- grids -->
							<div class="agile-calendar-grid">
								<div class="page">

									<div class="w3l-calendar-left">
										<div class="calendar-heading"></div>
										<div class="monthly" id="mycalendar"></div>
									</div>

									<div class="clearfix"></div>
								</div>
							</div>
						</div>
					</div>
					<!-- //calendar -->
					</div>
			</section>
		</section>
	</section>

	<%@include file="/common/admin/js-resources.jsp"%>
	<script type="text/javascript">
	$("#homepage").addClass("active");
	</script>
</body>
</html>