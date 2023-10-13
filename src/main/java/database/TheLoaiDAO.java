package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.TheLoai;

public class TheLoaiDAO implements DAOInterface<TheLoai>{
	@Override
	public ArrayList<TheLoai> selectAll() {
		ArrayList<TheLoai> list = new ArrayList<TheLoai>();
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from theloai";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				TheLoai theLoai = new TheLoai(maTheLoai, tenTheLoai);
				list.add(theLoai);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public TheLoai selectById(TheLoai t) {
		TheLoai theLoai = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Select * from theloai where matheloai = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTheLoai());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maTheLoai = rs.getString("matheloai");
				String tenTheLoai = rs.getString("tentheloai");
				theLoai = new TheLoai(maTheLoai, tenTheLoai);
			}
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return theLoai;
	}

	@Override
	public int insert(TheLoai t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Insert into theloai values(?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTheLoai());
			ps.setString(2, t.getTenTheLoai());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai TheLoai : arr) {
			dem+=this.insert(TheLoai);
		}
		return dem;
	}

	@Override
	public int delete(TheLoai t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Delete from theloai where matheloai = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, t.getMaTheLoai());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public int deleteAll(ArrayList<TheLoai> arr) {
		int dem = 0;
		for (TheLoai TheLoai : arr) {
			dem+=this.delete(TheLoai);
		}
		return dem;
	}

	@Override
	public int update(TheLoai t) {
		int ketQua = 0;
		try {
			Connection conn = JDBCUtil.getConnection();
			String query = "Update theloai set tentheloai = ? where matheloai = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,t.getTenTheLoai());
			ps.setString(2, t.getMaTheLoai());
			ketQua = ps.executeUpdate();
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}
}