package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.ChiTietDonHang;
import model.DonHang;
import model.SanPham;


public class ChiTietDonHangDAO implements DAOInterface<ChiTietDonHang>{
	@Override
	public ArrayList<ChiTietDonHang> selectAll() {
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from chitietdonhang";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String maDonHang = rs.getString("madonhang");
				String maSanPham = rs.getString("masanpham");
				int soLuong = rs.getInt("soluong");
				double giaGoc = rs.getDouble("giagoc");
				double giamGia = rs.getDouble("giamgia");
				double giaBan = rs.getDouble("giaban");
				double thueVAT = rs.getDouble("thuevat");
				double tongTien = rs.getDouble("tongtien");
				DonHang donHang = (new DonHangDAO().selectById(new DonHang(maDonHang, null, "", "", "", "", 0, null, null)));
				SanPham sanPham = (new SanPhamDAO().selectById(new SanPham(maSanPham, "", null, 0, 0, 0, 0, 0, null, "", "")));
				ChiTietDonHang ctdh = new ChiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
				list.add(ctdh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ChiTietDonHang selectById(ChiTietDonHang t) {
		ChiTietDonHang ctdh = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from chitietdonhang where machitietdonhang = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaChiTietDonHang());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maChiTietDonHang = rs.getString("machitietdonhang");
				String maDonHang = rs.getString("madonhang");
				String maSanPham = rs.getString("masanpham");
				int soLuong = rs.getInt("soluong");
				double giaGoc = rs.getDouble("giagoc");
				double giamGia = rs.getDouble("giamgia");
				double giaBan = rs.getDouble("giaban");
				double thueVAT = rs.getDouble("thuevat");
				double tongTien = rs.getDouble("tongtien");
				DonHang donHang = (new DonHangDAO().selectById(new DonHang(maDonHang, null, "", "", "", "", 0, null, null)));
				SanPham sanPham = (new SanPhamDAO().selectById(new SanPham(maSanPham, "", null, 0, 0, 0, 0, 0, null, "", "")));
				ctdh = new ChiTietDonHang(maChiTietDonHang, donHang, sanPham, soLuong, giaGoc, giamGia, giaBan, thueVAT, tongTien);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ctdh;
	}

	@Override
	public int insert(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Insert into chitietdonhang values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaChiTietDonHang());
			ps.setString(2, t.getDonHang().getMaDonHang());
			ps.setString(3, t.getSanPham().getMaSanPham());
			ps.setInt(4, t.getSoLuong());
			ps.setDouble(5, t.getGiaGoc());
			ps.setDouble(6, t.getGiamGia());
			ps.setDouble(7, t.getGiaBan());
			ps.setDouble(8, t.getThueVAT());
			ps.setDouble(9, t.getTongTien());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem+=this.insert(ChiTietDonHang);
		}
		return dem;
	}

	@Override
	public int delete(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from chitietdonhang where machitietdonhang";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaChiTietDonHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<ChiTietDonHang> arr) {
		int dem = 0;
		for (ChiTietDonHang ChiTietDonHang : arr) {
			dem+=this.delete(ChiTietDonHang);
		}
		return dem;
	}

	@Override
	public int update(ChiTietDonHang t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update chitietdonhang set madonhang = ?, masanpham = ?, soluong = ?, giagoc= ?, "
					+ "giamgia= ?, giaban= ?, thuevat= ?, tongtien= ?, where machitietdonhang = ?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getDonHang().getMaDonHang());
			ps.setString(2, t.getSanPham().getMaSanPham());
			ps.setInt(3, t.getSoLuong());
			ps.setDouble(4, t.getGiaGoc());
			ps.setDouble(5, t.getGiamGia());
			ps.setDouble(6, t.getGiaBan());
			ps.setDouble(7, t.getThueVAT());
			ps.setDouble(8, t.getTongTien());
			ps.setString(9, t.getMaChiTietDonHang());
			ketQua = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}
