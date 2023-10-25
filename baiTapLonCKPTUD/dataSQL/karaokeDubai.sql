USE [master]

GO
--drop DATABASE [KaraokeDuBai]
CREATE DATABASE [KaraokeDuBai]
GO
use [KaraokeDuBai]
go
CREATE TABLE [dbo].[CTDDP](
	[maDDP] [nvarchar](50) NOT NULL,
	[maMH] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_CTDDP] PRIMARY KEY CLUSTERED 
(
	[maDDP] ASC,
	[maMH] ASC
))
GO

CREATE TABLE [dbo].[CTHD](
	[maHD] [nvarchar](50) NOT NULL,
	[maMH] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_CTHD] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maMH] ASC
))
GO
GO
CREATE TABLE [dbo].[DonDatPhong](
	[maDDP] [nvarchar](50) NOT NULL,
	[maPhong] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NULL,
	[gioDen] [time](7) NULL,
	[ngayDen] [date] NULL,
	[TrangThaiDDP] [nvarchar](255) NULL,
 CONSTRAINT [PK_DonDatPhong] PRIMARY KEY CLUSTERED 
(
	[maDDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [nvarchar](50) NOT NULL,
	[maPhong] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNhanVien] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NULL,
	[gioVao] [time](7) NULL,
	[gioRa] [time](7) NULL,
	[phuThu] [nvarchar](255) NULL,
	[trangThai] [nvarchar](255) NULL,
	[giamGia] [float] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
))

CREATE TABLE [dbo].[KhachHang](
	[maKhachHang] [nvarchar](50) NOT NULL,
	[maLoaiKH] [nvarchar](50) NOT NULL,
	[tenKH] [nvarchar](255) NULL,
	[sdt] [nvarchar](255) NULL,
	[cccd] [nvarchar](255) NULL,
	[diaChi] [nvarchar](255) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](255) NULL,
	[diemTichLuy] [int] NULL,
	[ngayDangKy] [date] NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKhachHang] ASC
))

CREATE TABLE [dbo].[LoaiKH](
	[maLoaiKH] [nvarchar](50) NOT NULL,
	[tenLoaiKH] [nvarchar](255) NULL,
 CONSTRAINT [PK_LoaiKH] PRIMARY KEY CLUSTERED 
(
	[maLoaiKH] ASC
))

CREATE TABLE [dbo].[LoaiMatHang](
	[maLoaiMH] [nvarchar](50) NOT NULL,
	[tenLoaiMH] [nvarchar](255) NULL,
 CONSTRAINT [PK_LoaiMatHang] PRIMARY KEY CLUSTERED 
(
	[maLoaiMH] ASC
))
GO

CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [nvarchar](50) NOT NULL,
	[tenLoaiPhong] [nvarchar](255) NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
))
GO

CREATE TABLE [dbo].[MatHang](
	[maMH] [nvarchar](50) NOT NULL,
	[maLoaiMH] [nvarchar](50) NOT NULL,
	[tenMH] [nvarchar](255) NULL,
	[soLuongMH] [int] NULL,
	[giaMH] [float] NULL,
 CONSTRAINT [PK_MatHang] PRIMARY KEY CLUSTERED 
(
	[maMH] ASC
))

CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nvarchar](50) NOT NULL,
	[maTK] [nvarchar](50) NOT NULL,
	[tenNhanVien] [nvarchar](255) NULL,
	[chucVu] [nvarchar](255) NULL,
	[gioiTinh] [nvarchar](255) NULL,
	[ngaySinh] [date] NULL,
	[diaChi] [nvarchar](255) NULL,
	[sdt] [nvarchar](255) NULL,
	[cccd] [nvarchar](255) NULL,
	[luong] [float] NULL,
	[caLamViec] [nvarchar](255) NULL,
	[trangThaiLamViec] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
))

CREATE TABLE [dbo].[Phong](
	[maPhong] [nvarchar](50) NOT NULL,
	[maLoaiPhong] [nvarchar](50) NOT NULL,
	[tinhTrangPhong] [nvarchar](255) NULL,
	[giaPhong] [float] NULL,
	[sucChua] [int] NULL,
	[moTa] [nvarchar](50) NULL
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
))
GO

CREATE TABLE [dbo].[TaiKhoan](
	[maTK] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](255) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maTK] ASC
))
GO
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP001', N'MH001', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP001', N'MH002', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP001', N'MH003', 4)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP001', N'MH004', 1)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP002', N'MH001', 20)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP002', N'MH002', 1)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP002', N'MH010', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH008', 8)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH011', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH014', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH016', 8)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH018', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP004', N'MH019', 20)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH001', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH002', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH004', 1)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH005', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH007', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP005', N'MH009', 15)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP007', N'MH001', 3)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP007', N'MH013', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP007', N'MH014', 3)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP007', N'MH017', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP008', N'MH004', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP008', N'MH009', 15)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP008', N'MH014', 15)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP009', N'MH001', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP009', N'MH002', 20)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP009', N'MH009', 20)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP009', N'MH014', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP010', N'MH001', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP010', N'MH011', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP010', N'MH016', 15)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP012', N'MH002', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP013', N'MH001', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP013', N'MH003', 8)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP013', N'MH004', 10)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP013', N'MH017', 2)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP014', N'MH002', 5)
INSERT [dbo].[CTDDP] ([maDDP], [maMH], [soLuong]) VALUES (N'DDP014', N'MH011', 10)
GO
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD001', N'MH001', 10)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD001', N'MH002', 2)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD001', N'MH003', 4)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD001', N'MH004', 1)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD002', N'MH001', 20)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD002', N'MH002', 1)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD002', N'MH010', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH008', 8)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH011', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH012', 4)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH014', 2)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH016', 8)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH018', 10)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD012', N'MH019', 20)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD013', N'MH001', 3)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD013', N'MH013', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD013', N'MH014', 3)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD013', N'MH017', 2)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH008', 8)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH011', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH014', 2)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH016', 8)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH018', 10)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD014', N'MH019', 20)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH001', 10)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH002', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH004', 1)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH005', 10)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH007', 2)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD015', N'MH009', 15)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD016', N'MH004', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD016', N'MH009', 15)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD016', N'MH014', 15)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD017', N'MH002', 5)
INSERT [dbo].[CTHD] ([maHD], [maMH], [soLuong]) VALUES (N'HD017', N'MH011', 10)
GO
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP001', N'P001', N'KH001', N'NV002', CAST(N'2020-10-11' AS Date), CAST(N'10:30:00' AS Time), CAST(N'2020-10-11' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP002', N'P001', N'KH002', N'NV002', CAST(N'2020-12-10' AS Date), CAST(N'17:00:00' AS Time), CAST(N'2020-12-10' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP003', N'P002', N'KH003', N'NV003', CAST(N'2020-12-11' AS Date), CAST(N'15:00:00' AS Time), CAST(N'2020-12-11' AS Date), N'Hủy')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP004', N'P002', N'KH001', N'NV003', CAST(N'2020-11-12' AS Date), CAST(N'18:30:00' AS Time), CAST(N'2020-11-12' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP005', N'P003', N'KH004', N'NV002', CAST(N'2021-01-01' AS Date), CAST(N'18:00:00' AS Time), CAST(N'2021-01-01' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP006', N'P003', N'KH003', N'NV002', CAST(N'2021-11-10' AS Date), CAST(N'20:15:00' AS Time), CAST(N'2021-11-10' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP007', N'P004', N'KH005', N'NV003', CAST(N'2021-10-10' AS Date), CAST(N'19:00:00' AS Time), CAST(N'2021-10-10' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP008', N'P006', N'KH012', N'NV002', CAST(N'2021-11-16' AS Date), CAST(N'13:20:00' AS Time), CAST(N'2021-11-16' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP009', N'P012', N'KH008', N'NV003', CAST(N'2021-11-17' AS Date), CAST(N'10:25:00' AS Time), CAST(N'2021-11-17' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP010', N'P003', N'KH009', N'NV009', CAST(N'2021-11-17' AS Date), CAST(N'07:30:00' AS Time), CAST(N'2021-11-17' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP011', N'P015', N'KH010', N'NV009', CAST(N'2021-11-17' AS Date), CAST(N'08:15:00' AS Time), CAST(N'2021-11-17' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP012', N'P007', N'KH011', N'NV003', CAST(N'2021-11-17' AS Date), CAST(N'08:25:00' AS Time), CAST(N'2021-11-17' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP013', N'P002', N'KH006', N'NV009', CAST(N'2021-11-17' AS Date), CAST(N'08:50:00' AS Time), CAST(N'2021-11-17' AS Date), N'Đã trả phòng')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP014', N'P001', N'KH020', N'NV002', CAST(N'2021-12-18' AS Date), CAST(N'09:21:00' AS Time), CAST(N'2021-12-18' AS Date), N'Hủy')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP015', N'P002', N'KH021', N'NV002', CAST(N'2021-12-18' AS Date), CAST(N'09:26:00' AS Time), CAST(N'2021-12-18' AS Date), N'Hủy')
INSERT [dbo].[DonDatPhong] ([maDDP], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioDen], [ngayDen], [TrangThaiDDP]) VALUES (N'DDP016', N'P005', N'KH021', N'NV002', CAST(N'2021-12-18' AS Date), CAST(N'09:30:00' AS Time), CAST(N'2021-12-18' AS Date), N'Hủy')
GO
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD001', N'P001', N'KH001', N'NV002', CAST(N'2020-10-11' AS Date), CAST(N'10:30:00' AS Time), CAST(N'13:30:00' AS Time), N'Không', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD002', N'P001', N'KH002', N'NV002', CAST(N'2020-12-10' AS Date), CAST(N'17:00:00' AS Time), CAST(N'20:00:00' AS Time), N'Không', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD006', N'P002', N'KH001', N'NV002', CAST(N'2021-12-03' AS Date), CAST(N'18:30:00' AS Time), CAST(N'23:00:00' AS Time), N'Không', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD007', N'P004', N'KH005', N'NV002', CAST(N'2021-11-03' AS Date), CAST(N'19:00:00' AS Time), CAST(N'22:00:00' AS Time), N'Không', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD008', N'P003', N'KH004', N'NV002', CAST(N'2020-12-03' AS Date), CAST(N'18:00:00' AS Time), CAST(N'23:00:00' AS Time), N'Buổi tối', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD009', N'P003', N'KH004', N'NV002', CAST(N'2021-10-03' AS Date), CAST(N'18:00:00' AS Time), CAST(N'23:00:00' AS Time), N'Không', N'Đã thanh toán', 0)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD012', N'P002', N'KH001', N'NV002', CAST(N'2021-11-04' AS Date), CAST(N'18:30:00' AS Time), CAST(N'23:14:00' AS Time), N'Buổi tối', N'Đã thanh toán', 200000)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD013', N'P004', N'KH005', N'NV002', CAST(N'2021-11-09' AS Date), CAST(N'19:00:00' AS Time), CAST(N'23:00:00' AS Time), N'Không', N'Đã thanh toán', 107000)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD014', N'P002', N'KH001', N'NV002', CAST(N'2021-11-12' AS Date), CAST(N'18:30:00' AS Time), CAST(N'23:32:00' AS Time), N'Không', N'Đã thanh toán', 266333.33333333331)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD015', N'P003', N'KH004', N'NV002', CAST(N'2021-11-16' AS Date), CAST(N'18:00:00' AS Time), CAST(N'22:00:00' AS Time), N'Không', N'Đã thanh toán', 196000)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD016', N'P006', N'KH012', N'NV002', CAST(N'2021-11-16' AS Date), CAST(N'13:20:00' AS Time), CAST(N'22:05:00' AS Time), N'Không', N'Đã thanh toán', 115875)
INSERT [dbo].[HoaDon] ([maHD], [maPhong], [maKH], [maNhanVien], [ngayLap], [gioVao], [gioRa], [phuThu], [trangThai], [giamGia]) VALUES (N'HD017', N'P001', N'KH020', N'NV002', CAST(N'2021-12-18' AS Date), CAST(N'22:00:00' AS Time), CAST(N'23:00:00' AS Time), N'Không', N'Đã thanh toán', 0)
GO
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH001', N'LKH001', N'Đoàn Phạm Bích Hợp', N'0708985897', N'056546236412', N'1358 Quang Trung, P.14, Q.Gò Vấp', CAST(N'2001-03-01' AS Date), N'Nữ', 0, CAST(N'2021-08-03' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH002', N'LKH002', N'Nguyễn Thị Tường Vy', N'0383068801', N'056523326647', N'1374/1c tổ 11 khu phố 4, P.An Phú Đông, Q.12', CAST(N'2003-10-27' AS Date), N'Nữ', 12, CAST(N'2021-09-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH003', N'LKH003', N'Lê Hữu Nam Kha', N'0936903351', N'079201011268', N'597/29/6 Quang Trung, P.11', CAST(N'2001-11-02' AS Date), N'Nam', 41, CAST(N'2021-06-10' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH004', N'LKH002', N'Bùi Thị Thanh Tuyền', N'0968105419', N'079301015409', N'11/1B ấp Nam Lân Bà Điểm, Hóc Môn', CAST(N'2001-01-25' AS Date), N'Nữ', 51, CAST(N'2021-02-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH005', N'LKH003', N'Phạm Hà Minh Hương', N'0916836933', N'079301231302', N'16C5 đường DN3, P.Tân Hưng Thuận, Q.12', CAST(N'2001-10-10' AS Date), N'Nữ', 33, CAST(N'2021-05-19' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH006', N'LKH002', N'Hồ Tuấn Ngọc', N'0777959011', N'079201031493', N'66 Thống Nhất, P.10, Q.Gò Vấp', CAST(N'2001-08-27' AS Date), N'Nam', 12, CAST(N'2021-03-02' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH007', N'LKH001', N'Thái Doãn Hoàng An', N'0901762781', N'079203004825', N'220/120 đường số 10, P.9, Q.Gò Vấp', CAST(N'2003-01-25' AS Date), N'Nam', 0, CAST(N'2021-01-30' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH008', N'LKH003', N'Đặng Phước Tuyền', N'0932012306', N'079201000674', N'157/20 Phạm Văn Chiêu, P.14, Q.Gò Vấp ', CAST(N'2001-01-01' AS Date), N'Nam', 22, CAST(N'2021-01-23' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH009', N'LKH001', N'Trần Phương Uyên', N'0797935560', N'079301013322', N'47/3A Trung Lân, Bà Điểm, Hóc Môn', CAST(N'2001-11-06' AS Date), N'Nữ', 0, CAST(N'2021-04-12' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH010', N'LKH002', N'Phan Thị Hồng Nhung', N'0357986976', N'079301013322', N'72/3 Văn Chung, P.13, Q.Tân Bình', CAST(N'1992-04-05' AS Date), N'Nữ', 12, CAST(N'2021-03-02' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH011', N'LKH003', N'Trương Gia Lâm', N'0964734410', N'072010061791', N'88/964 Lê Đức Thọ, Q.Gò Vấp', CAST(N'2000-04-20' AS Date), N'Nam', 24, CAST(N'2020-12-09' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH012', N'LKH001', N'Nguyễn Phạm Phương Uyên', N'0932543143', N'079201609129', N'15 Nguyễn Kiệm, Q.Gò Vấp', CAST(N'1999-09-11' AS Date), N'Nữ', 0, CAST(N'2021-01-01' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH013', N'LKH002', N'Vũ Hoang Lan Anh', N'0777618759', N'079201031607', N'21A Nguyễn Công Trứ, Q.5', CAST(N'1986-11-24' AS Date), N'Nữ', 12, CAST(N'2021-04-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH014', N'LKH003', N'Nguyễn Trần Trường Thắng', N'0123022771', N'072010567122', N'42/10/2 Đoàn Thị Điểm, Q.Phú Nhuận', CAST(N'1991-01-02' AS Date), N'Nam', 30, CAST(N'2021-03-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH015', N'LKH001', N'Đinh Nhất Thắng', N'0320613210', N'079121032845', N'69 Điện Biên Phủ, Q.3', CAST(N'1995-04-20' AS Date), N'Nam', 0, CAST(N'2021-01-24' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH016', N'LKH003', N'Trần Tiến Đạt', N'0342010311', N'079152528456', N'42 Hòa Hưng, Q.3', CAST(N'1997-03-19' AS Date), N'Nam', 24, CAST(N'2021-05-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH017', N'LKH001', N'Nguyễn Thị Tuyết Nhi', N'0352215311', N'072340127147', N'48 Phố Mỹ Hưng, Q.7', CAST(N'2000-02-20' AS Date), N'Nữ', 0, CAST(N'2020-11-20' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH018', N'LKH001', N'Đoàn Nguyễn Anh Tuấn', N'0777527724', N'07952652845', N'7 Nguyễn Văn Linh, Q.7', CAST(N'2003-01-20' AS Date), N'Nam', 33, CAST(N'2021-03-14' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH019', N'LKH003', N'Trần Đức Bo', N'0779769831', N'079201013276', N'8/16/1 TX40 tổ 38 khu phố 3, P.Thạnh Xuân, Q.12', CAST(N'2001-01-21' AS Date), N'Nam', 12, CAST(N'2021-06-21' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH020', N'LKH004', N'Tăng Thị Lan Anh', N'0779324831', N'072340122361', N'53 Thống Nhất, Q.Gò Vấp', CAST(N'2001-05-19' AS Date), N'Nữ', 12, CAST(N'2021-02-20' AS Date))
INSERT [dbo].[KhachHang] ([maKhachHang], [maLoaiKH], [tenKH], [sdt], [cccd], [diaChi], [ngaySinh], [gioiTinh], [diemTichLuy], [ngayDangKy]) VALUES (N'KH021', N'LKH001', N'Đinh Quang Tuấn', N'0903142210', NULL, N'118 Hoàng Văn Thụ, P9, Q.Phú Nhuận', NULL, NULL, 0, NULL)
GO
INSERT [dbo].[LoaiKH] ([maLoaiKH], [tenLoaiKH]) VALUES (N'LKH001', N'Khách hàng thường')
INSERT [dbo].[LoaiKH] ([maLoaiKH], [tenLoaiKH]) VALUES (N'LKH002', N'Thành viên thường')
INSERT [dbo].[LoaiKH] ([maLoaiKH], [tenLoaiKH]) VALUES (N'LKH003', N'Thành viên VIP')
INSERT [dbo].[LoaiKH] ([maLoaiKH], [tenLoaiKH]) VALUES (N'LKH004', N'Không còn là khách hàng')
GO
INSERT [dbo].[LoaiMatHang] ([maLoaiMH], [tenLoaiMH]) VALUES (N'LMH001', N'Đồ uống')
INSERT [dbo].[LoaiMatHang] ([maLoaiMH], [tenLoaiMH]) VALUES (N'LMH002', N'Đồ ăn')
INSERT [dbo].[LoaiMatHang] ([maLoaiMH], [tenLoaiMH]) VALUES (N'LMH003', N'Khác')
INSERT [dbo].[LoaiMatHang] ([maLoaiMH], [tenLoaiMH]) VALUES (N'LMH004', N'Ngừng kinh doanh')
GO
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'LP001', N'Phòng thường')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'LP002', N'Phòng trung')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'LP003', N'Phòng VIP')
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [tenLoaiPhong]) VALUES (N'LP004', N'Ngừng hoạt động')
GO
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH001', N'LMH003', N'Khăn giấy', 4980, 5000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH002', N'LMH001', N'Bia Heniken Silver', 600, 45000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH003', N'LMH001', N'Bia Heniken', 1192, 40000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH004', N'LMH001', N'Bia Tiger Silver', 625, 35000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH005', N'LMH001', N'Bia Tiger', 2400, 30000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH006', N'LMH001', N'Bia Sài Gòn', 2400, 28000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH007', N'LMH001', N'Bia Ruby', 960, 25000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH008', N'LMH001', N'Coca Cola', 1200, 20000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH009', N'LMH001', N'Pepsi', 1165, 20000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH010', N'LMH001', N'StrongBow táo', 480, 35000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH011', N'LMH001', N'StrongBow mật ong', 465, 35000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH012', N'LMH001', N'StrongBow dâu', 100493, 35000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH013', N'LMH001', N'StrongBow dâu đen', 475, 35000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH014', N'LMH002', N'Trái cây tổng hợp', 33, 80000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH016', N'LMH002', N'Bánh Snack', 185, 20000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH017', N'LMH001', N'Không độ', 478, 20000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH018', N'LMH001', N'Trà ô long', 1200, 25000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH019', N'LMH001', N'Wake Up 247', 1200, 25000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH020', N'LMH001', N'Bò húc ', 1200, 30000)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH021', N'LMH004', N'a', 5, 1)
INSERT [dbo].[MatHang] ([maMH], [maLoaiMH], [tenMH], [soLuongMH], [giaMH]) VALUES (N'MH022', N'LMH004', N'Snack', 500, 5000)
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV001', N'NV001', N'Phạm Vũ Hoài An', N'Phục vụ', N'Nữ', CAST(N'2000-04-20' AS Date), N'60 Thống Nhất, p10, Q.Gò Vấp', N'0966105479', N'079001013302', 5000000, N'1', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV002', N'NV002', N'Trần Thanh Thiện', N'Quản lý', N'Nam', CAST(N'1990-11-09' AS Date), N'34 Nguyễn Văn Linh, Q.7', N'0977531720', N'079010814123', 10000000, N'3', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV003', N'NV003', N'Nguyễn Thu Phương', N'Thu ngân', N'Nữ', CAST(N'1995-03-03' AS Date), N'15 Nguyễn Kiệm, Q.Gò Vấp', N'0938135702', N'079201553276', 6000000, N'2', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV004', N'NV004', N'Phan Hữu Trọng', N'Quản lý', N'Nam', CAST(N'2001-10-11' AS Date), N'12 Nguyễn Văn Bảo, Gò Vấp, HCM', N'0363435019', N'0791234567', 10000000, N'1', N'Đã nghỉ việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV006', N'NV006', N' Quang Tuấn', N'Quản lý', N'Nam', CAST(N'2021-11-05' AS Date), N'118 Hoàng Văn Thụ, Q.Phú Nhuận, Tp.HCM', N'0944302210', N'123456789012', 10000000, N'1', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV007', N'NV007', N'Nguyễn Thanh Toàn', N'Phục vụ', N'Nam', CAST(N'2001-05-19' AS Date), N'53 thống nhất, P11, gò vấp, TP. HCM', N'0777610987', N'079201031607', 5000000, N'2', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV008', N'NV008', N'Phùng Bùi Trọng Hiếu', N'Thu ngân', N'Nam', CAST(N'2001-07-10' AS Date), N'69/1B, tổ 2 ấp 7, Xuân Thới Thượng, Hóc Môn, TP.HCM', N'0777618759', N'079285786185', 6000000, N'3', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV009', N'NV009', N'Nguyễn Ngọc Anh', N'Thu ngân', N'Nữ', CAST(N'1998-05-19' AS Date), N' Tân Bình,TP.HCM', N'0957178889', N'079126768926', 6000000, N'3', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV010', N'NV010', N'Lê Đăng Khoa', N'Phục vụ', N'Nam', CAST(N'1997-11-20' AS Date), N'50 Đinh Tiên Hoàng, Q1, TP.HCM', N'0350980812', N'079678976521', 5000000, N'2', N'Đã nghỉ việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV011', N'NV011', N'Lê Thanh Tuấn Anh', N'Phục vụ', N'Nam', CAST(N'1999-09-17' AS Date), N'50 Phan Văn Trị, Gò Vấp, TP.HCM', N'0362347860', N'079567342821', 5000000, N'3', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV012', N'NV012', N'Diệp Lâm Anh', N'Phục vụ', N'Nữ', CAST(N'1992-07-28' AS Date), N'TP. HCM', N'0386877499', N'259674817264', 5000000, N'2', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV013', N'NV013', N'Lê Bảo Bình ', N'Phục vụ', N'Nam', CAST(N'1992-07-28' AS Date), N'23 Phú Mỹ Hưng quận 7,TP.HCM', N'0968596397', N'031245812342', 5000000, N'2', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV014', N'NV014', N'Nguyễn Tố Ngọc Trang', N'Phục vụ', N'Nữ', CAST(N'1997-02-16' AS Date), N'68 Tân Kỳ Tân Qúy, TP. HCM', N'0973626737', N'485048720192', 5000000, N'1', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV015', N'NV015', N'Nguyễn Đình Thái Ngân', N'Phục vụ', N'Nam', CAST(N'1997-11-11' AS Date), N'123 Trần Quốc Thảo quận  3,TP.HCM', N'0362033036', N'035374569142', 5000000, N'1', N'Đang làm việc')
INSERT [dbo].[NhanVien] ([maNhanVien], [maTK], [tenNhanVien], [chucVu], [gioiTinh], [ngaySinh], [diaChi], [sdt], [cccd], [luong], [caLamViec], [trangThaiLamViec]) VALUES (N'NV016', N'NV016', N'Trần Anh Khoa', N'Thu ngân', N'Nam', CAST(N'1997-11-11' AS Date), N'867 Quang Trung, Gò Vấp, TP.HCM', N'0978047896', N'031745892310', 6000000, N'1', N'Đã nghỉ việc')
GO
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P001', N'LP001', N'Trống', 100000,12,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P002', N'LP001', N'Đang hoạt động', 100000,15,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P003', N'LP002', N'Trống', 150000,10,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P004', N'LP003', N'Trống', 200000,10,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P005', N'LP002', N'Trống', 150000,12,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P006', N'LP002', N'Trống', 150000,15,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P007', N'LP003', N'Trống', 200000,15,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P008', N'LP001', N'Trống', 100000,12,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P009', N'LP002', N'Trống', 150000,10,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P010', N'LP003', N'Trống', 200000,15,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P011', N'LP003', N'Trống', 200000,10,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P012', N'LP002', N'Trống', 150000,12,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P013', N'LP001', N'Trống', 100000,12,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P014', N'LP002', N'Trống', 150000,12,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P015', N'LP004', N'Trống', 100000,15,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P016', N'LP003', N'Trống', 200000,10,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P017', N'LP001', N'Trống', 100000,10,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P018', N'LP001', N'Trống', 100000,15,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P019', N'LP002', N'Trống', 150000,12,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P020', N'LP002', N'Trống', 150000,12,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P021', N'LP002', N'Trống', 150000,10,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P022', N'LP002', N'Trống', 150000,15,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P023', N'LP003', N'Trống', 200000,15,N'Cổ Điển')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P024', N'LP003', N'Trống', 200000,10,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P025', N'LP003', N'Trống', 200000,10,N'Hiện Đại')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P026', N'LP001', N'Trống', 100000,12,N'Truyền Thống')
INSERT [dbo].[Phong] ([maPhong], [maLoaiPhong], [tinhTrangPhong], [giaPhong], [sucChua],[moTa]) VALUES (N'P027', N'LP001', N'Trống', 100000,15,N'Hiện Đại')
GO
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV001', N'NV001')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV002', N'NV002')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV003', N'NV003')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV004', N'TN003')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV005', N'NV0050363435123')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV006', N'NV0060944302210')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV007', N'NV0070777618759')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV008', N'NV0080777618759')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV009', N'NV0090957178889')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV010', N'NV0100350980812')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV011', N'NV0110362347860')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV012', N'NV0120386877499')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV013', N'NV0130968596397')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV014', N'NV0140973626737')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV015', N'NV0150362033036')
INSERT [dbo].[TaiKhoan] ([maTK], [matKhau]) VALUES (N'NV016', N'NV0160978047896')
GO
SET ANSI_PADDING ON
GO

ALTER TABLE [dbo].[NhanVien] ADD  CONSTRAINT [IX_NhanVien] UNIQUE NONCLUSTERED 
(
	[maTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CTDDP]  WITH CHECK ADD  CONSTRAINT [FK_CTDDP_DonDatPhong] FOREIGN KEY([maDDP])
REFERENCES [dbo].[DonDatPhong] ([maDDP])
GO
ALTER TABLE [dbo].[CTDDP] CHECK CONSTRAINT [FK_CTDDP_DonDatPhong]
GO
ALTER TABLE [dbo].[CTDDP]  WITH CHECK ADD  CONSTRAINT [FK_CTDDP_MatHang] FOREIGN KEY([maMH])
REFERENCES [dbo].[MatHang] ([maMH])
GO
ALTER TABLE [dbo].[CTDDP] CHECK CONSTRAINT [FK_CTDDP_MatHang]
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FK_CTHD_HoaDon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FK_CTHD_HoaDon]
GO
ALTER TABLE [dbo].[CTHD]  WITH CHECK ADD  CONSTRAINT [FK_CTHD_MatHang] FOREIGN KEY([maMH])
REFERENCES [dbo].[MatHang] ([maMH])
GO
ALTER TABLE [dbo].[CTHD] CHECK CONSTRAINT [FK_CTHD_MatHang]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_NhanVien]
GO
ALTER TABLE [dbo].[DonDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DonDatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DonDatPhong] CHECK CONSTRAINT [FK_DonDatPhong_Phong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKhachHang])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_Phong]
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD  CONSTRAINT [FK_KhachHang_LoaiKH] FOREIGN KEY([maLoaiKH])
REFERENCES [dbo].[LoaiKH] ([maLoaiKH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[KhachHang] CHECK CONSTRAINT [FK_KhachHang_LoaiKH]
GO
ALTER TABLE [dbo].[MatHang]  WITH CHECK ADD  CONSTRAINT [FK_MatHang_LoaiMatHang] FOREIGN KEY([maLoaiMH])
REFERENCES [dbo].[LoaiMatHang] ([maLoaiMH])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MatHang] CHECK CONSTRAINT [FK_MatHang_LoaiMatHang]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_TaiKhoan1] FOREIGN KEY([maTK])
REFERENCES [dbo].[TaiKhoan] ([maTK])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_TaiKhoan1]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
USE [master]
GO
ALTER DATABASE [KaraokeDuBai] SET  READ_WRITE 
GO
use KaraokeDuBai
update [dbo].[NhanVien]
set tenNhanVien = N'Nguyễn Hoàng Thái' where maNhanVien='NV002'