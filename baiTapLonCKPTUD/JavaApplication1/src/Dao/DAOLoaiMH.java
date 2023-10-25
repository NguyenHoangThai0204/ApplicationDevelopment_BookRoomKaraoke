package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.LoaiMH;



public class DAOLoaiMH {
	public ArrayList<LoaiMH> getAllLoaiMatHang() {
		ArrayList<LoaiMH> lsLoaiMH = new ArrayList<LoaiMH>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiMatHang";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				String maLoaiMH = rs.getString(1);
				String tenLoaiMH = rs.getString(2);
				LoaiMH loaiMH = new LoaiMH(maLoaiMH, tenLoaiMH);
				lsLoaiMH.add(loaiMH);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lsLoaiMH;
	}

	public LoaiMH getLoaiMHTheoMaLoai(String ma) {
		LoaiMH loaiMH = new LoaiMH();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from LoaiMatHang where maLoaiMH = '"+ma+"'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				loaiMH.setMaLoaiMatHang(rs.getNString(1));
				loaiMH.setTenLoaiMatHang(rs.getNString(2));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loaiMH;
	}


	public String getMaLoaiMHTheoTen(String ten) {
		String maLoai ="";
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select maLoaiMH from LoaiMatHang where tenLoaiMH = N'"+ten +"'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {

				maLoai = rs.getString(1);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return maLoai;

	}




}
