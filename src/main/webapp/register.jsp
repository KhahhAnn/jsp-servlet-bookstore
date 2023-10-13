<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Đăng ký</title>
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
	.red {
		color: red;
	}
</style>
<body>
<% 
	String baoLoi = request.getAttribute("baoLoi")+"";
	baoLoi = (baoLoi.equals("null"))?"":baoLoi;
	String tenDangNhap = request.getAttribute("tenDangNhap")+"";
	tenDangNhap = (tenDangNhap.equals("null"))?"":tenDangNhap;
	String hoVaTen = request.getAttribute("hoVaTen")+"";
	hoVaTen = (hoVaTen.equals("null"))?"":hoVaTen;
	String gioiTinh = request.getAttribute("gioiTinh")+"";
	gioiTinh = (gioiTinh.equals("null"))?"":gioiTinh;

	String ngaySinh = request.getAttribute("ngaySinh")+"";
	ngaySinh = (ngaySinh.equals("null"))?"":ngaySinh;

	String diaChiKhachHang = request.getAttribute("diaChiKhachHang")+"";
	diaChiKhachHang = (diaChiKhachHang.equals("null"))?"":diaChiKhachHang;

	String diaChiMuaHang = request.getAttribute("diaChiMuaHang")+"";
	diaChiMuaHang = (diaChiMuaHang.equals("null"))?"":diaChiMuaHang;

	String diaChiNhanHang = request.getAttribute("diaChiNhanHang")+"";
	diaChiNhanHang = (diaChiNhanHang.equals("null"))?"":diaChiNhanHang;

	String dienThoai = request.getAttribute("dienThoai")+"";
	dienThoai = (dienThoai.equals("null"))?"":dienThoai;

	String email = request.getAttribute("email")+"";
	email = (email.equals("null"))?"":email;

	String dongYNhanMail = request.getAttribute("dongYNhanMail")+"";
	dongYNhanMail = (dongYNhanMail.equals("null"))?"":dongYNhanMail;

	
%>
<div class = "container">
	<h1 style="text-align: center;">Đăng ký tài khoản</h1>
	<div class = "red" id = "baoLoi">
		<%= baoLoi %>
	</div>
	<form action="khach-hang-controller?hanhDong=dang-ky&" class = "form" method="post">
		<div class = "row">
			<div class = "col-md-6">
				<h3>Tài khoản: </h3>
				<div class="mb-3">
					<label for="tenDangNhap" class="form-label">Tên đăng nhập: <span style="color: red">*</span></label> 
					<input type="text" class="form-control" id="tenDangNhap" name = "tenDangNhap" required="required" value = <%= tenDangNhap %>>
				</div>
				<div class="mb-3">
					<label for="matKhau" class="form-label">Mật khẩu: <span style="color: red">*</span></label> 
					<input type="password" class="form-control" id="matKhau" name = "matKhau" required="required" onkeyup="kiemTraMatKhau()">
				</div>
				<div class="mb-3">
					<label for="nhapLaiMatKhau" class="form-label">Nhập lại mật khẩu: <span style="color: red">*</span> <span style="color: red" id = "msg"></span> </label> 
					<input type="password" class="form-control" id="nhapLaiMatKhau" name = "nhapLaiMatKhau" required="required" onkeyup="kiemTraMatKhau()">
				</div>
				<hr>
				<h3>Thông tin cá nhân: </h3>
				<div class="mb-3">
					<label for="hoVaTen" class="form-label">Họ và tên <span style="color: red">*</span></label> 
					<input type="text" class="form-control" id="hoVaTen" name = "hoVaTen" required="required" value = <%= hoVaTen%>>
				</div>
				<div class="mb-3">
					<label for="gioiTinh" class="form-label">Giới tính</label> 
					<select class="form-control" id="gioiTinh" name = "gioiTinh">
						<option></option>
						<option value="Nam" <%=	(gioiTinh == "Nam")?"selected = 'selected'":""%>>Nam</option>
						<option value="Nữ" <%=	(gioiTinh == "Nữ")?"selected = 'selected'":""%>>Nữ</option>
						<option value="Khác" <%= (gioiTinh == "Khác")?"selected = 'selected'":""%>>Khác</option>
					</select>
				</div>
			</div>
			<div class = "col-md-6">
			<h3>Địa chỉ: </h3>
				<div class="mb-3">
					<label for="ngaySinh" class="form-label">Ngày sinh: </label> 
					<input type="date" class="form-control" id="ngaySinh" name = "ngaySinh" value = <%= ngaySinh %>>
				</div>
				<div class="mb-3">
					<label for="diaChiKhachHang" class="form-label">Địa chỉ khách hàng: <span style="color: red">*</span></label> 
					<input type="text" class="form-control" id="diaChiKhachHang" name = "diaChiKhachHang" required="required" value = <%= diaChiKhachHang %>>
				</div>
				<div class="mb-3">
					<label for="diaChiMuaHang" class="form-label">Địa chỉ mua hàng: <span style="color: red">*</span></label> 
					<input type="text" class="form-control" id="diaChiMuaHang" name = "diaChiMuaHang" required="required" value = <%= diaChiMuaHang %>>
				</div>
				<div class="mb-3">
					<label for="diaChiNhanHang" class="form-label">Địa chỉ nhận hàng: <span style="color: red">*</span></label> 
					<input type="text" class="form-control" id="diaChiNhanHang" name = "diaChiNhanHang" required="required" value = <%= diaChiNhanHang %>>
				</div>
				<div class="mb-3">
					<label for="dienThoai" class="form-label">Số điện thoại: <span style="color: red">*</span></label> 
					<input type="tel" class="form-control" id="dienThoai" name = "dienThoai" required="required" value = <%= dienThoai %>>
				</div>
				<div class="mb-3">
					<label for="email" class="form-label">Email: </label> 
					<input type="email" class="form-control" id="email" name = "email" value = <%= email %>>
				</div>
				<div class="mb-3">
					<label for="dongYDieuKhoan" class="form-label">Đồng ý với điều khoản của công ty: <span style="color: red">*</span></label> 
					<input type="checkbox" class="form-check-input" id="dongYDieuKhoan" name = "dongYDieuKhoan" style="margin-top: 6px;" onchange="kiemTraDongY()" >
				</div>
				<div class="mb-3">
					<label for="dongYNhanMail" class="form-label">Đồng ý nhận mail:  <span style="color: red">*</span></label> 
					<input type="checkbox" class="form-check-input" id="dongYNhanMail" name = "dongYNhanMail" style="margin-top: 6px;" value = <%=(dongYNhanMail != null)?"checked = 'checked'":"" %>>
				</div>
				<input type = "submit" value = "Đăng ký" class = "btn btn-primary form-control" name = "submit" id = "submit" style="visibility: hidden;">
			</div>
		</div>
	</form>
</div>
<script>
	function kiemTraMatKhau() {
		matKhau = document.getElementById("matKhau").value;
		matKhauNhapLai = document.getElementById("nhapLaiMatKhau").value;
		if(matKhau != matKhauNhapLai) {
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		} else {
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	function kiemTraDongY() {
		dongYDieuKhoan = document.getElementById("dongYDieuKhoan");
		if(dongYDieuKhoan.checked == true) {			
			document.getElementById("submit").style.visibility = "visible";
		} else {
			document.getElementById("submit").style.visibility = "hidden";
		}
	}
</script>
</body>
</html>