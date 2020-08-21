<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--header start-->
<div>
 <nav class="navbar navbar-expand-lg navbar-light bg-light" style="font-weight: bold;color: white;">
            <a class="navbar-brand" href="#">
                <img src='<c:url  value="/resources/images/logo.png"/>' >
            </a>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="trangchu" id="trangchu">TRANG CHỦ</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="dangkilophoc" id="lophoc"> ĐĂNG KÍ LỚP TẬP</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="dangkidichvu" id="dichvu"> ĐĂNG KÍ DỊCH VỤ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="lichtrinhcanhan" id="lichtrinh"> LỊCH TRÌNH CÁ NHÂN</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="thongtintaikhoan" id="thongtin"> THÔNG TIN TÀI KHOẢN</a>
                    </li>
                </ul>
                <div class="form-inline my-2 my-lg-0">
                	<label id="title" style="color: black;"></label>
                	<a class="btn btn-outline-success my-2 my-sm-0" href="logout" id="Logout" style="margin-left: 30px;">Logout</a>
                    <a class="btn btn-outline-success my-2 my-sm-0" href="login" id="Login">Login</a>
                    <a class="btn btn-outline-success my-2 my-sm-0" href="signup" id="Signup" style="margin-left: 30px;">Sign up</a>
                    
                </div>
            </div>
        </nav>
        <script type="text/javascript">
        if(${taikhoan eq null}){
        	$("#Logout").css("display","none");
        	$("#title").css("display","none");
        }else{
        	$("#title").text("Xin chào: ${taikhoan.getAccountName()}")
        	$("#Login").css("display","none");
        	$("#Signup").css("display","none");
        }
        </script>
</div>