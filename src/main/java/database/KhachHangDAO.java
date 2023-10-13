package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.KhachHang;



public class KhachHangDAO implements DAOInterface<KhachHang>{
		@Override
		public ArrayList<KhachHang> selectAll() {
			ArrayList<KhachHang> list = new ArrayList<KhachHang>();
			try {
				Connection conn = JDBCUtil.getConnection();
				String query = "Select * from khachhang";
				PreparedStatement ps = conn.prepareStatement(query);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String hoVaTen = rs.getString("tenkhachhang");
				String tenkDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String gioTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkinhanbbantinemail");
				KhachHang khachHang = new KhachHang(maKhachHang, tenkDangNhap, matKhau, hoVaTen, gioTinh, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail);
				list.add(khachHang);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		KhachHang khachHang = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from khachhang where makhachhang = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaKhachHang());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String hoVaTen = rs.getString("tenkhachhang");
				String tenkDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String gioTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkinhanbbantinemail");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLucCuaMaXacThuc = rs.getDate("thoigianhieuluccuamaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				khachHang = new KhachHang(maKhachHang, tenkDangNhap, matKhau, hoVaTen, gioTinh, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail, maXacThuc, thoiGianHieuLucCuaMaXacThuc, trangThaiXacThuc);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachHang;
	}
//	public KhachHang dangNhap(KhachHang t) {
//		KhachHang khachHang = null;
//		try {
//			String query = "Select * from khachhang where tendangnhap = ? and matkhau = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, t.getMaKhachHang());
//			ps.setString(2, t.getMatKhau());
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				String maKhachHang = rs.getString("makhachhang");
//				String hoVaTen = rs.getString("tenkhachhang");
//				String tenkDangNhap = rs.getString("tendangnhap");
//				String matKhau = rs.getString("matkhau");
//				String gioTinh = rs.getString("gioitinh");
//				String diaChi = rs.getString("diachi");
//				String diaChiMuaHang = rs.getString("diachimuahang");
//				String diaChiNhanHang = rs.getString("diachinhanhang");
//				Date ngaySinh = rs.getDate("ngaysinh");
//				String soDienThoai = rs.getString("sodienthoai");
//				String email = rs.getString("email");
//				boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkinhanbbantinemail");
//				khachHang = new KhachHang(maKhachHang, tenkDangNhap, matKhau, hoVaTen, gioTinh, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail);
//			}
//			JDBCUtil.closeConnection(conn);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return khachHang;
//	}
	public KhachHang dangNhap(KhachHang t) {
		KhachHang khach = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from khachhang where tendangnhap = ? and matkhau = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getTenkDangNhap());
			ps.setString(2, t.getMatKhau());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang = rs.getString("makhachhang");
				String hoVaTen = rs.getString("tenkhachhang");
				String tenkDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String gioTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				String diaChiMuaHang = rs.getString("diachimuahang");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				boolean dangKyNhanBanTinEmail = rs.getBoolean("dangkinhanbbantinemail");
				khach = new KhachHang(maKhachHang, tenkDangNhap, matKhau, hoVaTen, gioTinh, diaChi, diaChiMuaHang, diaChiNhanHang, ngaySinh, soDienThoai, email, dangKyNhanBanTinEmail);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khach;
	}
	@Override
	public int insert(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "INSERT INTO khachhang (makhachhang, tendangnhap, matkhau, tenkhachhang, gioitinh, diachi, diachimuahang, diachinhanhang, ngaysinh, sodienthoai, email, dangkinhanbbantinemail) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaKhachHang());
			ps.setString(2, t.getTenkDangNhap());
			ps.setString(3, t.getMatKhau());
			ps.setString(4, t.getHoVaTen());
			ps.setString(5, t.getGioTinh());
			ps.setString(6, t.getDiaChi());
			ps.setString(7, t.getDiaChiMuaHang());
			ps.setString(8, t.getDiaChiNhanHang());
			ps.setDate(9, t.getNgaySinh());
			ps.setString(10, t.getSoDienThoai());
			ps.setString(11, t.getEmail());
			ps.setBoolean(12, t.getDangKyNhanBanTinEmail());

			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem+=this.insert(KhachHang);
		}
		return dem;
	}

	@Override
	public int delete(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from khachhang where makhachhang  = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaKhachHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<KhachHang> arr) {
		int dem = 0;
		for (KhachHang KhachHang : arr) {
			dem+=this.delete(KhachHang);
		}
		return dem;
	}

	@Override
	public int update(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE khachhang " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hoten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", diachinhanhang=?" + ", diachimuahang=?" + ", ngaysinh=?" + ", sodienthoai=?"
					+ ", email=?" + ", dangkinhanbangtin=?" + " WHERE makhachhang=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getTenkDangNhap());
			ps.setString(2, t.getMatKhau());
			ps.setString(3, t.getHoVaTen());
			ps.setString(4, t.getGioTinh());
			ps.setString(5, t.getDiaChi());
			ps.setString(6, t.getDiaChiNhanHang());
			ps.setString(7, t.getDiaChiMuaHang());
			ps.setDate(8, t.getNgaySinh());
			ps.setString(9, t.getSoDienThoai());
			ps.setString(10, t.getEmail());
			ps.setBoolean(11, t.getDangKyNhanBanTinEmail());
			ps.setString(12, t.getMaKhachHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public int updateVerifyInfomation(KhachHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "UPDATE khachhang SET  maxacthuc=?, thoigianhieuluccuamaxacthuc=?, trangthaixacthuc=? WHERE makhachhang=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaXacThuc());
			ps.setDate(2, t.getThoiGianHieuLucCuaMaXacThuc());
			ps.setBoolean(3, t.isTrangThaiXacThuc());
			ps.setString(4, t.getMaKhachHang());
			ketQua = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	
	public int doiMatKhau(KhachHang t) {
		int ketQua = 0;
		
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update khachhang set matkhau = ? where tendangnhap = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMatKhau());
			ps.setString(2, t.getTenkDangNhap());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	public boolean kiemTraTonTai(String tenDangNhap) {
		boolean ketQua = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from khachhang where tendangnhap = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, tenDangNhap);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ketQua = true;
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
	public boolean kiemTraTonTaiDoiMatKhau(KhachHang kh) {
		boolean ketQua = false;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from khachhang where tendangnhap = ? and matkhau = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, kh.getTenkDangNhap());
			ps.setString(2, kh.getMatKhau());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ketQua = true;
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}

