//package Dao;
//
//import java.io.Serializable;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import Connect.ConnectDB;
//import Entity.LoaiPhong;
//import Entity.Phong;
//
//
//
//public class DAOPhong implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//
//	public boolean themPhong(Phong p) {
//
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n=0;
//		try { 
//			stmt = con.prepareStatement("insert into Phong values (?,?,?,?,?,?)");
//			stmt.setString(1, p.getMaPhong());
//			stmt.setString(2, p.getLoaiPhong().getMaLoaiPhong());
//			stmt.setString(3, p.getTinhTrangPhong());
//			stmt.setDouble(4, p.getGiaPhong());
//			stmt.setInt(5, p.getSucChua());
//			stmt.setString(6, p.getMoTa());
//
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//
//		}
//		return n>0;
//	}
//	public boolean huyP(String ma) throws SQLException {
//		//Phong p = new Phong();
//
//		Connection con= ConnectDB.getConnection();
//		String sql = "update Phong set maLoaiPhong = N'LP004' where maPhong = '"+ma+"'";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//
//			return ps.executeUpdate() > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//
//	public boolean suaThongTinPhong(Phong p) {
//
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n=0;
//		try { 
//			stmt = con.prepareStatement("update Phong set maLoaiPhong=?, tinhTrangPhong = ?, giaPhong=? where maPhong=?");
//
//			stmt.setString(1, p.getLoaiPhong().getMaLoaiPhong());
//			stmt.setString(2, p.getTinhTrangPhong());
//			stmt.setDouble(3, p.getGiaPhong());
//			stmt.setString(4, p.getMaPhong());
//			stmt.setInt(5,p.getSucChua());
//			stmt.setString(6,p.getMoTa());
//
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//
//		}
//		return n>0;
//	}
//
//	/**
//	 * 
//	 * @param maPhong
//	 * @param trangThaiPhong
//	 * @return cập nhập mã phòng và trạng thái phòng
//	 */
//
//	public boolean capnhatTrangThaiPhong(String maPhong, String trangThaiPhong) {
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		PreparedStatement stmt = null;
//		int n=0;
//		try {
//			stmt = con.prepareStatement("update [dbo].[Phong] set tinhTrangPhong = ? where maPhong =? ");
//
//			stmt.setString(1, trangThaiPhong);
//			stmt.setString(2, maPhong);
//
//			n = stmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//			} catch (SQLException e2) {
//				// TODO: handle exception
//				e2.printStackTrace();
//			}
//
//		}
//		return n>0;
//	}
//
//
//
//
//	/**
//	 * 
//	 * @return danh sách các phòng có tình trạng là đang hoạt động
//	 */
//	public ArrayList<Phong> getPhongTrongVaDaDat(){
//		ArrayList<Phong> lstP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps1 = con.prepareStatement("select * from Phong where tinhTrangPhong != N'Đang hoạt động' and maLoaiPhong != 'LP004'");
//			ResultSet rs1 = ps1.executeQuery();
//			while(rs1.next()) {
//				Phong p=new Phong();
//				p.setMaPhong(rs1.getString(1));
//				p.setLoaiPhong(new LoaiPhong(rs1.getString(2)));
//				p.setTinhTrangPhong(rs1.getString(3));
//				p.setGiaPhong(rs1.getDouble(4));
//				p.setSucChua(rs1.getInt(5));
//				p.setMoTa(rs1.getNString(6));
//				lstP.add(p);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstP;
//	}
//
//	
//
//	/**
//	 * 
//	 * @param ma phòng
//	 * @return thông tin phòng theo mã phòng được nhập
//	 */
//	public Phong getPhongTheoMa(String ma) {
//
//		Phong p = new Phong();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql ="  select * from Phong where maPhong = '"+ma+"'";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getString(6));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return p;
//	}
//
//
//
//	/**
//	 * 
//	 * @return danh sách phòng đang hoạt động và trạng thái đơn đặt hàng là đã xác nhận
//	 */
//	public ArrayList<Phong> getPhongDangHoatDong(Date ngayDen) {
//		//fix
//		//and DonDatPhong.ngayDen ='date'
//
//		ArrayList< Phong> lsPhong = new ArrayList<Phong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT Phong.*\r\n"
//				+ "FROM  DonDatPhong INNER JOIN\r\n"
//				+ "         Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
//				+ "WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and DonDatPhong.ngayDen ='"+ngayDen+"'";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsPhong.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return lsPhong;
//	}
//
//	/**
//	 * 
//	 * @return lấy tất cả danh sách phòng trừ phòng ko còn hoạt động
//	 */
//	public ArrayList<Phong> getDanhSachPhong() {
//
//
//		ArrayList< Phong> lsPhong = new ArrayList<Phong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select * from Phong where not maLoaiPhong = N'LP004' ";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getString(6));
//
//				lsPhong.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return lsPhong;
//	}
//
//	/**
//	 * 
//	 * @param ma phòng
//	 * @return thông tin phòng theo mã và đang hoạt động, đã được xác nhận đã đặt
//	 */
//	public Phong getPhongDangHoatDongTheoMaP(String ma) {
//
//
//		Phong p = null;
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql ="  SELECT Phong.*\r\n"
//				+ "	FROM  DonDatPhong INNER JOIN\r\n"
//				+ "				 Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
//				+ "	WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and Phong.maPhong = N'"+ma+"'";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				p = new Phong();
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return p;
//	}
//
//	/**
//	 * 
//	 * @param ma phòn
//	 * @return danh sách phòng theo mã và đang hoạt động và đã được xác nhận
//	 */
//	public ArrayList<Phong> getPhongDangHoatDongTheoMaLoai(String ma) {
//
//
//		ArrayList< Phong> lsPhong = new ArrayList<Phong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT Phong.*\r\n"
//				+ "FROM  DonDatPhong INNER JOIN\r\n"
//				+ "         Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
//				+ "WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and maLoaiPhong = '"+ma+"'";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsPhong.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return lsPhong;
//	}
//
//
//
//
//	/**
//	 * 
//	 * @param mã phòng
//	 * @return thông tin phòng theo mã
//	 */
//	public Phong getGiaPhongTheoMa(String ma) {
//
//		Phong p = new Phong();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql ="  select * from Phong where maPhong = '"+ma+"'";
//
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return p;
//	}
//
//
//
//	/**
//	 * 
//	 * @param mã loại phòng
//	 * @return lấy danh sách các phòng theo mã loại phòng
//	 */
//	public ArrayList<Phong> getPhongTheoLoai(String maLoaiP) {
//		ArrayList<Phong> lsP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from Phong where maLoaiPhong = N'"+maLoaiP+"' ");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsP.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsP;
//	}
//
//	/**
//	 * 
//	 * @param kiểu sắp xếp
//	 * @return danh sách phòng đã được sắp xếp theo loại
//	 */
//	public ArrayList<Phong> sortTheoGiaPhong(String kieuSort) {
//		ArrayList<Phong> lsP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from Phong where not maLoaiPhong = N'LP004' order by giaPhong  "+ kieuSort+" ");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsP.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsP;
//	}
//
//	public ArrayList<Phong> sortTheoMaPhong() {
//		ArrayList<Phong> lsP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from Phong where not maLoaiPhong = N'LP004' order by maPhong desc");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsP.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsP;
//	}
//
//	/**
//	 * 
//	 * @param mã phòng
//	 * @return lấy thông tin phòng theo mã
//	 */
//	public Phong getThongTinPhong(String info) { 
//		Phong p = new Phong();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sqlMa = "select * from Phong where maPhong = '"+info+"'";
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sqlMa);
//			while(rs.next()) {
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return p;
//	}
//
//	/**
//	 * 
//	 * @param tình trạng phòng
//	 * @return danh sách các phòng theo tình trạng
//	 */
//	public ArrayList<Phong> getPhongTheoTinhTrang(String tinhTrang) {
//		ArrayList<Phong> lsP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from Phong where tinhTrangPhong = N'"+tinhTrang+"' ");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsP.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsP;
//	}
//
//	/**
//	 * 
//	 * @param mã phòng
//	 * @return danh sách phòng theo mã
//	 */
//	public ArrayList<Phong> getPhongTheoMaP(String ma) {
//		ArrayList<Phong> lsP=new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from Phong where maPhong = N'"+ma+"' ");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				Phong p = new Phong();
//
//				p.setMaPhong(rs.getNString(1));
//				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
//				p.setTinhTrangPhong(rs.getNString(3));
//				p.setGiaPhong(rs.getDouble(4));
//				p.setSucChua(rs.getInt(5));
//				p.setMoTa(rs.getNString(6));
//
//				lsP.add(p);
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsP;
//	}
//
//
//}
package Dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.LoaiPhong;
import Entity.Phong;

public class DAOPhong implements Serializable {
	private static final long serialVersionUID = 1L;
	DAOLoaiPhong daoLoaiPhong = new DAOLoaiPhong();
	Connection con ;
	public DAOPhong() {
		ConnectDB.getinstance();
		con = ConnectDB.getConnection();
	}
	public boolean themPhong(Phong p) {

		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into Phong values (?,?,?,?,?,?)");
			stmt.setString(1, p.getMaPhong());
			stmt.setString(2, p.getLoaiPhong().getMaLoaiPhong());
			stmt.setString(3, p.getTinhTrangPhong());
			stmt.setDouble(4, p.getGiaPhong());
			stmt.setInt(5, p.getSucChua());
			stmt.setString(6, p.getMoTa());

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
		return n > 0;
	}

	public boolean huyP(String ma) throws SQLException {
		// Phong p = new Phong();
		String sql = "update Phong set maLoaiPhong = N'LP004' where maPhong = '" + ma + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}

	public boolean suaThongTinPhong(Phong p) {
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con
					.prepareStatement("update Phong set maLoaiPhong=?, tinhTrangPhong = ?, giaPhong=? where maPhong=?");

			stmt.setString(1, p.getLoaiPhong().getMaLoaiPhong());
			stmt.setString(2, p.getTinhTrangPhong());
			stmt.setDouble(3, p.getGiaPhong());
			stmt.setString(4, p.getMaPhong());
			stmt.setInt(5, p.getSucChua());
			stmt.setString(6, p.getMoTa());

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
		return n > 0;
	}

	/**
	 * 
	 * @param maPhong
	 * @param trangThaiPhong
	 * @return cập nhập mã phòng và trạng thái phòng
	 */

	public boolean capnhatTrangThaiPhong(String maPhong, String trangThaiPhong) {
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update [dbo].[Phong] set tinhTrangPhong = ? where maPhong =? ");

			stmt.setString(1, trangThaiPhong);
			stmt.setString(2, maPhong);

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
		return n > 0;
	}

	/**
	 * 
	 * @return danh sách các phòng có tình trạng là đang hoạt động
	 */
	public ArrayList<Phong> getPhongTrongVaDaDat() {
		ArrayList<Phong> lstP = new ArrayList<>();
		try {
			PreparedStatement ps1 = con.prepareStatement(
					"select * from Phong where tinhTrangPhong != N'Đang hoạt động' and maLoaiPhong != 'LP004'");
			ResultSet rs1 = ps1.executeQuery();
			while (rs1.next()) {
				Phong p = new Phong();
				p.setMaPhong(rs1.getString(1));
				p.setLoaiPhong(new LoaiPhong(rs1.getString(2)));
				p.setTinhTrangPhong(rs1.getString(3));
				p.setGiaPhong(rs1.getDouble(4));
				p.setSucChua(rs1.getInt(5));
				p.setMoTa(rs1.getNString(6));
				lstP.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstP;
	}

	/**
	 * 
	 * @param ma phòng
	 * @return thông tin phòng theo mã phòng được nhập
	 */
	public Phong getPhongTheoMa(String ma) {

		Phong p = new Phong();
		String sql = "  select * from Phong where maPhong = '" + ma + "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getString(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * 
	 * @return danh sách phòng đang hoạt động và trạng thái đơn đặt hàng là đã xác
	 *         nhận
	 */
	public ArrayList<Phong> getPhongDangHoatDong(Date ngayDen) {
		// fix
		// and DonDatPhong.ngayDen ='date'

		ArrayList<Phong> lsPhong = new ArrayList<Phong>();
		String sql = "SELECT Phong.*\r\n" + "FROM  DonDatPhong INNER JOIN\r\n"
				+ "         Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
				+ "WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and DonDatPhong.ngayDen ='"
				+ ngayDen + "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsPhong.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lsPhong;
	}

	/**
	 * 
	 * @return lấy tất cả danh sách phòng trừ phòng ko còn hoạt động
	 */
	public ArrayList<Phong> getDanhSachPhong() {

		ArrayList<Phong> lsPhong = new ArrayList<Phong>();
		String sql = "select * from Phong where not maLoaiPhong = N'LP004' ";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getString(6));

				lsPhong.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lsPhong;
	}

	/**
	 * 
	 * @param ma phòng
	 * @return thông tin phòng theo mã và đang hoạt động, đã được xác nhận đã đặt
	 */
	public Phong getPhongDangHoatDongTheoMaP(String ma) {

		Phong p = null;
		String sql = "  SELECT Phong.*\r\n" + "	FROM  DonDatPhong INNER JOIN\r\n"
				+ "				 Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
				+ "	WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and Phong.maPhong = N'"
				+ ma + "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				p = new Phong();
				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * 
	 * @param ma phòn
	 * @return danh sách phòng theo mã và đang hoạt động và đã được xác nhận
	 */
	public ArrayList<Phong> getPhongDangHoatDongTheoMaLoai(String ma) {

		ArrayList<Phong> lsPhong = new ArrayList<Phong>();
		String sql = "SELECT Phong.*\r\n" + "FROM  DonDatPhong INNER JOIN\r\n"
				+ "         Phong ON DonDatPhong.maPhong = Phong.maPhong\r\n"
				+ "WHERE tinhTrangPhong = N'Đang hoạt động' and TrangThaiDDP = N'Đã xác nhận' and maLoaiPhong = '" + ma
				+ "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsPhong.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lsPhong;
	}

	/**
	 * 
	 * @param mã phòng
	 * @return thông tin phòng theo mã
	 */
	public Phong getGiaPhongTheoMa(String ma) {

		Phong p = new Phong();;
		String sql = "  select * from Phong where maPhong = '" + ma + "'";

		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	/**
	 * 
	 * @param mã loại phòng
	 * @return lấy danh sách các phòng theo mã loại phòng
	 */
	public ArrayList<Phong> getPhongTheoLoai(String maLoaiP) {
		ArrayList<Phong> lsP = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Phong where maLoaiPhong = N'" + maLoaiP + "' ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsP.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsP;
	}

	public ArrayList<Phong> getPhongThuongTrong() {
		ConnectDB.getinstance();
		con = ConnectDB.getConnection();
		ArrayList<Phong> dsThuong = new ArrayList<Phong>();
		String sql = " select* " 
					+ " from Phong " 
					+"  where tinhtrangphong = N'Trống' and maLoaiPhong = 'LP001'  ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dsThuong.add(new Phong(rs.getString("maPhong")// String maPhong
						, rs.getString("tinhTrangPhong")// String tinhTrangPhong
					, rs.getDouble("giaPhong")// double giaPhong
					, daoLoaiPhong.getLoaiPhongTheoMa(rs.getString("maLoaiPhong"))// LoaiPhong loaiPhong
					, rs.getInt("sucChua")// int sucChua
					, rs.getString("moTa")//String moTa

				));
//				Phong p = new Phong();
//				p.setMaPhong(rs.getString("maPhong"));
//				p.setLoaiPhong(daoLoaiPhong.getLoaiPhongTheoMa(rs.getString("maLoaiPhong")));
//				p.setGiaPhong(rs.getDouble("giaPhong"));
//				p.setMoTa(rs.getString("moTa"));
//				p.setTinhTrangPhong(rs.getString("tinhTrangPhong"));
//				p.setSucChua(rs.getInt("sucChua"));
			}
			return dsThuong;
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<Phong> getPhongVIPTrong() {
		ConnectDB.getinstance();
		con = ConnectDB.getConnection();
		ArrayList<Phong> dsVIP = new ArrayList<Phong>();
		String sql = " select* " + " from Phong " + " where tinhtrangphong = N'Trống' and maLoaiPhong = N'LP003' ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				dsVIP.add(new Phong(rs.getString("maPhong")// String maPhong
						, rs.getString("tinhTrangPhong")// String tinhTrangPhong
					, rs.getDouble("giaPhong")// double giaPhong
					, daoLoaiPhong.getLoaiPhongTheoMa(rs.getString("maLoaiPhong"))// LoaiPhong loaiPhong
					, rs.getInt("sucChua")// int sucChua
					, rs.getString("moTa")//String moTa

				));
//				Phong p = new Phong();
//				p.setMaPhong(rs.getString("maPhong"));
//				p.setLoaiPhong(daoLoaiPhong.getLoaiPhongTheoMa(rs.getString("maLoaiPhong")));
//				p.setGiaPhong(rs.getDouble("giaPhong"));
//				p.setMoTa(rs.getString("moTa"));
//				p.setTinhTrangPhong(rs.getString("tinhTrangPhong"));
//				p.setSucChua(rs.getInt("sucChua"));
			}
			return dsVIP;
		 }catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param kiểu sắp xếp
	 * @return danh sách phòng đã được sắp xếp theo loại
	 */
	public ArrayList<Phong> sortTheoGiaPhong(String kieuSort) {
		ArrayList<Phong> lsP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(
					"select * from Phong where not maLoaiPhong = N'LP004' order by giaPhong  " + kieuSort + " ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsP.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsP;
	}

	public ArrayList<Phong> sortTheoMaPhong() {
		ArrayList<Phong> lsP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from Phong where not maLoaiPhong = N'LP004' order by maPhong desc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsP.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsP;
	}

	/**
	 * 
	 * @param mã phòng
	 * @return lấy thông tin phòng theo mã
	 */
	public Phong getThongTinPhong(String info) {
		Phong p = new Phong();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sqlMa = "select * from Phong where maPhong = '" + info + "'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sqlMa);
			while (rs.next()) {
				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * 
	 * @param tình trạng phòng
	 * @return danh sách các phòng theo tình trạng
	 */
	public ArrayList<Phong> getPhongTheoTinhTrang(String tinhTrang) {
		ArrayList<Phong> lsP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from Phong where tinhTrangPhong = N'" + tinhTrang + "' ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsP.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsP;
	}

	/**
	 * 
	 * @param mã phòng
	 * @return danh sách phòng theo mã
	 */
	public ArrayList<Phong> getPhongTheoMaP(String ma) {
		ArrayList<Phong> lsP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Phong where maPhong = N'" + ma + "' ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Phong p = new Phong();

				p.setMaPhong(rs.getNString(1));
				p.setLoaiPhong(new LoaiPhong(rs.getNString(2)));
				p.setTinhTrangPhong(rs.getNString(3));
				p.setGiaPhong(rs.getDouble(4));
				p.setSucChua(rs.getInt(5));
				p.setMoTa(rs.getNString(6));

				lsP.add(p);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsP;
	}

}

