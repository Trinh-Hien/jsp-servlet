<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--sidebar start-->
<aside>
	<div id="sidebar" class="nav-collapse">
		<!-- sidebar menu start-->
		<div class="leftside-navigation">
			<ul class="sidebar-menu" id="nav-accordion">
				<li>
				<a id="homepage"
					href="${pageContext.request.contextPath}/admin-home"> <i
						class="glyphicon glyphicon-dashboard"></i> <span>Dashboard</span>
				</a>
				</li>
				<li>
					<a id="danhsachtaikhoan"
					href="${pageContext.request.contextPath}/danh-sach-tai-khoan"> <i
						class="glyphicon glyphicon-dashboard"></i> <span>Danh Dách Tài Khoản</span>
				</a>
				</li>
				<li class="sub-menu" >
				<a id="sanpham" href="javascript:;"> <i
						class="fa fa-gear fa-spin"></i> <span>Sản phẩm</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-san-pham" id="themsanpham"><i
								class="fa fa-circle-o"></i>Thêm sản phẩm</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-san-pham" id="danhsachsanpham"><i
								class="fa fa-circle-o"></i>Danh Sách sản phẩm</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;" id="thanhvien"> <i
						class="fa fa-users"></i> <span>Thành Viên</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-thanh-vien" id="themthanhvien"><i
								class="fa fa-circle-o"></i>Thêm Thành Viên</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-thanh-vien" id="danhsachthanhvien"><i
								class="fa fa-circle-o"></i>Danh Sách Thành Viên</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Slider --> <a href="javascript:;" id="lophoc"> <i
						class="fa fa-home"></i> <span>Lớp Học</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-lop-hoc" id="themlophoc"><i class="fa fa-circle-o"></i>
								Thêm Lớp Học</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-lop-hoc" id="danhsachlophoc"><i class="fa fa-circle-o"></i>
								Danh Sách Lớp Học</a></li>
					</ul>
				</li>

				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;" id="nhanvien"> <i
						class="fa fa-user"></i> <span>Nhân Viên</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-nhan-vien" id="themnhanvien"><i
								class="fa fa-circle-o"></i>Thêm Nhân Viên</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-nhan-vien"id="danhsachnhanvien"><i
								class="fa fa-circle-o"></i>Danh Sách Nhân Viên</a></li>
					</ul>
				</li>

				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;" id="dichvu"> <i
						class="fa fa-coffee"></i> <span>Dịch Vụ</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-dich-vu" id="themdichvu"><i
								class="fa fa-circle-o"></i>Thêm Dịch Vụ</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-dich-vu" id="danhsachdv"><i
								class="fa fa-circle-o"></i>Danh Sách Dịch Vụ</a></li>
					</ul>
				</li>
				
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;" id="goi"> <i
						class="fa fa-gift"></i> <span>Gói</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-goi" id="themgoi"><i
								class="fa fa-circle-o"></i>Thêm Gói</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-goi" id="danhsachgoi"><i
								class="fa fa-circle-o"></i>Danh Sách Gói</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<!-- Product --> <a href="javascript:;" id="dangki"> <i
						class="fa fa-gift"></i> <span>Danh sách đăng kí</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/danh-sach-dang-ky-lop" id="dangkilop"><i
								class="fa fa-circle-o"></i>Danh Sách Đăng Ký Lớp</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-dang-ky-dich-vu" id="dangkidichvu"><i
								class="fa fa-circle-o"></i>Danh Sách Đăng Kí Dịch Vụ</a></li>
					</ul>
				</li>
				<li class="sub-menu">
					<a href="javascript:;"> <i
						class="fa fa-exchange"></i> <span>Giao Dịch</span>
				</a>
					<ul class="sub">
						<li><a href="${pageContext.request.contextPath}/them-giao-dich"><i
								class="fa fa-circle-o"></i>Thêm Giao Dịch</a></li>
						<li><a href="${pageContext.request.contextPath}/danh-sach-giao-dich"><i
								class="fa fa-circle-o"></i>Danh Sách Giao Dịch</a></li>
					</ul>
				</li>
			</ul>
		</div>
		<!-- sidebar menu end-->
	</div>
</aside>
<!--sidebar end-->