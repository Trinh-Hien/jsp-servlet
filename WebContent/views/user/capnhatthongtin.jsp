<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
<c:import url="/common/user/css-bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="/common/user/navbar.jsp"></c:import>
	<div class="container" style="margin-top: 50px; margin-bottom: 50px;">
		<form action="chinhsua" method="post">
			<div class="form-group row">
				<label for="fullname" class="col-sm-2 col-form-label">Họ
					tên(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="fullname" value="${member.getFullName() }"
						name="fullname" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="birthday" class="col-sm-2 col-form-label">Ngày
					sinh(*):</label>
				<div class="col-sm-10">
					<input type="date" class="form-control" id="birthday" value="${member.getBirthday() }"
						name="birthday" required>
				</div>
			</div>
			<div class="form-group row">
				<!-- Category Product Parent -->
				<label class="col-sm-2 col-form-label" for="gender">Giới
					tính(*):</label>
				<div class="col-sm-10">
					<select name="gender" id="gender" class="form-control m-bot15" required>
						<option value="Nữ">Nữ</option>
						<option value="Nam">Name</option>

					</select>
				</div>
			</div>
			<div class="form-group row">
				<label for="address" class="col-sm-2 col-form-label">Địa Chỉ(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="address" value="${member.getAddress() }"
						name="address" required>
				</div>
			</div>
			<div class="form-group row">
				<label for="phone" class="col-sm-2 col-form-label">Số điện thoại(*):</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="phone" value="${member.getNumberPhone() }"
						name="phone" required>
				</div>
			</div>
			<button type="submit" class="btn btn-primary" name="submit" value="submit">Submit</button>	
		</form>
	</div>
	<c:import url="/common/user/footer.jsp"></c:import>
	<script type="text/javascript">
	$("#thongtin").addClass("active");
	</script>
</body>
</html>