<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="keywords" content="Visitors Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<!-- bootstrap-css -->
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/bootstrap.min.css" />">
	<!-- //bootstrap-css -->
	<!-- Custom CSS -->
	<link href="<c:url value="/resources/admin/css/style.css" />" rel='stylesheet' type='text/css' />
	<link href="<c:url value="/resources/admin/css/style-responsive.css" />" rel="stylesheet" />
	<!-- font CSS -->
	<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
	<!-- font-awesome icons -->
	<link rel="stylesheet" href="<c:url value="/resources/admin/css/font.css" />" type="text/css" />
	<link href="<c:url value="/resources/admin/css/font-awesome.css" />" rel="stylesheet">
</head>

<body>
	<div class="log-w3">
		<div class="w3layouts-main">
			<h2>TVT FITNESS</h2>
			<form action="login" method="post">
				<input type="text" class="text" name="username"
					placeholder="Enter your username..."> <input
					type="password" class="text" name="password"
					placeholder="Enter your password..."> <span><input
					name="rememberMe" type="checkbox" />Remember Me</span>
					<!--<h6><a href="">Forgot Password?</a></h6>-->
				<div class="clearfix"></div>
				<p style="color: red">${error}</p>
				<input type="submit" value="Sign In" name="submit">
			
			</form>
			<p>Don't Have an Account ?<a href="signup">Create an account</a></p>
		</div>
	</div>
		<!-- //font-awesome icons -->
	<script src="<c:url value="/resources/admin/js/jquery2.0.3.min.js" />"></script>
	<script src="<c:url value="/resources/admin/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/admin/js/jquery.dcjqaccordion.2.7.js" />"></script>
	<script src="<c:url value="/resources/admin/js/scripts.js" />"></script>
	<script src="<c:url value="/resources/admin/js/jquery.slimscroll.js" />"></script>
	<script src="<c:url value="/resources/admin/js/jquery.nicescroll.js" />"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="js/jquery.scrollTo.js"></script>
	<script type="application/x-javascript">
		addEventListener("load", function() {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
</body>

</html>