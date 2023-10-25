package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Connect.ConnectDB;



public class DAOSinhMaTuDong {
	// tự động phát sinh mã HD
		public String getMaHD() {
			String maHD="";
			try {
				ConnectDB.getinstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select CONCAT('HD', RIGHT(CONCAT('000',ISNULL(right(max(maHD),3),0) + 1),3)) from [dbo].[HoaDon] where maHD like 'HD%'";
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next())
				{
					maHD = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO: handle 
				e.printStackTrace();
			}
			return maHD;
		}

		// tự động phát sinh mã KH
		public String getMaKH() {
			String maKH="";
			try {
				ConnectDB.getinstance();
				Connection con = ConnectDB.getConnection();
				String sql = "select CONCAT('KH', RIGHT(CONCAT('000',ISNULL(right(max(maKhachHang),3),0) + 1),3)) from [dbo].[KhachHang] where maKhachHang like 'KH%'";
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next())
				{
					maKH = rs.getString(1);
				}
			} catch (SQLException e) {
				// TODO: handle 
				e.printStackTrace();
			}
			return maKH;
		}

		// tự động phát sinh mã NV
		public String getMaNV() {
			String maNV="";
			ConnectDB.getinstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('NV', RIGHT(CONCAT('000',ISNULL(right(max(maNhanVien),3),0) + 1),3)) from [dbo].[NhanVien] where maNhanVien like 'NV%'";
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					maNV = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return maNV;
		}

		// tự động phát sinh mã MH
		public String getMaMH() {
			String maMH="";
			ConnectDB.getinstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('MH', RIGHT(CONCAT('000',ISNULL(right(max(maMH),3),0) + 1),3)) from [dbo].[MatHang] where maMH like  'MH%'";
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					maMH = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return maMH;
		}

		// tự động phát sinh mã Phong
		public String getMaP() {
			String maP="";
			ConnectDB.getinstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select CONCAT('P', RIGHT(CONCAT('000',ISNULL(right(max(maPhong),3),0) + 1),3)) from Phong where maPhong like  'P%'";
			try {
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()) {
					maP = rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return maP;
		}
		
		// tự động phát sinh mã DDP
		public String getMaDDP() { 
			String maDDP=""; 
			ConnectDB.getinstance();
			Connection con = ConnectDB.getConnection(); String sql = "select CONCAT('DDP', RIGHT(CONCAT('000',ISNULL(right(max(maDDP),3),0) + 1),3)) from [dbo].[DonDatPhong] where maDDP like 'DDP%'";
			try { 
				Statement stm = con.createStatement(); 
				ResultSet rs = stm.executeQuery(sql); 
				while(rs.next()) {
					maDDP = rs.getString(1);
				}
			}catch (SQLException e) {
				e.printStackTrace(); 
			} 
			return maDDP; 
		}



}
