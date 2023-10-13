package database;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TacGia;

public class TacGiaDAO implements DAOInterface<TacGia> {

	@Override
	public ArrayList<TacGia> selectAll() {
		ArrayList<TacGia> list = new ArrayList<TacGia>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from tacgia";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				TacGia tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
				list.add(tacGia);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public TacGia selectById(TacGia t) {
		TacGia tacGia = null;

		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from tacgia where matacgia = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTacGia());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maTacGia = rs.getString("matacgia");
				String hoVaTen = rs.getString("hovaten");
				Date ngaySinh = rs.getDate("ngaysinh");
				String tieuSu = rs.getString("tieusu");
				tacGia = new TacGia(maTacGia, hoVaTen, ngaySinh, tieuSu);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tacGia;
	}

	@Override
	public int insert(TacGia t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Insert into tacgia values (?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTacGia());
			ps.setString(2, t.getHoVaTen());
			ps.setDate(3, t.getNgaySinh());
			ps.setString(4, t.getTieuSu());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.insert(tacGia);
		}
		return dem;
	}

	@Override
	public int delete(TacGia t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from tacgia where matacgia = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTacGia());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TacGia> arr) {
		int dem = 0;
		for (TacGia tacGia : arr) {
			dem += this.delete(tacGia);
		}
		return dem;
	}

	@Override
	public int update(TacGia t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update tacgia set hovaten =  ?, ngaysinh = ?, tieusu= ? where matacgia = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getHoVaTen());
			ps.setDate(2, t.getNgaySinh());
			ps.setString(3, t.getTieuSu());
			ps.setString(4, t.getMaTacGia());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
}
