package model;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenkDangNhap;
	private String matKhau;
	private String hoVaTen;
	private String gioTinh;
	private String diaChi;
	private String diaChiMuaHang;
	private String diaChiNhanHang;
	private Date ngaySinh;
	private String soDienThoai;
	private String email;
	private boolean dangKyNhanBanTinEmail;
	private String maXacThuc;
	private Date thoiGianHieuLucCuaMaXacThuc;
	private boolean trangThaiXacThuc;
	public KhachHang() {

	}

	public KhachHang(String maKhachHang, String tenkDangNhap, String matKhau, String hoVaTen, String gioTinh,
			String diaChi, String diaChiMuaHang, String diaChiNhanHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBanTinEmail, String maXacThuc, Date thoiGianHieuLucCuaMaXacThuc,
			boolean trangThaiXacThuc) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenkDangNhap = tenkDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioTinh = gioTinh;
		this.diaChi = diaChi;
		this.diaChiMuaHang = diaChiMuaHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
		this.maXacThuc = maXacThuc;
		this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

	public KhachHang(String maKhachHang, String tenkDangNhap, String matKhau, String hoVaTen, String gioTinh,
			String diaChi, String diaChiMuaHang, String diaChiNhanHang, Date ngaySinh, String soDienThoai, String email,
			boolean dangKyNhanBanTinEmail) {
		this.maKhachHang = maKhachHang;
		this.tenkDangNhap = tenkDangNhap;
		this.matKhau = matKhau;
		this.hoVaTen = hoVaTen;
		this.gioTinh = gioTinh;
		this.diaChi = diaChi;
		this.diaChiMuaHang = diaChiMuaHang;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenkDangNhap() {
		return tenkDangNhap;
	}

	public void setTenkDangNhap(String tenkDangNhap) {
		this.tenkDangNhap = tenkDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getGioTinh() {
		return gioTinh;
	}

	public void setGioTinh(String gioTinh) {
		this.gioTinh = gioTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getDiaChiMuaHang() {
		return diaChiMuaHang;
	}

	public void setDiaChiMuaHang(String diaChiMuaHang) {
		this.diaChiMuaHang = diaChiMuaHang;
	}

	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}

	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getDangKyNhanBanTinEmail() {
		return dangKyNhanBanTinEmail;
	}

	public void setDangKyNhanBanTinEmail(boolean dangKyNhanBanTinEmail) {
		this.dangKyNhanBanTinEmail = dangKyNhanBanTinEmail;
	}

	public String getMaXacThuc() {
		return maXacThuc;
	}

	public void setMaXacThuc(String maXacThuc) {
		this.maXacThuc = maXacThuc;
	}

	public Date getThoiGianHieuLucCuaMaXacThuc() {
		return thoiGianHieuLucCuaMaXacThuc;
	}

	public void setThoiGianHieuLucCuaMaXacThuc(Date thoiGianHieuLucCuaMaXacThuc) {
		this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
	}

	public boolean isTrangThaiXacThuc() {
		return trangThaiXacThuc;
	}

	public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
		this.trangThaiXacThuc = trangThaiXacThuc;
	}

}
