package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.SanPham;
import model.TacGia;
import model.TheLoai;


public class SanPhamDAO implements DAOInterface<SanPham>{
	@Override
	public ArrayList<SanPham> selectAll() {
		ArrayList<SanPham> list = new ArrayList<SanPham>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from sanpham";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String moTa = rs.getString("mota");
				
				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
				SanPham sanPham = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai, ngonNgu, moTa);
				list.add(sanPham);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public SanPham selectById(SanPham t) {
		SanPham sanPham = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from sanpham where masanpham = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaSanPham());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maSanPham = rs.getString("masanpham");
				String tenSanPham = rs.getString("tensanpham");
				String maTacGia = rs.getString("matacgia");
				int namXuatBan = rs.getInt("namxuatban");
				double giaNhap = rs.getDouble("gianhap");
				double giaGoc = rs.getDouble("giagoc");
				double giaBan = rs.getDouble("giaban");
				int soLuong = rs.getInt("soluong");
				String maTheLoai = rs.getString("matheloai");
				String ngonNgu = rs.getString("ngonngu");
				String moTa = rs.getString("mota");
				
				TacGia tacGia = (new TacGiaDAO().selectById(new TacGia(maTacGia, "", null, "")));
				TheLoai theLoai = (new TheLoaiDAO().selectById(new TheLoai(maTheLoai, "")));
				sanPham = new SanPham(maSanPham, tenSanPham, tacGia, namXuatBan, giaNhap, giaGoc, giaBan, soLuong, theLoai, ngonNgu, moTa);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPham;
	}

	@Override
	public int insert(SanPham t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Insert into sanpham values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaSanPham());
			ps.setString(2, t.getTenSanPham());
			ps.setString(3, t.getTacGia().getMaTacGia());
			ps.setInt(4, t.getNamXuatBan());
			ps.setDouble(5, t.getGiaNhap());
			ps.setDouble(6, t.getGiaGoc());
			ps.setDouble(7, t.getGiaBan());
			ps.setInt(8, t.getSoLuong());
			ps.setString(9, t.getTheLoai().getMaTheLoai());
			ps.setString(10, t.getNgonNgu());
			ps.setString(11, t.getMaSanPham());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham SanPham : arr) {
			dem+=this.insert(SanPham);
		}
		return dem;
	}

	@Override
	public int delete(SanPham t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from sanpham where masanpham = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaSanPham());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<SanPham> arr) {
		int dem = 0;
		for (SanPham SanPham : arr) {
			dem+=this.delete(SanPham);
		}
		return dem;
	}

	@Override
	public int update(SanPham t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update sanpham set tensanpham = ?, matacgia = ?, namxuatban = ?, gianhap = ?,"
					+ "giagoc = ?, giaban = ?, soluong = ?, matheloai = ?, ngonngu = ?, mota = ? where masanpham = ? ";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getTenSanPham());
			ps.setString(2, t.getTacGia().getMaTacGia());
			ps.setInt(3, t.getNamXuatBan());
			ps.setDouble(4, t.getGiaNhap());
			ps.setDouble(5, t.getGiaGoc());
			ps.setDouble(6, t.getGiaBan());
			ps.setInt(7, t.getSoLuong());
			ps.setString(9, t.getTheLoai().getMaTheLoai());
			ps.setString(9, t.getNgonNgu());
			ps.setString(10, t.getMaSanPham());
			ps.setString(11, t.getMaSanPham());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}
