package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.ChiTietHD;
import Entity.HoaDon;
import Entity.MatHang;



public class DAOCTHD {
public boolean themCTHD(ChiTietHD cthd) {
		
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try {
			stmt = con.prepareStatement("insert into CTHD values (?,?,?)");
			stmt.setString(1, cthd.getHoaDon().getMaHoaDon());
			stmt.setString(2, cthd.getMatHang().getMaMatHang());
			stmt.setInt(3, cthd.getSoLuong());
			
			
			n = stmt.executeUpdate();
			} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}
		return n>0;
	}
	
	public	ChiTietHD getCTHDTheoMa(String maHD,String maMH) {
		ChiTietHD cthd = new ChiTietHD();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM  CTHD where maHD = '"+maHD+"' and maMH = '"+maMH+"' order by maMH";
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				
	
				cthd.setHoaDon(new HoaDon(maHD));
				cthd.setMatHang(new MatHang(maMH));
				cthd.setSoLuong(rs.getInt(3));
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cthd;
	
	}
	
	public	ArrayList<ChiTietHD> getCTHDTheoMaHD(String maHD) {
		ArrayList<ChiTietHD> lsCTHD = new ArrayList<ChiTietHD>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM  CTHD where maHD = '"+maHD+"' order by maMH" ;
		
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				ChiTietHD cthd = new ChiTietHD();
	
				cthd.setHoaDon(new HoaDon(rs.getString(1)));
				cthd.setMatHang(new MatHang(rs.getString(2)));
				cthd.setSoLuong(rs.getInt(3));
				
				lsCTHD.add(cthd);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lsCTHD;
	
}

}
