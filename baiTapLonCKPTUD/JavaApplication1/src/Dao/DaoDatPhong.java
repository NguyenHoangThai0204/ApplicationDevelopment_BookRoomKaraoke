////package Dao;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////import java.sql.Statement;
////import java.util.ArrayList;
////
////import Connect.ConnectDB;
////import Entity.DonDatPhong;
////import Entity.KhachHang;
////import Entity.NhanVien;
////import Entity.Phong;
////
////
////
////public class DaoDatPhong {
////	
////	
////	public boolean themDDP(DonDatPhong ddp) throws SQLException {
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		try {
////			PreparedStatement ps = con.prepareStatement("insert into DonDatPhong values (?,?,?,?,?,?,?,?)");
////			ps.setString(1, ddp.getMaDDP());
////			ps.setString(2, ddp.getPhong().getMaPhong());
////			ps.setString(3, ddp.getKhachHang().getMaKhangHang());
////			ps.setString(4, ddp.getNhanVien().getMaNhanVien());
////			ps.setDate(5, ddp.getNgayLap());
////			ps.setTime(6, ddp.getGioDen());
////			ps.setDate(7, ddp.getNgayDen());
////			ps.setString(8, ddp.getTrangThaiDDP());
////
////			return ps.executeUpdate() > 0;
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		con.close();
////		return false;
////	}
////	
////	public boolean capNhatDDP(DonDatPhong ddp, String ma) throws SQLException {
////		Connection con = ConnectDB.getConnection();
////		String sql = "update DonDatPhong set ngayLap = ?, gioDen = ?, ngayDen = ?, TrangThaiDDP = ? where maDDP like '"+ma+"'";
////		try {
////			PreparedStatement ps = con.prepareStatement(sql);
////			ps.setDate(1, ddp.getNgayLap());
////			ps.setTime(2, ddp.getGioDen());
////			ps.setDate(3, ddp.getNgayDen());
////			ps.setString(4, ddp.getTrangThaiDDP());
////			return ps.executeUpdate() > 0;
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		con.close();
////		return false;
////	}
////	public boolean capNhatTrangThaiDDP(String ma) throws SQLException {
////		Connection con = ConnectDB.getConnection();
////		String sql = "update DonDatPhong set TrangThaiDDP = N'Đã trả phòng' where maDDP = '"+ma+"'";
////		try {
////			PreparedStatement ps = con.prepareStatement(sql);
////			
////			return ps.executeUpdate() > 0;
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		con.close();
////		return false;
////	}
////	public ArrayList<DonDatPhong> getAllDanhSachDDP() {
////		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		try {
////			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong");
////			ResultSet rs = ps.executeQuery();
////			while(rs.next()) {
////				DonDatPhong ddp = new DonDatPhong();
////				ddp.setMaDDP(rs.getString(1));
////				ddp.setKhachHang(new KhachHang(rs.getString(2)));
////				ddp.setPhong(new Phong(rs.getString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getString(8));
////				lsDDP.add(ddp);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return lsDDP;
////	}
////
////
////
////
////	
////	
////	public ArrayList<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() {
////		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		String sql = "select * from DonDatPhong where TrangThaiDDP != N'Hủy' and TrangThaiDDP != N'Đã trả phòng'";
////		try {
////			Statement stm = con.createStatement();
////			ResultSet rs = stm.executeQuery(sql);
////			while(rs.next()) {
////				DonDatPhong ddp = new DonDatPhong();
////				ddp.setMaDDP(rs.getString(1));
////				ddp.setPhong(new Phong(rs.getString(2)));
////				ddp.setKhachHang(new KhachHang(rs.getString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getString(8));
////				lsDDP.add(ddp);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return lsDDP;
////	}
////
////	public DonDatPhong getDDPTheoMaPhong(String ma){
////		DonDatPhong ddp = new DonDatPhong();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		String sql = "SELECT DonDatPhong.*\r\n"
////				+ "FROM  DonDatPhong\r\n"
////				+ "where maPhong = N'"+ma+"' and TrangThaiDDP = N'Đã xác nhận'"
////				+ "";
////		try {
////			Statement stm = con.createStatement();
////			ResultSet rs = stm.executeQuery(sql);
////			while(rs.next()) {
////
////				ddp.setMaDDP(rs.getNString(1));
////				ddp.setPhong(new Phong(rs.getNString(2)));
////				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getNString(8));
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return ddp;
////	}
////
////	public ArrayList<DonDatPhong> getDDPTheoMaKH(String ma){
////		ArrayList<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		try {
////			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where maKH = N'"+ma+"' and TrangThaiDDP = N'Chờ xác nhận'");
////			ResultSet rs = ps.executeQuery();
////			while(rs.next()) {
////				DonDatPhong ddp=new DonDatPhong();
////				ddp.setMaDDP(rs.getNString(1));
////				ddp.setPhong(new Phong(rs.getNString(2)));
////				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getNString(8));
////				lstDDP.add(ddp);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return lstDDP;
////	}
////
////	public ArrayList<DonDatPhong> sortMaDDP(String kieuSX) {
////		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		try {
////			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where TrangThaiDDP != N'Hủy' order by maDDP "+kieuSX+"");
////			ResultSet rs = ps.executeQuery();
////			while(rs.next()) {
////				DonDatPhong ddp = new DonDatPhong();
////				ddp.setMaDDP(rs.getString(1));
////				ddp.setPhong(new Phong(rs.getString(2)));
////				ddp.setKhachHang(new KhachHang(rs.getString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getString(8));
////				lstDDP.add(ddp);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return lstDDP;
////	}
////	
////	public ArrayList<DonDatPhong> sortDDPTheoLoaiPhong(String kieuSX) {
////		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
////		ConnectDB.getinstance();
////		Connection con = ConnectDB.getConnection();
////		try {
////			PreparedStatement ps = con.prepareStatement("SELECT DonDatPhong.* FROM DonDatPhong INNER JOIN Phong ON DonDatPhong.maPhong = Phong.maPhong "
////														+ "where maLoaiPhong != 'LP004' order by maLoaiPhong "+kieuSX+"");
////			ResultSet rs = ps.executeQuery();
////			while(rs.next()) {
////				DonDatPhong ddp = new DonDatPhong();
////				ddp.setMaDDP(rs.getString(1));
////				ddp.setPhong(new Phong(rs.getString(2)));
////				ddp.setKhachHang(new KhachHang(rs.getString(3)));
////				ddp.setNhanVien(new NhanVien(rs.getString(4)));
////				ddp.setNgayLap(rs.getDate(5));
////				ddp.setGioDen(rs.getTime(6));
////				ddp.setNgayDen(rs.getDate(7));
////				ddp.setTrangThaiDDP(rs.getString(8));
////				lstDDP.add(ddp);
////			}
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return lstDDP;
////	}
////	
////	
////	
////	
////	
////
////}
//
//
//package Dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import Connect.ConnectDB;
//import Entity.DonDatPhong;
//import Entity.KhachHang;
//import Entity.NhanVien;
//import Entity.Phong;
//
//
//
//public class DaoDatPhong {
//
//	public boolean themDDP(DonDatPhong ddp) throws SQLException {
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("insert into DonDatPhong values (?,?,?,?,?,?,?,?)");
//			ps.setString(1, ddp.getMaDDP());
//			ps.setString(2, ddp.getPhong().getMaPhong());
//			ps.setString(3, ddp.getKhachHang().getMaKhangHang());
//			ps.setString(4, ddp.getNhanVien().getMaNhanVien());
//			ps.setDate(5, ddp.getNgayLap());
//			ps.setTime(6, ddp.getGioDen());
//			ps.setDate(7, ddp.getNgayDen());
//			ps.setString(8, ddp.getTrangThaiDDP());
//
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	
//	public boolean capNhatDDP(DonDatPhong ddp, String ma) throws SQLException {
//		Connection con = ConnectDB.getConnection();
//		String sql = "update DonDatPhong set ngayLap = ?, gioDen = ?, ngayDen = ?, TrangThaiDDP = ? where maDDP like '"+ma+"'";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDate(1, ddp.getNgayLap());
//			ps.setTime(2, ddp.getGioDen());
//			ps.setDate(3, ddp.getNgayDen());
//			ps.setString(4, ddp.getTrangThaiDDP());
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	public boolean capNhatTrangThaiDDP(String ma) throws SQLException {
//		Connection con = ConnectDB.getConnection();
//		String sql = "update DonDatPhong set TrangThaiDDP = N'Đã trả phòng' where maDDP = '"+ma+"'";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	public ArrayList<DonDatPhong> getAllDanhSachDDP() {
//		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			String sql="select* from DonDatPhong ";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				DAONhanVien daoNV = new DAONhanVien();
//				DAOPhong daoPhong = new DAOPhong();
//				DAOKhachHang daoKH = new DAOKhachHang();
//				ddp.setMaDDP(rs.getString("maDDP"));
//				ddp.setKhachHang(daoKH.getKHTheoMa(rs.getString("maKH")));
//				ddp.setPhong(daoPhong.getPhongTheoMa(rs.getString("maPhong")));
//				ddp.setNhanVien(daoNV.getNVTheoMa(rs.getString("maNhanVien")));
////				ddp.setKhachHang(new KhachHang(rs.getString("maKH")));
////				ddp.setPhong(new Phong(rs.getString("maPhong")));
////				ddp.setNhanVien(new NhanVien(rs.getString("maNhanVien")));
//				ddp.setNgayLap(rs.getDate("ngayLap"));
//				ddp.setGioDen(rs.getTime("gioDen"));
//				ddp.setNgayDen(rs.getDate("ngayDen"));
//				ddp.setTrangThaiDDP(rs.getString("TrangthaiDDP"));
//				lsDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsDDP;
//	}
//	
//	public ArrayList<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() {
//		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select * from DonDatPhong where TrangThaiDDP != N'Hủy' and TrangThaiDDP != N'Đã trả phòng'";
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lsDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsDDP;
//	}
//
//	public DonDatPhong getDDPTheoMaPhong(String ma){
//		DonDatPhong ddp = new DonDatPhong();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DonDatPhong.*\r\n"
//				+ "FROM  DonDatPhong\r\n"
//				+ "where maPhong = N'"+ma+"' and TrangThaiDDP = N'Đã xác nhận'"
//				+ "";
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//
//				ddp.setMaDDP(rs.getNString(1));
//				ddp.setPhong(new Phong(rs.getNString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getNString(8));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ddp;
//	}
//
//	public ArrayList<DonDatPhong> getDDPTheoMaKH(String ma){
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where maKH = N'"+ma+"' and TrangThaiDDP = N'Chờ xác nhận'");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp=new DonDatPhong();
//				ddp.setMaDDP(rs.getNString(1));
//				ddp.setPhong(new Phong(rs.getNString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getNString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//
//	public ArrayList<DonDatPhong> sortMaDDP(String kieuSX) {
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where TrangThaiDDP != N'Hủy' order by maDDP "+kieuSX+"");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//	
//	public ArrayList<DonDatPhong> sortDDPTheoLoaiPhong(String kieuSX) {
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("SELECT DonDatPhong.* FROM DonDatPhong INNER JOIN Phong ON DonDatPhong.maPhong = Phong.maPhong "
//														+ "where maLoaiPhong != 'LP004' order by maLoaiPhong "+kieuSX+"");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//	
//	
//	
//	
//	
//
//}
//


//package Dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import Connect.ConnectDB;
//import Entity.DonDatPhong;
//import Entity.KhachHang;
//import Entity.NhanVien;
//import Entity.Phong;
//
//
//
//public class DaoDatPhong {
//	
//	
//	public boolean themDDP(DonDatPhong ddp) throws SQLException {
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("insert into DonDatPhong values (?,?,?,?,?,?,?,?)");
//			ps.setString(1, ddp.getMaDDP());
//			ps.setString(2, ddp.getPhong().getMaPhong());
//			ps.setString(3, ddp.getKhachHang().getMaKhangHang());
//			ps.setString(4, ddp.getNhanVien().getMaNhanVien());
//			ps.setDate(5, ddp.getNgayLap());
//			ps.setTime(6, ddp.getGioDen());
//			ps.setDate(7, ddp.getNgayDen());
//			ps.setString(8, ddp.getTrangThaiDDP());
//
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	
//	public boolean capNhatDDP(DonDatPhong ddp, String ma) throws SQLException {
//		Connection con = ConnectDB.getConnection();
//		String sql = "update DonDatPhong set ngayLap = ?, gioDen = ?, ngayDen = ?, TrangThaiDDP = ? where maDDP like '"+ma+"'";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDate(1, ddp.getNgayLap());
//			ps.setTime(2, ddp.getGioDen());
//			ps.setDate(3, ddp.getNgayDen());
//			ps.setString(4, ddp.getTrangThaiDDP());
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	public boolean capNhatTrangThaiDDP(String ma) throws SQLException {
//		Connection con = ConnectDB.getConnection();
//		String sql = "update DonDatPhong set TrangThaiDDP = N'Đã trả phòng' where maDDP = '"+ma+"'";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			return ps.executeUpdate() > 0;
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		con.close();
//		return false;
//	}
//	public ArrayList<DonDatPhong> getAllDanhSachDDP() {
//		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setKhachHang(new KhachHang(rs.getString(2)));
//				ddp.setPhong(new Phong(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lsDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsDDP;
//	}
//
//
//
//
//	
//	
//	public ArrayList<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() {
//		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "select * from DonDatPhong where TrangThaiDDP != N'Hủy' and TrangThaiDDP != N'Đã trả phòng'";
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lsDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lsDDP;
//	}
//
//	public DonDatPhong getDDPTheoMaPhong(String ma){
//		DonDatPhong ddp = new DonDatPhong();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		String sql = "SELECT DonDatPhong.*\r\n"
//				+ "FROM  DonDatPhong\r\n"
//				+ "where maPhong = N'"+ma+"' and TrangThaiDDP = N'Đã xác nhận'"
//				+ "";
//		try {
//			Statement stm = con.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			while(rs.next()) {
//
//				ddp.setMaDDP(rs.getNString(1));
//				ddp.setPhong(new Phong(rs.getNString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getNString(8));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ddp;
//	}
//
//	public ArrayList<DonDatPhong> getDDPTheoMaKH(String ma){
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where maKH = N'"+ma+"' and TrangThaiDDP = N'Chờ xác nhận'");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp=new DonDatPhong();
//				ddp.setMaDDP(rs.getNString(1));
//				ddp.setPhong(new Phong(rs.getNString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getNString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//
//	public ArrayList<DonDatPhong> sortMaDDP(String kieuSX) {
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where TrangThaiDDP != N'Hủy' order by maDDP "+kieuSX+"");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//	
//	public ArrayList<DonDatPhong> sortDDPTheoLoaiPhong(String kieuSX) {
//		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
//		ConnectDB.getinstance();
//		Connection con = ConnectDB.getConnection();
//		try {
//			PreparedStatement ps = con.prepareStatement("SELECT DonDatPhong.* FROM DonDatPhong INNER JOIN Phong ON DonDatPhong.maPhong = Phong.maPhong "
//														+ "where maLoaiPhong != 'LP004' order by maLoaiPhong "+kieuSX+"");
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				DonDatPhong ddp = new DonDatPhong();
//				ddp.setMaDDP(rs.getString(1));
//				ddp.setPhong(new Phong(rs.getString(2)));
//				ddp.setKhachHang(new KhachHang(rs.getString(3)));
//				ddp.setNhanVien(new NhanVien(rs.getString(4)));
//				ddp.setNgayLap(rs.getDate(5));
//				ddp.setGioDen(rs.getTime(6));
//				ddp.setNgayDen(rs.getDate(7));
//				ddp.setTrangThaiDDP(rs.getString(8));
//				lstDDP.add(ddp);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return lstDDP;
//	}
//	
//	
//	
//	
//	
//
//}


package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;



public class DaoDatPhong {

	public boolean themDDP(DonDatPhong ddp) throws SQLException {
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into DonDatPhong values (?,?,?,?,?,?,?,?)");
			ps.setString(1, ddp.getMaDDP());
			ps.setString(2, ddp.getPhong().getMaPhong());
			ps.setString(3, ddp.getKhachHang().getMaKhangHang());
			ps.setString(4, ddp.getNhanVien().getMaNhanVien());
			ps.setDate(5, (Date) ddp.getNgayLap());
			ps.setTime(6, ddp.getGioDen());
			ps.setDate(7, (Date) ddp.getNgayDen());
			ps.setString(8, ddp.getTrangThaiDDP());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public boolean capNhatDDP(DonDatPhong ddp, String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "update DonDatPhong set ngayLap = ?, gioDen = ?, ngayDen = ?, TrangThaiDDP = ? where maDDP like '"+ma+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDate(1, new Date(ddp.getNgayLap().getYear(),ddp.getNgayLap().getMonth(),ddp.getNgayLap().getDate()));

			ps.setTime(2, ddp.getGioDen());
			ps.setDate(3, new Date(ddp.getNgayDen().getYear(),ddp.getNgayDen().getMonth(),ddp.getNgayDen().getDate()));
			ps.setString(4, ddp.getTrangThaiDDP());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}
	public int capnhatTrangThaiPhongvaDDP()throws SQLException {
		Connection con = ConnectDB.getConnection();
		int n = 0;
		String sql = "update phong\r\n"
				+ "set tinhTrangPhong = case\r\n"
				+ "when maPhong  in (select distinct maphong from DonDatPhong \r\n"
				+ "					where (((DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen))-DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())) between 0 and 120 )\r\n"
				+ "								and TrangThaiDDP like N'Chờ xác nhận')then N'Đặt trước'\r\n"
				+ "when maPhong in( select distinct maPhong from DonDatPhong\r\n"
				+ "	where (DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())-(DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen)))>0 and TrangThaiDDP like N'Chờ xác nhận') then N'Trống'\r\n"
				+ "else phong.tinhTrangPhong\r\n"
				+ "end\r\n"
				+ "\r\n"
				+ "update DonDatPhong\r\n"
				+ "set TrangThaiDDP =N'Huỷ'\r\n"
				+ "where (DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),GETDATE())-(DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),ngayDen)+DATEDIFF(minute,cast('1900-01-01 00:00:00.000' as datetime),gioDen)))>0 and TrangThaiDDP like N'Chờ xác nhận'\r\n"
				+ " ";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			n= stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	public boolean capNhatTrangThaiDDP(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "update DonDatPhong set TrangThaiDDP = N'Đã trả phòng' where maDDP = '"+ma+"'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return false;
	}
	public ArrayList<DonDatPhong> getAllDanhSachDDP() {
		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			String sql="select* from DonDatPhong ";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonDatPhong ddp = new DonDatPhong();
				DAONhanVien daoNV = new DAONhanVien();
				DAOPhong daoPhong = new DAOPhong();
				DAOKhachHang daoKH = new DAOKhachHang();
				ddp.setMaDDP(rs.getString("maDDP"));
				ddp.setKhachHang(daoKH.getKHTheoMa(rs.getString("maKH")));
				ddp.setPhong(daoPhong.getPhongTheoMa(rs.getString("maPhong")));
				ddp.setNhanVien(daoNV.getNVTheoMa(rs.getString("maNhanVien")));
//				ddp.setKhachHang(new KhachHang(rs.getString("maKH")));
//				ddp.setPhong(new Phong(rs.getString("maPhong")));
//				ddp.setNhanVien(new NhanVien(rs.getString("maNhanVien")));
				ddp.setNgayLap(rs.getDate("ngayLap"));
				ddp.setGioDen(rs.getTime("gioDen"));
				ddp.setNgayDen(rs.getDate("ngayDen"));
				ddp.setTrangThaiDDP(rs.getString("TrangthaiDDP"));
				lsDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsDDP;
	}
	
	public ArrayList<DonDatPhong> getDanhSachDDPChoXacNhanVaDaXacNhan() {
		ArrayList<DonDatPhong> lsDDP = new ArrayList<DonDatPhong>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "select * from DonDatPhong where TrangThaiDDP != N'Hủy' and TrangThaiDDP != N'Đã trả phòng'";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				DonDatPhong ddp = new DonDatPhong();
				ddp.setMaDDP(rs.getString(1));
				ddp.setPhong(new Phong(rs.getString(2)));
				ddp.setKhachHang(new KhachHang(rs.getString(3)));
				ddp.setNhanVien(new NhanVien(rs.getString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getString(8));
				lsDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lsDDP;
	}

	public DonDatPhong getDDPTheoMaPhong(String ma){
		DonDatPhong ddp = new DonDatPhong();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DonDatPhong.*\r\n"
				+ "FROM  DonDatPhong\r\n"
				+ "where maPhong = N'"+ma+"' and TrangThaiDDP = N'Đã xác nhận'"
				+ "";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {

				ddp.setMaDDP(rs.getNString(1));
				ddp.setPhong(new Phong(rs.getNString(2)));
				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getNString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ddp;
	}

	public ArrayList<DonDatPhong> getDDPTheoMaKH(String ma){
		ArrayList<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where maKH = N'"+ma+"' and TrangThaiDDP = N'Chờ xác nhận'");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonDatPhong ddp=new DonDatPhong();
				ddp.setMaDDP(rs.getNString(1));
				ddp.setPhong(new Phong(rs.getNString(2)));
				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getNString(8));
				lstDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstDDP;
	}
	public ArrayList<DonDatPhong> getDDPTheoMaDDP(String ma){
		ArrayList<DonDatPhong> lstDDP = new ArrayList<DonDatPhong>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where maDDP like N'%"+ma+"%' ");
		
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonDatPhong ddp=new DonDatPhong();
				DAOPhong daoPhong = new DAOPhong();
				ddp.setMaDDP(rs.getNString(1));
				ddp.setPhong(daoPhong.getPhongTheoMa(rs.getNString(2)));
				ddp.setKhachHang(new KhachHang(rs.getNString(3)));
				ddp.setNhanVien(new NhanVien(rs.getNString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getNString(8));
				lstDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstDDP;
	}
	public ArrayList<DonDatPhong> sortMaDDP(String kieuSX) {
		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from DonDatPhong where TrangThaiDDP != N'Hủy' order by maDDP "+kieuSX+"");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonDatPhong ddp = new DonDatPhong();
				ddp.setMaDDP(rs.getString(1));
				ddp.setPhong(new Phong(rs.getString(2)));
				ddp.setKhachHang(new KhachHang(rs.getString(3)));
				ddp.setNhanVien(new NhanVien(rs.getString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getString(8));
				lstDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstDDP;
	}
	
	public ArrayList<DonDatPhong> sortDDPTheoLoaiPhong(String kieuSX) {
		ArrayList<DonDatPhong> lstDDP = new ArrayList<>();
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT DonDatPhong.* FROM DonDatPhong INNER JOIN Phong ON DonDatPhong.maPhong = Phong.maPhong "
														+ "where maLoaiPhong != 'LP004' order by maLoaiPhong "+kieuSX+"");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DonDatPhong ddp = new DonDatPhong();
				ddp.setMaDDP(rs.getString(1));
				ddp.setPhong(new Phong(rs.getString(2)));
				ddp.setKhachHang(new KhachHang(rs.getString(3)));
				ddp.setNhanVien(new NhanVien(rs.getString(4)));
				ddp.setNgayLap(rs.getDate(5));
				ddp.setGioDen(rs.getTime(6));
				ddp.setNgayDen(rs.getDate(7));
				ddp.setTrangThaiDDP(rs.getString(8));
				lstDDP.add(ddp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstDDP;
	}
	
	
	
	
	

}


