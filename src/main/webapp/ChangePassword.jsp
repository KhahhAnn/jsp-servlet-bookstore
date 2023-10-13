<%@page import="model.KhachHang"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đổi mật khẩu</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
</head>
<style>
.divider:after, .divider:before {
	content: "";
	flex: 1;
	height: 1px;
	background: #eee;
}

.h-custom {
	height: calc(100% - 73px);
}

.red {
	color: red;
}

@media ( max-width : 450px) {
	.h-custom {
		height: 100%;
	}
}
</style>
<body>

	<%
		Object obj = session.getAttribute("khachHang");
		KhachHang kh = null;
		if(obj != null) {
			kh = (KhachHang) obj;
		}
		if(kh == null) {
	%>	
	<h1>Vui lòng đăng nhập hệ thống <a href="index.jsp" style="color: blue; text-decoration: underline;">Trang chủ</a></h1>
	<% 
		} else { 
			String baoLoi = request.getAttribute("baoLoi") + "";
			baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;
	%>

	<section class="vh-100">
		<div class="container-fluid h-custom">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-md-9 col-lg-6 col-xl-5">
					<img
						src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.webp"
						class="img-fluid" alt="Sample image">
				</div>
				<div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
					<form style="margin-top: 50px" action="khach-hang-controller?hanhDong=doi-mat-khau&" method="post">
						<div class="form-outline mb-4 red"><%=baoLoi%></div>

						<!-- Password input -->
						<div class="form-outline mb-3">
							<label class="form-label" for="form3Example4">Mật khẩu
								hiện tại</label> <input type="password" id="matKhau" name="matKhau"
								class="form-control form-control-lg" />
						</div>
						<div class="form-outline mb-3">
							<label class="form-label" for="form3Example4">Mật khẩu
								mới</label> <input type="password" id="matKhauMoi" name="matKhauMoi"
								class="form-control form-control-lg" />
						</div>
						<div class="form-outline mb-3">
							<label class="form-label" for="form3Example4">Mật khẩu
								nhập lại</label> <input type="password" id="matKhauNhapLai"
								name="matKhauNhapLai" class="form-control form-control-lg" />
						</div>
						<input type="submit" value="Đổi mật khẩu"
							class="btn btn-primary form-control" name="submit" id="submit"
							style="padding-left: 2.5rem; padding-right: 2.5rem;">
						</p>
				</div>

				</form>
			</div>
		</div>
		</div>

	</section>
	<% } %>
</body>
</html>