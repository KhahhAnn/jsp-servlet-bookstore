<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
					<form style="margin-top: 50px" action="khach-hang-controller?hanhDong=quen-mat-khau" method="post">
						<div class="form-outline mb-4 red"><%=baoLoi%></div>

						<div class="form-outline mb-4">
							<label class="form-label" for="tenDangNhap">Tên đăng nhập</label>
							<input type="text" id="taiKhoan"
								class="form-control form-control-lg" name="taiKhoan" />
						</div>

						<!-- Password input -->
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

</body>
</html>