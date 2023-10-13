package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.DonHang;
import model.KhachHang;


public class DonHangDAO implements DAOInterface<DonHang>{
	@Override
	public ArrayList<DonHang> selectAll() {
		ArrayList<DonHang> list = new ArrayList<DonHang>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from donhang";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("makhachhang");
				String diaChiNguoiMua = rs.getString("diachinguoimua");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				double soTienConThieu = rs.getDouble("sotienconthieu");
				Date ngayDatHang = rs.getDate("ngaydathang");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");
				KhachHang khachHang = (new KhachHangDAO().selectById(new KhachHang(maKhachHang,"", "", "", "", "", "", "", null, "", "", false)));
				DonHang donHang = new DonHang(maDonHang, khachHang, diaChiNguoiMua,diaChiNhanHang, trangThai, hinhThucThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
				list.add(donHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public DonHang selectById(DonHang t) {
		DonHang donHang = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from donhang where madonhang = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaDonHang());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonHang = rs.getString("madonhang");
				String maKhachHang = rs.getString("makhachhang");
				String diaChiNguoiMua = rs.getString("diachinguoimua");
				String diaChiNhanHang = rs.getString("diachinhanhang");
				String trangThai = rs.getString("trangthai");
				String hinhThucThanhToan = rs.getString("hinhthucthanhtoan");
				double soTienConThieu = rs.getDouble("sotienconthieu");
				Date ngayDatHang = rs.getDate("ngaydathang");
				Date ngayGiaoHang = rs.getDate("ngaygiaohang");
				KhachHang khachHang = (new KhachHangDAO().selectById(new KhachHang(maKhachHang,"", "", "", "", "", "", "", null, "", "", false)));
				donHang = new DonHang(maDonHang, khachHang, diaChiNguoiMua,diaChiNhanHang, trangThai, hinhThucThanhToan, soTienConThieu, ngayDatHang, ngayGiaoHang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return donHang;
	}

	@Override
	public int insert(DonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Insert into donhang values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaDonHang());
			ps.setString(2, t.getKhachHang().getMaKhachHang());
			ps.setString(3, t.getDiaChiNguoiMua());
			ps.setString(4, t.getDiaChiNhanHang());
			ps.setString(5, t.getTrangThai());
			ps.setString(6, t.getHinhThucThanhToan());
			ps.setDouble(7, t.getSoTienConThieu());
			ps.setDate(8, t.getNgayDatHang());
			ps.setDate(9, t.getNgayGiaoHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang DonHang : arr) {
			dem+=this.insert(DonHang);
		}
		return dem;
	}

	@Override
	public int delete(DonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from donhang where madonhang = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaDonHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<DonHang> arr) {
		int dem = 0;
		for (DonHang DonHang : arr) {
			dem+=this.delete(DonHang);
		}
		return dem;
	}
	

	@Override
	public int update(DonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update donhang set makhachhang = ?, diachinguoimua = ?, diachinhanhang = ?, trangthai= ?, "
					+ "hinhthucthanhtoan= ?, sotienconthieu= ?, ngaydathang= ?, ngaygiaohang= ?, where madonhang = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getKhachHang().getMaKhachHang());
			ps.setString(2, t.getDiaChiNguoiMua());
			ps.setString(3, t.getDiaChiNhanHang());
			ps.setString(4, t.getTrangThai());
			ps.setString(5, t.getHinhThucThanhToan());
			ps.setDouble(6, t.getSoTienConThieu());
			ps.setDate(7, t.getNgayDatHang());
			ps.setDate(8, t.getNgayGiaoHang());
			ps.setString(9, t.getMaDonHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;

	}
}

