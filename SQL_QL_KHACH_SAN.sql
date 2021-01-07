CREATE DATABASE QL_KHACH_SAN
GO
USE QL_KHACH_SAN
GO

CREATE TABLE Quyen
(
	MaQuyen int PRIMARY KEY IDENTITY(1,1),
	Quyen nvarchar (50)
)
GO

CREATE TABLE PhanQuyen
(
	MaQuyen int,
	MaNhomQuyen int,
	PRIMARY KEY(MaQuyen, MaNhomQuyen)
)
GO

CREATE TABLE NhomQuyen
(
	MaNhomQuyen int PRIMARY KEY IDENTITY(1,1),
	TenNhomQuyen nvarchar (50)
)
GO

CREATE TABLE CauHinhNguoiDung
(
	MaCauHinh int,
	MaNguoiDung int,
	NoiDungCauHinh nvarchar (50),
	PRIMARY KEY(MaCauHinh, MaNguoiDung )
)
GO

CREATE TABLE CauHinh
(
	MaCauHinh int PRIMARY KEY IDENTITY(1,1),
	LoaiCauHinh nvarchar (50)
)
GO

CREATE TABLE NguoiDung
(
	MaNguoiDung int PRIMARY KEY IDENTITY(1,1),
	TenNguoiDung nvarchar (50) NOT NULL,
	TenDangNhap varchar (50) NOT NULL,
	MatKhau nvarchar (50) NOT NULL,
	Anh image,
	Email varchar (50) NOT NULL,
	NgaySinh datetime,
	GioiTinh bit,
	MaNhomQuyen int
)
GO

CREATE TABLE KhachHang
(
	MaKhachHang varchar (3) PRIMARY KEY NOT NULL,
	TenKhachHang nvarchar (50),
	CMND nvarchar (15) NOT NULL,
	DiaChi nvarchar (50),
	DienThoai varchar (15),
	GioiTinh bit,
	QuocTich nvarchar(50)
)
GO

CREATE TABLE ThietBi 
(
	MaThietBi varchar (8) PRIMARY KEY NOT NULL,
	MaLoaiPhong varchar (3) NOT NULL,
	TenThietBi nvarchar (50),
	SoLuong int,
	Gia float
)
GO

CREATE TABLE DonVi
(
	MaDonVi varchar (3) PRIMARY KEY NOT NULL,
	TenDonVi nvarchar (50)
)
GO

CREATE TABLE ChinhSachTraPhong 
(
	MaChinhSach varchar (5) PRIMARY KEY NOT NULL,
	NoiDung nvarchar (50),
	PhuThu float
)
GO

CREATE TABLE DichVu
(
	MaDichVu varchar (5) PRIMARY KEY NOT NULL,
	MaLoaiDichVu varchar (5) NOT NULL,
	MaDonVi varchar (3) NOT NULL,
	DonGia float Default(0)
)
GO

CREATE TABLE HoaDon
(
	MaHoaDon int PRIMARY KEY IDENTITY(1,1),
	MaKhachHang varchar (3) NOT NULL,
	MaNhanPhong varchar (5) NOT NULL,
	MaKhuyenMai int,
	NhanVienLap nvarchar (50),
	TongTien float NOT NULL,
	NgayLap datetime NOT NULL
)
GO

CREATE TABLE KhuyenMai
(
	MaKhuyenMai int PRIMARY KEY IDENTITY(1,1),
	MaPhieu varchar (50) NOT NULL UNIQUE,
	GiaTri float NOT NULL,
	NoiDung nvarchar(100),
	NgayBatDau datetime,
	NgayKetThuc datetime,
    KieuTinh bit NOT NULL, -- 0 là tr trực tiếp, 1 là trừ theo %
    TrangThai bit Default(0) -- 0 là chưa sử dụng, 1 là đã sử dụng
)
GO

CREATE TABLE LoaiDichVu
(
	MaLoaiDichVu varchar (5) PRIMARY KEY NOT NULL,
	TenLoaiDichVu nvarchar (50)
)
GO

CREATE TABLE LoaiPhong
(
	MaLoaiPhong Varchar (3) PRIMARY KEY NOT NULL,
	TenLoaiPhong nvarchar (50),
	DonGia Float,
	SoNguoiChuan int,
	SoNguoiToiDa int,
	TyLeTang float
)
GO

CREATE TABLE LoaiTinhTrang
(
	MaLoaiTinhTrangPhong int PRIMARY KEY IDENTITY(1,1),
	TenLoaiTinhTrang  nvarchar(50)
)
GO

CREATE TABLE PhieuNhanPhong
(
	MaNhanPhong varchar (5) PRIMARY KEY NOT NULL,
	MaPhieuThue varchar (10) NOT NULL,
	MaKhachHang varchar (3) NOT NULL,
	TrangThai bit Default(0)
)
GO

CREATE TABLE PhieuThuePhong
(
	MaPhieuThue varchar (10) PRIMARY KEY NOT NULL,
	MaKhachHang varchar (3) NOT NULL,
	TrangThai bit Default(0)
)
GO

CREATE TABLE Phong
(
	MaPhong varchar (3) PRIMARY KEY NOT NULL,
	MaLoaiPhong varchar (3) NOT NULL,
	MaLoaiTinhTrangPhong int NOT NULL,
	GhiChu nvarchar (50)
)
GO

CREATE TABLE QuyDinh
(
	MaQuyDinh int PRIMARY KEY IDENTITY(1,1),
	TenQuyDinh nvarchar (50),
	MoTa nvarchar(MAX)
)
GO

CREATE TABLE DanhSachSuDungDichVu 
(
	MaSuDungDVu varchar (4) PRIMARY KEY NOT NULL,
	MaDichVu varchar (5) NOT NULL,
	MaNhanPhong varchar (5) NOT NULL,
	SoLuong int
)
GO

CREATE TABLE ChiTietPhieuThuePhong
(
	MaPhieuThue varchar (10) NOT NULL,
	MaPhong varchar (3) NOT NULL,
	NgayDangKy datetime,
	NgayNhan datetime,
	NgayTraDuKien datetime
	PRIMARY KEY(MaPhieuThue, MaPhong)
)
GO

CREATE TABLE ChiTietPhieuNhanPhong
(
	MaNhanPhong varchar (5) NOT NULL,
	MaPhong varchar (3) NOT NULL,
	HoTenKhachHang nvarchar (50),
	CMND nvarchar (15),
	NgayNhan datetime,
	NgayTraDuKien datetime,
	NgayTraThucTe datetime
	PRIMARY KEY(MaNhanPhong, MaPhong)
)
GO

CREATE TABLE ChiTietHoaDon
(
	MaHoaDon int NOT NULL,
	MaPhong  varchar (3) NOT NULL,
	MaSuDungDichVu varchar (4) NOT NULL,
	MaChinhSach varchar (5) NOT NULL,
	PhuThu float Default(0),
	TienPhong float Default(0),
	TienDichVu float Default(0),
	GiamGiaKH float Default(0),
	HinhThucThanhToan nvarchar(50),
	SoNgay int,
	ThanhTien float,
	PRIMARY KEY(MaHoaDon, MaPhong,MaSuDungDichVu, MaChinhSach)
)
GO


-- Khóa Ngoại Bảng Phong 
ALTER TABLE Phong
ADD FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong (MaLoaiPhong);
GO
ALTER TABLE Phong
ADD FOREIGN KEY (MaLoaiTinhTrangPhong) REFERENCES LoaiTinhTrang (MaLoaiTinhTrangPhong);
GO

-- Khóa Ngoại Bảng ThietBi 
ALTER TABLE ThietBi
ADD FOREIGN KEY (MaLoaiPhong) REFERENCES LoaiPhong (MaLoaiPhong);
GO


-- Khóa Ngoại Bảng HoaDon 
ALTER TABLE HoaDon 
ADD FOREIGN KEY (MaNhanPhong) REFERENCES PhieuNhanPhong (MaNhanPhong);
GO
ALTER TABLE HoaDon
ADD FOREIGN KEY (MaKhachHang) REFERENCES KhachHang (MaKhachHang);
GO

-- Khóa Ngoại Bảng DanhSachSuDungDichVu 
ALTER TABLE DanhSachSuDungDichVu
ADD FOREIGN KEY (MaNhanPhong) REFERENCES PhieuNhanPhong (MaNhanPhong);
GO
ALTER TABLE DanhSachSuDungDichVu
ADD FOREIGN KEY (MaDichVu) REFERENCES DichVu (MaDichVu);
GO

-- Khóa Ngoại Bảng ChiTietHoaDon 
ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaHoaDon) REFERENCES HoaDon (MaHoaDon);
GO
ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaChinhSach) REFERENCES ChinhSachTraPhong (MaChinhSach);
GO
ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaSuDungDichVu) REFERENCES DanhSachSuDungDichVu (MaSuDungDVu);
GO
ALTER TABLE ChiTietHoaDon
ADD FOREIGN KEY (MaPhong) REFERENCES Phong (MaPhong);
GO

-- Khóa Ngoại Bảng DichVu 
ALTER TABLE DichVu
ADD FOREIGN KEY (MaDonVi) REFERENCES DonVi (MaDonVi);
GO
ALTER TABLE DichVu
ADD FOREIGN KEY (MaLoaiDichVu) REFERENCES LoaiDichVu (MaLoaiDichVu);
GO

-- Khóa Ngoại Bảng ChiTietPhieuThuePhong 
ALTER TABLE ChiTietPhieuThuePhong
ADD FOREIGN KEY (MaPhieuThue) REFERENCES PhieuThuePhong (MaPhieuThue);
GO
ALTER TABLE ChiTietPhieuThuePhong 
ADD FOREIGN KEY (MaPhong) REFERENCES Phong (MaPhong);
GO

-- Khóa Ngoại Bảng PhieuThuePhong
ALTER TABLE PhieuThuePhong
ADD FOREIGN KEY (MaKhachHang) REFERENCES KhachHang (MaKhachHang);
GO
-- Khóa Ngoại Bảng PhieuNhanPhong 
ALTER TABLE PhieuNhanPhong 
ADD FOREIGN KEY (MaKhachHang) REFERENCES KhachHang (MaKhachHang);
GO
ALTER TABLE PhieuNhanPhong
ADD FOREIGN KEY (MaPhieuThue) REFERENCES PhieuThuePhong (MaPhieuThue);
GO

-- Khóa Ngoại Bảng ChiTietPhieuNhanPhong 
ALTER TABLE ChiTietPhieuNhanPhong 
ADD FOREIGN KEY (MaNhanPhong) REFERENCES PhieuNhanPhong (MaNhanPhong);
GO
ALTER TABLE ChiTietPhieuNhanPhong
ADD FOREIGN KEY (MaPhong) REFERENCES Phong (MaPhong);
GO
-- Khóa Ngoại Bảng KhuyenMai
ALTER TABLE HoaDon
ADD FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai (MaKhuyenMai);
GO


-- Khóa Ngoại Bảng PhanQuyen
ALTER TABLE PhanQuyen
ADD FOREIGN KEY (MaQuyen) REFERENCES Quyen (MaQuyen);
GO
ALTER TABLE PhanQuyen
ADD FOREIGN KEY (MaNhomQuyen) REFERENCES NhomQuyen (MaNhomQuyen);
GO

ALTER TABLE NguoiDung
ADD FOREIGN KEY (MaNhomQuyen) REFERENCES NhomQuyen (MaNhomQuyen);
GO
-- Khóa Ngoại Bảng NguoiDung
ALTER TABLE CauHinhNguoiDung
ADD FOREIGN KEY (MaNguoiDung) REFERENCES NguoiDung (MaNguoiDung);
GO
ALTER TABLE CauHinhNguoiDung 
ADD FOREIGN KEY (MaCauHinh) REFERENCES CauHinh (MaCauHinh);
GO

--         Thêm data vào bảng
--Bảng NhomQuyen
insert into NhomQuyen(TenNhomQuyen) Values
('Admin'),
(N'Nhân Viên')
GO

INSERT INTO QuyDinh(TenQuyDinh,MoTa) VALUES
(N'Quy định 1',N'Quý khách vui lòng xuất trình hộ chiếu hoặc chứng minh nhân dân để làm thủ tục nhận phòng tại Lễ tân.'),
(N'Quy định 2',N'Khách sạn chỉ chịu trách nhiệm với những tài sản hoặc tiền được gửi tại quầy Lễ tân.'),
(N'Quy định 3',N'Không mang súng đạn, chất cháy nổ, chất độc hại, các chất gây nghiện, vật nuôi hoặc thực phẩm có mùi tanh hôi vào phòng nghỉ. Không nấu nướng, giặt là trong phòng nghỉ.'),
(N'Quy định 4',N'Không thay đổi, di chuyển đồ đạc trong phòng hoặc từ phòng này sang phòng khác. Trường hợp tài sản, đồ dùng trong phòng bị mất, hỏng do chủ quan Quý khách sẽ phải bồi thường 100% giá trị.'),
(N'Quy định 5',N'Xin vui lòng không thay đổi phòng hoặc đưa thêm người vào phòng khi chưa đăng ký trước với Lễ tân.'),
(N'Quy định 6',N'Nếu có người thân đến thăm, xin quý khách vui lòng liên hệ với Lễ tân để bổ trí nơi tiếp đón.'),
(N'Quy định 7',N'Khi ra khỏi phòng, Quý khách vui lòng rút thẻ chìa khoá ra khỏi ổ điện và gửi tại quầy lễ tân. Điện trong phòng sẽ tự động ngắt khi cửa đã được khép.'),
(N'Quy định 8',N'Nếu Quý khách phát hiện có hiện tượng cháy trong Khách sạn, xin khẩn trương tìm cách thông báo cho người ở khu vực gần nhất và bình tĩnh làm theo chỉ dẫn phòng chống cháy nổ.'),
(N'Quy định 9',N'Thời gian trả phòng là 12h30, nếu muộn hơn sẽ phải thanh toán thêm phụ phí tương ứng. Trong trường hợp cần thiết, xin vui lòng liên hệ với Lễ tân.'),
(N'Quy định 10',N'Trước khi rời khỏi khách sạn, xin Quý khách vui lòng thanh toán toàn bộ các hoá đơn và trả lại chìa khoá phòng cho Lễ tân.')
GO

INSERT INTO KhachHang(MaKhachHang,TenKhachHang,CMND,DiaChi,DienThoai,GioiTinh,QuocTich) VALUES 
('A1',N'Nguyễn Thị A', '871333',N'Hà Nội','099999999',0,N'Việt Nam'),
('A2',N'Tom', '77777777',N'LonDon','055557999',1,N'Anh'),
('A3',N'Nguyễn Văn B', '33555533',N'Ba Vì','09475989',1,N'Việt Nam'),
('A4',N'Trần Minh Anh', '333301333',N'Sơn La','099975449',1,N'Việt Nam'),
('A5',N'Hoàng Trung Dũng', '262433333',N'Yên Bái','09947599',1,N'Việt Nam'),
('A6',N'Phan Anh Minh', '12411333',N'Phú Thọ','03745922',1,N'Việt Nam'),
('A7',N'Lê Minh Hoàng', '45141333',N'Hồ Chí Minh','02554586',1,N'Việt Nam'),
('A8',N'Phan Lan Thanh', '89553333',N'Hà Nội','06276832',0,N'Việt Nam'),
('A9',N'Quýt', '4253333',N'Hà Nội','09958639',0,N'Việt Nam'),
('A10',N'Siro', '12533333',N'Lạng Sơn','0995328999',0,N'Việt Nam')
GO

INSERT INTO LoaiPhong(MaLoaiPhong,TenLoaiPhong,DonGia,SoNguoiChuan,SoNguoiToiDa,TyLeTang) VALUES
('B01',N'Thường Đơn',500000,1,2,1),
('B02',N'Thường Đôi',800000,2,3,1),
('B03',N'Vip Đơn',1500000,1,2,1),
('B04',N'Vip Đôi',5000000,2,2,1)
GO

Insert into ThietBi(MaThietBi,MaLoaiPhong,TenThietBi,SoLuong,Gia) Values
('TB01','B01',N'Tivi',1,50000000),
('TB02','B02',N'Tivi',2,100000000),
('TB03','B01',N'Giường',1,50000000),
('TB04','B02',N'Giường',2,100000000),
('TB05','B01',N'Tủ quần áo',1,10000000),
('TB06','B03',N'Tivi',1,50000000),
('TB07','B03',N'Giường',1,50000000),
('TB08','B04',N'Tivi',2,50000000),
('TB09','B02',N'Tủ quần áo',2,100000000),
('TB10','B04',N'Giường',2,100000000)
GO

INSERT INTO LoaiTinhTrang(TenLoaiTinhTrang) VALUES
(N'Trống'),
(N'Đã được thuê'),
(N'Có người ở'),
(N'Đang sửa chữa')
GO 

INSERT INTO KhuyenMai(MaPhieu,GiaTri,NoiDung,NgayBatDau,NgayKetThuc,KieuTinh,TrangThai) VALUES
('CTKM01',10,N'Khuyến mại 1','2020-12-20','2020-12-27',1,0),
('TRIANKHACHHANG',15,N'Tri ân khách hàng','2020-01-01','2020-01-15',1,0),
('HOLIDAY',350000,N'Khuyến mại 1','2021-01-05','2021-01-20',0,0),
('OK123',40,N'Khuyến mại 2','2020-12-20','2021-01-20',1,1),
('OCE',50,N'Khuyến mại 3','2020-12-25','2021-01-20',1,0)
GO

INSERT into Quyen(Quyen) VALUES 
('XemGiaoDich'),('QlDaoDich'),
('XemNguoiDung'),('QlNguoiDung'),
('XemPhong'),('QlPhong'),
('XemThietBi'),('QlThietBi'),
('XemDichVu'),('QlDichVu'),
('XemChinhSachTraPhong'),('QlChinhSachTraPhong'),
('XemKhachHang'),('QlKhachHang'),
('XemKhuyenMai'),('QlKhuyenMai'),
('XemQuyDinh'),('QlQuyDinh')
go

Insert into Phong(MaPhong,MaLoaiPhong,MaLoaiTinhTrangPhong,GhiChu) Values
('P01','B01',1,''),
('P02','B01',1,''),
('P03','B04',1,'ok'),
('P04','B01',1,''),
('P05','B02',1,''),
('P06','B01',1,''),
('P07','B02',1,''),
('P08','B01',1,''),
('P09','B03',1,''),
('P10','B04',1,''),
('P11','B04',1,''),
('P12','B01',4,''),
('P13','B02',1,''),
('P14','B01',1,'hihi'),
('P15','B01',1,''),
('P16','B03',1,''),
('P17','B04',1,''),
('P18','B01',1,'ok'),
('P19','B03',1,''),
('P20','B01',1,''),
('P21','B02',4,'ok')
GO

Insert into LoaiDichVu(MaLoaiDichVu,TenLoaiDichVu) Values
('LDV01',N'Dịch vụ Spa'),
('LDV02',N'Dịch vụ Casino'),
('LDV03',N'Sân golf và sân tennis'),
('LDV04',N'Dịch vụ giặt ủi quần áo'),
('LDV05',N'Dịch vụ bể bơi 4 mùa'),
('LDV06',N'Dịch vụ karaoke'),
('LDV07',N'Dịch vụ nhà hàng'),
('LDV08',N'Dịch vụ phòng 24/24'),
('LDV09',N'Dịch vụ xe đưa đón sân bay'),
('LDV10',N'Fitness centre')
GO

Insert into DonVi(MaDonVi,TenDonVi) Values
('DV1',N'Ngày'),
('DV2',N'Giờ'),
('DV3',N'Tháng'),
('DV4',N'Chiếc'),
('DV5',N'Kg'),
('DV6',N'Cái'),
('DV7',N'Hộp'),
('DV8',N'Phần'),
('DV9',N'Vé')
GO

Insert into DichVu(MaDichVu,MaLoaiDichVu,MaDonVi,DonGia) Values
('DV00','LDV08','DV3',0),
('DV01','LDV05','DV3',1500000),
('DV02','LDV01','DV3',3500000),
('DV03','LDV06','DV2',200000),
('DV04','LDV07','DV1',1200000),
('DV05','LDV08','DV1',200000),
('DV06','LDV02','DV9',0),
('DV07','LDV10','DV8',300000),
('DV08','LDV03','DV9',50000),
('DV09','LDV03','DV3',1350000),
('DV10','LDV09','DV9',0),
('DV11','LDV04','DV1',50000)
GO

  Insert into ChinhSachTraPhong(MaChinhSach,NoiDung,PhuThu) values
  ('CS1',N'Phụ thu trả phòng trước 12h đến 13h',0.0),
  ('CS2',N'Phụ thu trả phòng từ 13h đến 15h',20.0),
  ('CS3',N'Phụ thu trả phòng từ 15h đến 17h',40.0),
  ('CS4',N'Phụ thu trả phòng từ 17h đến 19h',50.0),
  ('CS5',N'Phụ thu trả phòng sau 19h',100.0)
  GO

--  TẠO THỦ TỤC

-- BẢNG QuyDinh
CREATE PROC getAllQuyDinh
AS
BEGIN 
SELECT * FROM QuyDinh
END
GO

CREATE PROC SearchQuyDinh
@TenQuyDinh nvarchar (50)
AS
BEGIN 
SELECT * FROM QuyDinh Where TenQuyDinh LIKE '%'+@TenQuyDinh+'%'
END
GO

CREATE PROC insertQuyDinh
@TenQuyDinh nvarchar (50),
@MoTa nvarchar(MAX)
AS
BEGIN 
Insert into QuyDinh(TenQuyDinh,MoTa) Values(@TenQuyDinh,@MoTa)
END
GO

CREATE PROC updateQuyDinh
@TenQuyDinh nvarchar (50),
@MoTa nvarchar(MAX),
@MaQuyDinh int
AS
BEGIN 
Update QuyDinh set TenQuyDinh = @TenQuyDinh, MoTa = @MoTa Where MaQuyDinh = @MaQuyDinh
END
GO

CREATE PROC deleteQuyDinh
@MaQuyDinh int
AS
BEGIN 
DELETE QuyDinh Where MaQuyDinh = @MaQuyDinh
END
GO


-- BẢNG CauHinh
CREATE PROC getAllCauHinh
AS
BEGIN 
SELECT * FROM CauHinh ORDER BY MaCauHinh DESC
END
GO

CREATE PROC SearchCauHinh
@LoaiCauHinh nvarchar (50)
AS
BEGIN 
SELECT * FROM CauHinh Where LoaiCauHinh LIKE '%'+@LoaiCauHinh+'%'
ORDER BY MaCauHinh DESC
END
GO

CREATE PROC insertCauHinh
@LoaiCauHinh nvarchar (50)
AS
BEGIN 
Insert into CauHinh(LoaiCauHinh) Values(@LoaiCauHinh)
END
GO

CREATE PROC updateCauHinh
@LoaiCauHinh nvarchar (50),
@MaCauHinh int
AS
BEGIN 
Update CauHinh set LoaiCauHinh = @LoaiCauHinh Where MaCauHinh = @MaCauHinh
END
GO

CREATE PROC deleteCauHinh
@MaCauHinh int
AS
BEGIN 
DELETE CauHinh Where MaCauHinh = @MaCauHinh
END
GO



-- BẢNG Quyen
CREATE PROC getAllQuyen
AS
BEGIN 
SELECT * FROM Quyen ORDER BY MaQuyen DESC
END
GO

CREATE PROC SearchQuyen
@Quyen nvarchar (50)
AS
BEGIN 
SELECT * FROM Quyen Where Quyen LIKE '%'+@Quyen+'%'
ORDER BY MaQuyen DESC
END
GO

CREATE PROC insertQuyen
@Quyen nvarchar (50)
AS
BEGIN 
Insert into Quyen(Quyen) Values(@Quyen)
END
GO

CREATE PROC updateQuyen
@Quyen nvarchar (50),
@MaQuyen int
AS
BEGIN 
Update Quyen set Quyen = @Quyen Where MaQuyen = @MaQuyen
END
GO

CREATE PROC deleteQuyen
@MaQuyen int
AS
BEGIN 
DELETE Quyen Where MaQuyen = @MaQuyen
END
GO


-- BẢNG NguoiDung
CREATE PROC getAllNguoiDung
AS
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END
GO

CREATE PROC SearchNguoiDung
@TenNguoiDung nvarchar (50),
@Email varchar (50),
@MaNhomQuyen int
AS
IF @TenNguoiDung != '' AND @Email != '' AND @MaNhomQuyen != 0 
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where TenNguoiDung LIKE '%'+@TenNguoiDung+'%' AND Email = @Email AND NguoiDung.MaNhomQuyen =@MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END

ELSE IF @TenNguoiDung = '' AND @Email = '' AND @MaNhomQuyen  = 0
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END

 ELSE IF @TenNguoiDung  = '' AND @Email != '' AND @MaNhomQuyen != 0
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where Email = @Email AND NguoiDung.MaNhomQuyen =@MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END

 ELSE IF @TenNguoiDung  = '' AND @Email = '' AND @MaNhomQuyen != 0
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where NguoiDung.MaNhomQuyen =@MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END

 ELSE IF @TenNguoiDung  = '' AND @Email != '' AND @MaNhomQuyen  = 0
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where Email = @Email
 ORDER BY NguoiDung.MaNguoiDung ASC
END

IF @TenNguoiDung != '' AND @Email != '' AND @MaNhomQuyen  = 0 
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where TenNguoiDung LIKE '%'+@TenNguoiDung+'%' AND Email = @Email
 ORDER BY NguoiDung.MaNguoiDung ASC
END

IF @TenNguoiDung != '' AND @Email  = '' AND @MaNhomQuyen != 0 
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where TenNguoiDung LIKE '%'+@TenNguoiDung+'%' AND NguoiDung.MaNhomQuyen =@MaNhomQuyen
 ORDER BY NguoiDung.MaNguoiDung ASC
END

IF @TenNguoiDung != '' AND @Email  = '' AND @MaNhomQuyen  = 0
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where TenNguoiDung LIKE '%'+@TenNguoiDung+'%'
 ORDER BY NguoiDung.MaNguoiDung ASC
END

GO 

CREATE PROC getNguoiDungById
@MaNguoiDung int
AS
BEGIN 
 SELECT NguoiDung.MaNguoiDung,NguoiDung.TenNguoiDung,NguoiDung.TenDangNhap,NguoiDung.MatKhau,
 NguoiDung.Anh,NguoiDung.Email,NguoiDung.NgaySinh,NguoiDung.GioiTinh,NguoiDung.MaNhomQuyen,NhomQuyen.TenNhomQuyen
 FROM NguoiDung 
 INNER JOIN NhomQuyen ON NguoiDung.MaNhomQuyen = NhomQuyen.MaNhomQuyen
 Where MaNguoiDung = @MaNguoiDung
END
GO

CREATE PROC checkLoginNguoiDung
@TenDangNhap varchar (50),
@MatKhau nvarchar (50)
AS
BEGIN 
SELECT * FROM NguoiDung Where (TenDangNhap = @TenDangNhap OR Email = @TenDangNhap) AND MatKhau = @MatKhau
END
GO

CREATE PROC checkEmailNguoiDung
@Email nvarchar (50)
AS
BEGIN 
SELECT * FROM NguoiDung Where Email = @Email
END
GO

CREATE PROC checkTenDangNhapNguoiDung
@TenDangNhap varchar (50)
AS
BEGIN 
SELECT * FROM NguoiDung Where TenDangNhap = @TenDangNhap
END
GO



CREATE PROC updateNguoiDung
@MaNguoiDung int,
@TenNguoiDung nvarchar (50),
@TenDangNhap varchar (50),
@MatKhau nvarchar (50),
@Anh image,
@Email varchar (50),
@NgaySinh datetime,
@GioiTinh bit,
@MaNhomQuyen int
AS
BEGIN 
Update NguoiDung set TenNguoiDung = @TenNguoiDung, TenDangNhap =@TenDangNhap,MatKhau=@MatKhau,Anh=@Anh,Email=@Email,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh, MaNhomQuyen = @MaNhomQuyen Where MaNguoiDung = @MaNguoiDung
END
GO

CREATE PROC updatePassword
@MaNguoiDung int,
@MatKhau nvarchar (50)
AS
BEGIN 
Update NguoiDung set MatKhau=@MatKhau Where MaNguoiDung = @MaNguoiDung
END
GO

CREATE PROC deleteNguoiDung
@MaNguoiDung int
AS
BEGIN TRY
    BEGIN TRANSACTION
DELETE CauHinhNguoiDung WHERE MaNguoiDung = @MaNguoiDung
DELETE NguoiDung Where MaNguoiDung = @MaNguoiDung
COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION
END CATCH
GO


-- BẢNG KhachHang
CREATE PROC getAllKhachHang
AS
BEGIN 
SELECT * FROM KhachHang ORDER BY MaKhachHang DESC
END
GO

CREATE PROC getKhachHangByMa
@MaKhachHang varchar (3)
AS
BEGIN 
SELECT * FROM KhachHang Where MaKhachHang = @MaKhachHang
END
GO

CREATE PROC SearchKhachHang_NoGioiTinh
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai varchar (15),
@QuocTich nvarchar(50)
AS
BEGIN 
SELECT * FROM KhachHang Where MaKhachHang LIKE '%'+@MaKhachHang+'%' AND TenKhachHang LIKE '%'+@TenKhachHang+'%' 
AND CMND LIKE '%'+@CMND+'%' AND DiaChi LIKE '%'+@DiaChi+'%' AND DienThoai LIKE '%'+@DienThoai+'%' AND QuocTich LIKE '%'+@QuocTich+'%'
END
GO

CREATE PROC SearchKhachHang_YesGioiTinh
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai varchar (15),
@GioiTinh bit,
@QuocTich nvarchar(50)
AS
BEGIN 
SELECT * FROM KhachHang Where MaKhachHang LIKE '%'+@MaKhachHang+'%' AND TenKhachHang LIKE '%'+@TenKhachHang+'%' 
AND CMND LIKE '%'+@CMND+'%' AND DiaChi LIKE '%'+@DiaChi+'%' AND DienThoai LIKE '%'+@DienThoai+'%' 
AND GioiTinh = @GioiTinh AND QuocTich LIKE '%'+@QuocTich+'%'
END
GO

CREATE PROC insertKhachHang
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai varchar (15),
@GioiTinh bit,
@QuocTich nvarchar(50)
AS
BEGIN 
Insert into KhachHang(MaKhachHang,TenKhachHang,CMND,DiaChi,DienThoai,GioiTinh,QuocTich) Values(@MaKhachHang,@TenKhachHang,@CMND,@DiaChi,@DienThoai,@GioiTinh,@QuocTich)
END
GO

CREATE PROC updateKhachHang
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai varchar (15),
@GioiTinh bit,
@QuocTich nvarchar(50)
AS
BEGIN 
Update KhachHang set  TenKhachHang=@TenKhachHang, CMND=@CMND, DiaChi=@DiaChi, DienThoai=@DienThoai, GioiTinh=@GioiTinh, QuocTich=@QuocTich Where MaKhachHang = @MaKhachHang
END
GO

CREATE PROC deleteKhachHang
@MaKhachHang varchar (3)
AS
BEGIN 
DELETE KhachHang Where MaKhachHang = @MaKhachHang
END
GO


-- BẢNG ThietBi
CREATE PROC getAllThietBi
AS
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
END
GO

CREATE PROC getThietBiByMaTB
@MaThietBi varchar (8)
AS
BEGIN 
SELECT * FROM ThietBi Where MaThietBi = @MaThietBi
END
GO

CREATE PROC SearchThietBi
@MaThietBi varchar (8),
@MaLoaiPhong varchar (3),
@TenThietBi nvarchar (50)
AS

IF @MaThietBi != '' AND @MaLoaiPhong != '' AND @TenThietBi != '' 
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where MaThietBi = @MaThietBi OR ThietBi.MaLoaiPhong =@MaLoaiPhong OR TenThietBi LIKE '%'+@TenThietBi+'%'
END

ELSE IF @MaThietBi = '' AND @MaLoaiPhong = '' AND @TenThietBi  = ''
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 END

 ELSE IF @MaThietBi  = '' AND @MaLoaiPhong != '' AND @TenThietBi != ''
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where ThietBi.MaLoaiPhong =@MaLoaiPhong OR TenThietBi LIKE '%'+@TenThietBi+'%'
END

 ELSE IF @MaThietBi  = '' AND @MaLoaiPhong = '' AND @TenThietBi != ''
 BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where TenThietBi LIKE '%'+@TenThietBi+'%'
END

 ELSE IF @MaThietBi  = '' AND @MaLoaiPhong != '' AND @TenThietBi  = ''
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where ThietBi.MaLoaiPhong =@MaLoaiPhong
END

IF @MaThietBi != '' AND @MaLoaiPhong != '' AND @TenThietBi  = '' 
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where MaThietBi = @MaThietBi OR ThietBi.MaLoaiPhong =@MaLoaiPhong
END

IF @MaThietBi != '' AND @MaLoaiPhong  = '' AND @TenThietBi != '' 
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where MaThietBi = @MaThietBi OR TenThietBi LIKE '%'+@TenThietBi+'%'
END

IF @MaThietBi != '' AND @MaLoaiPhong  = '' AND @TenThietBi  = '' 
BEGIN 
SELECT ThietBi.MaThietBi, ThietBi.MaLoaiPhong, ThietBi.TenThietBi,ThietBi.SoLuong,ThietBi.Gia,LoaiPhong.TenLoaiPhong
 FROM ThietBi
 INNER JOIN LoaiPhong
 ON ThietBi.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 Where MaThietBi = @MaThietBi
END

GO 

CREATE PROC insertThietBi
@MaThietBi varchar (8),
@MaLoaiPhong varchar (3),
@TenThietBi nvarchar (50),
@SoLuong int,
@Gia float
AS
BEGIN 
Insert into ThietBi(MaThietBi,MaLoaiPhong,TenThietBi,SoLuong,Gia) Values(@MaThietBi,@MaLoaiPhong,@TenThietBi,@SoLuong,@Gia)
END
GO

CREATE PROC updateThietBi
@MaThietBi varchar (8),
@MaLoaiPhong varchar (3),
@TenThietBi nvarchar (50),
@SoLuong int,
@Gia float
AS
BEGIN 
Update ThietBi set  MaLoaiPhong=@MaLoaiPhong, TenThietBi=@TenThietBi, SoLuong=@SoLuong, Gia=@Gia Where MaThietBi = @MaThietBi
END
GO

CREATE PROC deleteThietBi
@MaThietBi varchar (8)
AS
BEGIN 
DELETE ThietBi Where MaThietBi = @MaThietBi
END
GO


-- BẢNG DonVi
CREATE PROC getAllDonVi
AS
BEGIN 
SELECT * FROM DonVi
END
GO

CREATE PROC getDonViByMa
@MaDonVi varchar (3)
AS
BEGIN 
SELECT * FROM DonVi Where MaDonVi = @MaDonVi
END
GO

CREATE PROC SearchDonVi
@MaDonVi varchar (3),
@TenDonVi nvarchar (50)
AS
BEGIN 
SELECT * FROM DonVi Where MaDonVi LIKE '%'+@MaDonVi+'%' AND TenDonVi LIKE '%'+@TenDonVi+'%' 
END
GO

CREATE PROC insertDonVi
@MaDonVi varchar (3),
@TenDonVi nvarchar (50)
AS
BEGIN 
Insert into DonVi(MaDonVi,TenDonVi) Values(@MaDonVi,@TenDonVi)
END
GO

CREATE PROC updateDonVi
@MaDonVi varchar (3),
@TenDonVi nvarchar (50)
AS
BEGIN 
Update DonVi set TenDonVi = @TenDonVi Where MaDonVi = @MaDonVi
END
GO

CREATE PROC deleteDonVi
@MaDonVi varchar (3)
AS
BEGIN 
DELETE DonVi Where MaDonVi = @MaDonVi
END
GO

-- BẢNG ChinhSachTraPhong
CREATE PROC getAllChinhSachTraPhong
AS
BEGIN 
SELECT * FROM ChinhSachTraPhong
END
GO

CREATE PROC getChinhSachTraPhongByMa
@MaChinhSach varchar (5)
AS
BEGIN 
SELECT * FROM ChinhSachTraPhong Where MaChinhSach = @MaChinhSach
END
GO

CREATE PROC SearchChinhSachTraPhong
@MaChinhSach varchar (5),
@NoiDung nvarchar (50)
AS
BEGIN 
SELECT * FROM ChinhSachTraPhong Where MaChinhSach LIKE '%'+@MaChinhSach+'%' AND NoiDung LIKE '%'+@NoiDung+'%' 
END
GO

CREATE PROC insertChinhSachTraPhong
@MaChinhSach varchar (5),
@NoiDung nvarchar (50),
@PhuThu float
AS
BEGIN 
Insert into ChinhSachTraPhong(MaChinhSach,NoiDung,PhuThu) Values(@MaChinhSach,@NoiDung,@PhuThu)
END
GO

CREATE PROC updateChinhSachTraPhong
@MaChinhSach varchar (5),
@NoiDung nvarchar (50),
@PhuThu float
AS
BEGIN 
Update ChinhSachTraPhong set NoiDung = @NoiDung, PhuThu=@PhuThu Where MaChinhSach = @MaChinhSach
END
GO

CREATE PROC deleteChinhSachTraPhong
@MaChinhSach varchar (5)
AS
BEGIN 
DELETE ChinhSachTraPhong Where MaChinhSach = @MaChinhSach
END
GO

-- BẢNG DichVu
CREATE PROC getAllDichVu
AS
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 ORDER BY DichVu.MaDichVu ASC
END
GO

CREATE PROC getDichVuByMa
@MaDichVu varchar (5)
AS
BEGIN 
SELECT * FROM DichVu Where MaDichVu = @MaDichVu
END
GO

CREATE PROC SearchDichVu
@MaDichVu varchar (5),
@MaLoaiDichVu varchar (5),
@MaDonVi varchar (3)
AS
IF @MaDichVu != '' AND @MaLoaiDichVu != '' AND @MaDonVi != '' 
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where MaDichVu =@MaDichVu AND DichVu.MaLoaiDichVu =@MaLoaiDichVu AND DichVu.MaDonVi = @MaDonVi
 ORDER BY DichVu.MaDichVu ASC
END

ELSE IF @MaDichVu = '' AND @MaLoaiDichVu = '' AND @MaDonVi  = ''
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 ORDER BY DichVu.MaDichVu ASC
END

 ELSE IF @MaDichVu  = '' AND @MaLoaiDichVu != '' AND @MaDonVi != ''
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where DichVu.MaLoaiDichVu =@MaLoaiDichVu AND DichVu.MaDonVi = @MaDonVi
 ORDER BY DichVu.MaDichVu ASC
END

 ELSE IF @MaDichVu  = '' AND @MaLoaiDichVu = '' AND @MaDonVi != ''
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where DichVu.MaDonVi = @MaDonVi
 ORDER BY DichVu.MaDichVu ASC
END

 ELSE IF @MaDichVu  = '' AND @MaLoaiDichVu != '' AND @MaDonVi  = ''
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where DichVu.MaLoaiDichVu =@MaLoaiDichVu
 ORDER BY DichVu.MaDichVu ASC
END

IF @MaDichVu != '' AND @MaLoaiDichVu != '' AND @MaDonVi  = '' 
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where MaDichVu =@MaDichVu AND DichVu.MaLoaiDichVu =@MaLoaiDichVu
 ORDER BY DichVu.MaDichVu ASC
END

IF @MaDichVu != '' AND @MaLoaiDichVu  = '' AND @MaDonVi != '' 
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where MaDichVu =@MaDichVu AND DichVu.MaDonVi = @MaDonVi 
 ORDER BY DichVu.MaDichVu ASC
END

IF @MaDichVu != '' AND @MaLoaiDichVu  = '' AND @MaDonVi  = '' 
BEGIN 
 SELECT DichVu.MaDichVu, DichVu.MaLoaiDichVu, DichVu.MaDonVi,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi, DichVu.DonGia
 FROM DichVu 
 INNER JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
 INNER JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 Where MaDichVu =@MaDichVu 
 ORDER BY DichVu.MaDichVu ASC
END

GO 

CREATE PROC insertDichVu
@MaDichVu varchar (5),
@MaLoaiDichVu varchar (5),
@MaDonVi varchar (3),
@DonGia float
AS
BEGIN 
Insert into DichVu(MaDichVu,MaLoaiDichVu,MaDonVi,DonGia) Values(@MaDichVu,@MaLoaiDichVu,@MaDonVi,@DonGia)
END
GO

CREATE PROC updateDichVu
@MaDichVu varchar (5),
@MaLoaiDichVu varchar (5),
@MaDonVi varchar (3),
@DonGia float
AS
BEGIN 
Update DichVu set MaLoaiDichVu = @MaLoaiDichVu, MaDonVi=@MaDonVi, DonGia = @DonGia Where MaDichVu = @MaDichVu
END
GO

CREATE PROC deleteDichVu
@MaDichVu varchar (5)
AS
BEGIN 
DELETE DichVu Where MaDichVu = @MaDichVu
END
GO

-- BẢNG LoaiDichVu
CREATE PROC getAllLoaiDichVu
AS
BEGIN 
SELECT * FROM LoaiDichVu
END
GO

CREATE PROC getLoaiDichVuByMa
@MaLoaiDichVu varchar (5)
AS
BEGIN 
SELECT * FROM LoaiDichVu Where MaLoaiDichVu = @MaLoaiDichVu
END
GO

CREATE PROC SearchLoaiDichVu
@MaLoaiDichVu varchar (5),
@TenLoaiDichVu nvarchar (50)
AS
BEGIN 
SELECT * FROM LoaiDichVu Where TenLoaiDichVu LIKE '%'+@TenLoaiDichVu+'%' AND MaLoaiDichVu LIKE '%'+@MaLoaiDichVu+'%'
END
GO

CREATE PROC insertLoaiDichVu
@MaLoaiDichVu varchar (5),
@TenLoaiDichVu nvarchar (50)
AS
BEGIN 
Insert into LoaiDichVu(MaLoaiDichVu,TenLoaiDichVu) Values(@MaLoaiDichVu,@TenLoaiDichVu)
END
GO

CREATE PROC updateLoaiDichVu
@MaLoaiDichVu varchar (5),
@TenLoaiDichVu nvarchar (50)
AS
BEGIN 
Update LoaiDichVu set TenLoaiDichVu = @TenLoaiDichVu Where MaLoaiDichVu = @MaLoaiDichVu
END
GO

CREATE PROC deleteLoaiDichVu
@MaLoaiDichVu varchar (5)
AS
BEGIN 
DELETE LoaiDichVu Where MaLoaiDichVu = @MaLoaiDichVu
END
GO

-- BẢNG LoaiPhong
CREATE PROC getAllLoaiPhong
AS
BEGIN 
SELECT * FROM LoaiPhong
END
GO

CREATE PROC getLoaiPhongByMa
@MaLoaiPhong Varchar (3)
AS
BEGIN 
SELECT * FROM LoaiPhong Where MaLoaiPhong = @MaLoaiPhong
END
GO

CREATE PROC SearchLoaiPhong
@MaLoaiPhong Varchar (3),
@TenLoaiPhong nvarchar (50)
AS
BEGIN 
SELECT * FROM LoaiPhong Where MaLoaiPhong  LIKE '%'+@MaLoaiPhong +'%' AND TenLoaiPhong LIKE '%'+@TenLoaiPhong+'%'
END
GO

CREATE PROC insertLoaiPhong
@MaLoaiPhong Varchar (3),
@TenLoaiPhong nvarchar (50),
@DonGia Float,
@SoNguoiChuan int,
@SoNguoiToiDa int,
@TyLeTang float
AS
BEGIN 
Insert into LoaiPhong(MaLoaiPhong,TenLoaiPhong,DonGia,SoNguoiChuan,SoNguoiToiDa,TyLeTang) Values(@MaLoaiPhong,@TenLoaiPhong,@DonGia,@SoNguoiChuan,@SoNguoiToiDa,@TyLeTang)
END
GO

CREATE PROC updateLoaiPhong
@MaLoaiPhong Varchar (3),
@TenLoaiPhong nvarchar (50),
@DonGia Float,
@SoNguoiChuan int,
@SoNguoiToiDa int,
@TyLeTang float
AS
BEGIN 
Update LoaiPhong set TenLoaiPhong = @TenLoaiPhong, DonGia=@DonGia, SoNguoiChuan=@SoNguoiChuan, SoNguoiToiDa=@SoNguoiToiDa, TyLeTang=@TyLeTang Where MaLoaiPhong = @MaLoaiPhong
END
GO

CREATE PROC deleteLoaiPhong
@MaLoaiPhong Varchar (3)
AS
BEGIN 
DELETE LoaiPhong Where MaLoaiPhong = @MaLoaiPhong
END
GO


-- BẢNG PhanQuyen
CREATE PROC getAllPhanQuyen
AS
BEGIN 
SELECT * FROM PhanQuyen
END
GO

CREATE PROC insertPhanQuyen
@MaQuyen int,
@MaNhomQuyen int
AS
BEGIN 
Insert into PhanQuyen(MaQuyen,MaNhomQuyen) Values(@MaQuyen,@MaNhomQuyen)
END
GO


-- BẢNG NhomQuyen
CREATE PROC getAllNhomQuyen
AS
BEGIN 
SELECT * FROM NhomQuyen
END
GO

CREATE PROC getNhomQuyenByName
@TenNhomQuyen nvarchar (50)
AS
BEGIN 
SELECT * FROM NhomQuyen Where TenNhomQuyen = @TenNhomQuyen
END
GO

CREATE PROC getMaxId
AS
BEGIN
SELECT * FROM NhomQuyen Where MaNhomQuyen = (SELECT MAX(MaNhomQuyen) FROM NhomQuyen);
END
go

CREATE PROC getQuyenByMaNhomQuyen
@MaNhomQuyen int
AS
BEGIN 
SELECT PhanQuyen.MaNhomQuyen ,PhanQuyen.MaQuyen, Quyen.Quyen FROM PhanQuyen JOIN Quyen
on PhanQuyen.MaQuyen = Quyen.MaQuyen
where PhanQuyen.MaNhomQuyen = @MaNhomQuyen

END
GO

CREATE PROC SearchNhomQuyen
@TenNhomQuyen nvarchar (50)
AS
BEGIN 
SELECT * FROM NhomQuyen Where TenNhomQuyen LIKE '%'+@TenNhomQuyen+'%'
END
GO

CREATE PROC insertNhomQuyen
@TenNhomQuyen nvarchar (50)
AS
BEGIN 
Insert into NhomQuyen(TenNhomQuyen) Values(@TenNhomQuyen)
END
GO

CREATE PROC updateNhomQuyen
@MaNhomQuyen int,
@TenNhomQuyen nvarchar (50)
AS
BEGIN 
Update NhomQuyen set TenNhomQuyen = @TenNhomQuyen Where MaNhomQuyen = @MaNhomQuyen
END
GO

CREATE PROC deleteNhomQuyen
@MaNhomQuyen int
AS
BEGIN TRY
    BEGIN TRANSACTION
        DELETE PhanQuyen Where MaNhomQuyen = @MaNhomQuyen
        DELETE NhomQuyen Where MaNhomQuyen = @MaNhomQuyen
        -- some other codes
        COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION
END CATCH
GO

CREATE PROC deletePhanQuyen
@MaNhomQuyen int
as
BEGIN
DELETE FROM PhanQuyen WHERE MaNhomQuyen = @MaNhomQuyen
END
GO

-- BẢNG CauHinhNguoiDung
CREATE PROC getAllCauHinhNguoiDung
AS
BEGIN 
SELECT * FROM CauHinhNguoiDung
END
GO

CREATE PROC insertCauHinhNguoiDung
@MaCauHinh int,
@MaNguoiDung int,
@NoiDungCauHinh nvarchar (50)
AS
BEGIN 
Insert into CauHinhNguoiDung(MaCauHinh,MaNguoiDung,NoiDungCauHinh) Values(@MaCauHinh,@MaNguoiDung,@NoiDungCauHinh)
END
GO

-- BẢNG HoaDon
CREATE PROC getAllHoaDon
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang ORDER BY NgayLap
END
GO

CREATE PROC getHoaDonIdMAX
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang Where MaHoaDon = (SELECT MAX(MaHoaDon) FROM HoaDon)
END
GO

CREATE PROC getByMaHoaDon
@MaHoaDon int
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang Where MaHoaDon = @MaHoaDon
END
GO

CREATE PROC getByMaKhachHang
@MaKhachHang varchar (3)
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang Where HoaDon.MaKhachHang = @MaKhachHang
END
GO

CREATE PROC getByMaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang Where MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC SearchHoaDon
@TenKhachHang varchar (5)
AS
BEGIN 
SELECT HoaDon.MaHoaDon,HoaDon.MaKhachHang,HoaDon.MaNhanPhong,HoaDon.MaKhuyenMai,HoaDon.NhanVienLap,HoaDon.TongTien,HoaDon.NgayLap,KhachHang.TenKhachHang
 FROM HoaDon JOIN KhachHang ON HoaDon.MaKhachHang = KhachHang.MaKhachHang
Where KhachHang.TenKhachHang LIKE '%'+@TenKhachHang+'%'
END
GO

CREATE PROC insertHoaDon
@MaKhachHang varchar (3),
@MaNhanPhong varchar (5),
@MaKhuyenMai int,
@NhanVienLap nvarchar (50),
@TongTien float,
@NgayLap datetime
AS
BEGIN 
Insert into HoaDon(MaKhachHang,MaNhanPhong,MaKhuyenMai,NhanVienLap,TongTien,NgayLap) Values(@MaKhachHang,@MaNhanPhong,@MaKhuyenMai,@NhanVienLap,@TongTien,@NgayLap)
END
GO

CREATE PROC insertHoaDon_NoKM
@MaKhachHang varchar (3),
@MaNhanPhong varchar (5),
@NhanVienLap nvarchar (50),
@TongTien float,
@NgayLap datetime
AS
BEGIN 
Insert into HoaDon(MaKhachHang,MaNhanPhong,NhanVienLap,TongTien,NgayLap) Values(@MaKhachHang,@MaNhanPhong,@NhanVienLap,@TongTien,@NgayLap)
END
GO

CREATE PROC deleteHoaDon
@MaHoaDon int
AS
BEGIN 
DELETE HoaDon Where MaHoaDon = @MaHoaDon
END
GO

-- BẢNG KhuyenMai
CREATE PROC getAllKhuyenMai
AS
BEGIN 
SELECT * FROM KhuyenMai ORDER BY MaKhuyenMai DESC
END
GO

CREATE PROC getByMaKhuyenMai
@MaKhuyenMai int
AS
BEGIN 
SELECT * FROM KhuyenMai WHERE MaKhuyenMai = @MaKhuyenMai ORDER BY MaKhuyenMai DESC
END
GO

CREATE PROC getByMaPhieuKhuyenMai
@MaPhieu varchar (50)
AS
BEGIN 
SELECT * FROM KhuyenMai WHERE MaPhieu = @MaPhieu
END
GO

CREATE PROC SearchKhuyenMai_NoTrangThai
@MaPhieu varchar (50),
@NoiDung nvarchar(100)
AS
BEGIN 
SELECT * FROM KhuyenMai 
Where MaPhieu LIKE '%'+@MaPhieu+'%'
AND NoiDung LIKE '%'+@NoiDung+'%'
ORDER BY MaKhuyenMai DESC
END
GO

CREATE PROC SearchKhuyenMai_YesTrangThai
@MaPhieu varchar (50),
@NoiDung nvarchar(100),
@TrangThai bit
AS
BEGIN 
SELECT * FROM KhuyenMai 
Where MaPhieu LIKE '%'+@MaPhieu+'%'
AND NoiDung LIKE '%'+@NoiDung+'%' AND TrangThai =@TrangThai
ORDER BY MaKhuyenMai DESC
END
GO

CREATE PROC kiemTraHieuLucKM
@MaPhieu varchar (50),
@dateInput datetime
AS
BEGIN 
SELECT * FROM KhuyenMai
WHERE MaPhieu = @MaPhieu AND @dateInput BETWEEN NgayBatDau AND NgayKetThuc 
END
GO

CREATE PROC updateTrangThaiKhuyenMai
@MaPhieu varchar (50)
AS
BEGIN 
Update KhuyenMai set TrangThai= 1 Where MaPhieu = @MaPhieu
END
GO

CREATE PROC insertKhuyenMai
@MaPhieu varchar (50),
@GiaTri float,
@NoiDung nvarchar(100),
@NgayBatDau datetime,
@NgayKetThuc datetime,
@KieuTinh bit,
@TrangThai bit
AS
BEGIN 
Insert into KhuyenMai(MaPhieu,GiaTri,NoiDung,NgayBatDau,NgayKetThuc,KieuTinh,TrangThai) Values(@MaPhieu,@GiaTri,@NoiDung,@NgayBatDau,@NgayKetThuc,@KieuTinh,@TrangThai)
END
GO

CREATE PROC updateKhuyenMai
@MaKhuyenMai int,
@MaPhieu varchar (50),
@GiaTri float,
@NoiDung nvarchar(100),
@NgayBatDau datetime,
@NgayKetThuc datetime,
@KieuTinh bit,
@TrangThai bit
AS
BEGIN 
Update KhuyenMai set MaPhieu = @MaPhieu,GiaTri=@GiaTri, NoiDung=@NoiDung,NgayBatDau=@NgayBatDau,NgayKetThuc=@NgayKetThuc,KieuTinh=@KieuTinh,TrangThai=@TrangThai Where MaKhuyenMai = @MaKhuyenMai
END
GO

CREATE PROC deleteKhuyenMai
@MaKhuyenMai int
AS
BEGIN 
DELETE KhuyenMai Where MaKhuyenMai = @MaKhuyenMai
END
GO

-- BẢNG LoaiTinhTrang
CREATE PROC getAllLoaiTinhTrang
AS
BEGIN 
SELECT * FROM LoaiTinhTrang ORDER BY MaLoaiTinhTrangPhong DESC
END
GO

CREATE PROC getByMaLoaiTinhTrang
@MaLoaiTinhTrangPhong int
AS
BEGIN 
SELECT * FROM LoaiTinhTrang WHERE MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong 
ORDER BY MaLoaiTinhTrangPhong DESC
END
GO

CREATE PROC SearchLoaiTinhTrang
@TenLoaiTinhTrang  nvarchar(50)
AS
BEGIN 
SELECT * FROM LoaiTinhTrang 
Where TenLoaiTinhTrang LIKE '%'+@TenLoaiTinhTrang+'%'
ORDER BY MaLoaiTinhTrangPhong DESC
END
GO

CREATE PROC insertLoaiTinhTrang
@TenLoaiTinhTrang  nvarchar(50)
AS
BEGIN 
Insert into LoaiTinhTrang(TenLoaiTinhTrang) Values(@TenLoaiTinhTrang)
END
GO

CREATE PROC updateLoaiTinhTrang
@MaLoaiTinhTrangPhong int,
@TenLoaiTinhTrang  nvarchar(50)
AS
BEGIN 
Update LoaiTinhTrang set TenLoaiTinhTrang = @TenLoaiTinhTrang Where MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong
END
GO

CREATE PROC deleteLoaiTinhTrang
@MaLoaiTinhTrangPhong int
AS
BEGIN 
DELETE LoaiTinhTrang Where MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong
END
GO

-- BẢNG PhieuNhanPhong
CREATE PROC getAllPhieuNhanPhong
AS
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 ORDER BY PhieuNhanPhong.TrangThai ASC
END
GO

CREATE PROC getPhieuNhanPhongByMaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE PhieuNhanPhong.MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC getPhieuNhanPhong_ByMaPhieuThue
@MaPhieuThue varchar (10)
AS
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong where MaPhieuThue = @MaPhieuThue
END
GO

CREATE PROC SearchPhieuNhanPhong
@MaPhong varchar (3),
@TenKhachHang nvarchar (50),
@CMND varchar (15)
AS
IF @MaPhong != '' AND @TenKhachHang != '' AND @CMND != '' 
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.MaPhong = @MaPhong AND ChiTietPhieuNhanPhong.HoTenKhachHang LIKE '%'+@TenKhachHang+'%' AND ChiTietPhieuNhanPhong.CMND = @CMND
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

ELSE IF @MaPhong = '' AND @TenKhachHang = '' AND @CMND  = ''
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

 ELSE IF @MaPhong  = '' AND @TenKhachHang != '' AND @CMND != ''
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.HoTenKhachHang LIKE '%'+@TenKhachHang+'%' AND ChiTietPhieuNhanPhong.CMND = @CMND
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

 ELSE IF @MaPhong  = '' AND @TenKhachHang = '' AND @CMND != ''
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.CMND = @CMND
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

 ELSE IF @MaPhong  = '' AND @TenKhachHang != '' AND @CMND  = ''
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.HoTenKhachHang LIKE '%'+@TenKhachHang+'%'
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

IF @MaPhong != '' AND @TenKhachHang != '' AND @CMND  = ''
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.MaPhong = @MaPhong AND ChiTietPhieuNhanPhong.HoTenKhachHang LIKE '%'+@TenKhachHang+'%'
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

IF @MaPhong != '' AND @TenKhachHang  = '' AND @CMND != '' 
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.MaPhong = @MaPhong AND ChiTietPhieuNhanPhong.CMND = @CMND
 ORDER BY PhieuNhanPhong.TrangThai ASC
END

IF @MaPhong != '' AND @TenKhachHang  = '' AND @CMND  = '' 
BEGIN 
 SELECT PhieuNhanPhong.MaNhanPhong,PhieuNhanPhong.MaPhieuThue,PhieuNhanPhong.MaKhachHang,ChiTietPhieuNhanPhong.MaPhong,
 ChiTietPhieuNhanPhong.HoTenKhachHang,ChiTietPhieuNhanPhong.CMND,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraDuKien,ChiTietPhieuNhanPhong.NgayTraThucTe,PhieuNhanPhong.TrangThai
 FROM PhieuNhanPhong
 INNER JOIN ChiTietPhieuNhanPhong ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
 WHERE ChiTietPhieuNhanPhong.MaPhong = @MaPhong
 ORDER BY PhieuNhanPhong.TrangThai ASC
 END
GO 

CREATE PROC insertPhieuNhanPhong
@MaNhanPhong varchar (5),
@MaPhieuThue varchar (10),
@MaKhachHang varchar (3)
AS
BEGIN 
Insert into PhieuNhanPhong(MaNhanPhong,MaPhieuThue,MaKhachHang) Values(@MaNhanPhong,@MaPhieuThue,@MaKhachHang)
END
GO

CREATE PROC updatePhieuNhanPhong
@MaNhanPhong varchar (5),
@MaPhieuThue varchar (10),
@MaKhachHang varchar (3)
AS
BEGIN 
Update PhieuNhanPhong set MaPhieuThue = @MaPhieuThue, MaKhachHang=@MaKhachHang Where  MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC updateTrangThaiPhieuNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
Update PhieuNhanPhong set TrangThai = 1 Where  MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC deletePhieuNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
DELETE PhieuNhanPhong Where MaNhanPhong = @MaNhanPhong
END
GO

-- BẢNG PhieuThuePhong
CREATE PROC getAllPhieuThuePhong
AS
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 ORDER BY PhieuThuePhong.TrangThai ASC
END
GO

CREATE PROC getPhieuThuePhong_ChuaXL
AS
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE PhieuThuePhong.TrangThai = 0
 ORDER BY PhieuThuePhong.MaPhieuThue DESC
END
GO

CREATE PROC SearchThuePhong
@MaPhieuThue varchar (10),
@TenKhachHang varchar (50),
@MaPhong varchar (3)
AS
IF @MaPhieuThue != '' AND @TenKhachHang != '' AND @MaPhong != '' 
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE PhieuThuePhong.MaPhieuThue =@MaPhieuThue AND KhachHang.TenKhachHang LIKE '%'+@TenKhachHang+'%' AND ChiTietPhieuThuePhong.MaPhong =@MaPhong
 ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

ELSE IF @MaPhieuThue = '' AND @TenKhachHang = '' AND @MaPhong  = ''
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

 ELSE IF @MaPhieuThue  = '' AND @TenKhachHang != '' AND @MaPhong != ''
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE KhachHang.TenKhachHang LIKE '%'+@TenKhachHang+'%' AND ChiTietPhieuThuePhong.MaPhong =@MaPhong
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

 ELSE IF @MaPhieuThue  = '' AND @TenKhachHang = '' AND @MaPhong != ''
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE ChiTietPhieuThuePhong.MaPhong =@MaPhong
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

 ELSE IF @MaPhieuThue  = '' AND @TenKhachHang != '' AND @MaPhong  = ''
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE KhachHang.TenKhachHang LIKE '%'+@TenKhachHang+'%'
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

IF @MaPhieuThue != '' AND @TenKhachHang != '' AND @MaPhong  = ''
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE PhieuThuePhong.MaPhieuThue =@MaPhieuThue AND KhachHang.TenKhachHang LIKE '%'+@TenKhachHang+'%'
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

IF @MaPhieuThue != '' AND @TenKhachHang  = '' AND @MaPhong != '' 
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE PhieuThuePhong.MaPhieuThue =@MaPhieuThue AND ChiTietPhieuThuePhong.MaPhong =@MaPhong
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

IF @MaPhieuThue != '' AND @TenKhachHang  = '' AND @MaPhong  = '' 
BEGIN 
 SELECT PhieuThuePhong.MaPhieuThue,PhieuThuePhong.MaKhachHang,KhachHang.TenKhachHang ,ChiTietPhieuThuePhong.MaPhong,ChiTietPhieuThuePhong.NgayDangKy,ChiTietPhieuThuePhong.NgayNhan,ChiTietPhieuThuePhong.NgayTraDuKien,PhieuThuePhong.TrangThai
 FROM PhieuThuePhong
 INNER JOIN ChiTietPhieuThuePhong ON PhieuThuePhong.MaPhieuThue = ChiTietPhieuThuePhong.MaPhieuThue
 INNER JOIN KhachHang ON PhieuThuePhong.MaKhachHang = KhachHang.MaKhachHang
 WHERE PhieuThuePhong.MaPhieuThue =@MaPhieuThue
  ORDER BY PhieuThuePhong.MaPhieuThue DESC
END

GO 

CREATE PROC insertPhieuThuePhong
@MaPhieuThue varchar (10),
@MaKhachHang varchar (3)
AS
BEGIN 
Insert into PhieuThuePhong(MaPhieuThue,MaKhachHang) Values(@MaPhieuThue,@MaKhachHang)
END
GO

CREATE PROC deletePhieuThuePhong
@MaPhieuThue varchar (10)
AS
BEGIN 
DELETE PhieuThuePhong where MaPhieuThue = @MaPhieuThue
END
GO

CREATE PROC updateTrangThaiPhieuThue
@MaPhieuThue varchar (10)
AS
BEGIN 
UPDATE PhieuThuePhong SET TrangThai = 1 where MaPhieuThue = @MaPhieuThue
END
GO


-- BẢNG Phong
CREATE PROC getAllPhong
AS
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
ORDER BY Phong.MaPhong DESC
END
GO

CREATE PROC getPhongTrong
AS
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
 WHERE Phong.MaLoaiTinhTrangPhong = 1 OR Phong.MaLoaiTinhTrangPhong = 2 OR Phong.MaLoaiTinhTrangPhong = 3
ORDER BY Phong.MaPhong DESC
END
GO

CREATE PROC getByMaPhong
@MaPhong varchar (3)
AS
BEGIN 
SELECT * FROM Phong WHERE MaPhong = @MaPhong
END
GO

CREATE PROC SearchPhong
@MaPhong varchar (3),
@MaLoaiPhong varchar (3),
@MaLoaiTinhTrangPhong int
AS
IF @MaPhong != '' AND @MaLoaiPhong != '' AND @MaLoaiTinhTrangPhong != 0 
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where MaPhong = @MaPhong AND  Phong.MaLoaiPhong = @MaLoaiPhong AND Phong.MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong ORDER BY Phong.MaPhong ASC
END

ELSE IF @MaPhong = '' AND @MaLoaiPhong = '' AND @MaLoaiTinhTrangPhong  = 0
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
ORDER BY Phong.MaPhong ASC
END

 ELSE IF @MaPhong  = '' AND @MaLoaiPhong != '' AND @MaLoaiTinhTrangPhong != 0
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where Phong.MaLoaiPhong = @MaLoaiPhong AND Phong.MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong ORDER BY Phong.MaPhong ASC
END

 ELSE IF @MaPhong  = '' AND @MaLoaiPhong = '' AND @MaLoaiTinhTrangPhong != 0
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where Phong.MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong ORDER BY Phong.MaPhong ASC
END

 ELSE IF @MaPhong  = '' AND @MaLoaiPhong != '' AND @MaLoaiTinhTrangPhong  = 0
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where Phong.MaLoaiPhong = @MaLoaiPhong ORDER BY Phong.MaPhong ASC
END

IF @MaPhong != '' AND @MaLoaiPhong != '' AND @MaLoaiTinhTrangPhong  = 0 
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where MaPhong = @MaPhong AND  Phong.MaLoaiPhong = @MaLoaiPhong ORDER BY Phong.MaPhong ASC
END

IF @MaPhong != '' AND @MaLoaiPhong  = '' AND @MaLoaiTinhTrangPhong != 0 
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where MaPhong = @MaPhong AND Phong.MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong ORDER BY Phong.MaPhong ASC
END

IF @MaPhong != '' AND @MaLoaiPhong  = '' AND @MaLoaiTinhTrangPhong  = 0 
BEGIN 
 SELECT Phong.MaPhong, Phong.MaLoaiPhong, Phong.MaLoaiTinhTrangPhong, LoaiPhong.TenLoaiPhong, LoaiTinhTrang.TenLoaiTinhTrang, LoaiPhong.DonGia, Phong.GhiChu
 FROM Phong 
 INNER JOIN LoaiPhong ON Phong.MaLoaiPhong = LoaiPhong.MaLoaiPhong
 INNER JOIN LoaiTinhTrang ON Phong.MaLoaiTinhTrangPhong = LoaiTinhTrang.MaLoaiTinhTrangPhong
Where MaPhong = @MaPhong ORDER BY Phong.MaPhong ASC
END

GO 

CREATE PROC insertPhong
@MaPhong varchar (3),
@MaLoaiPhong varchar (3),
@MaLoaiTinhTrangPhong int,
@GhiChu nvarchar (50)
AS
BEGIN 
Insert into Phong(MaPhong,MaLoaiPhong,MaLoaiTinhTrangPhong,GhiChu) Values(@MaPhong,@MaLoaiPhong,@MaLoaiTinhTrangPhong,@GhiChu)
END
GO

CREATE PROC updatePhong
@MaPhong varchar (3),
@MaLoaiPhong varchar (3),
@MaLoaiTinhTrangPhong int,
@GhiChu nvarchar (50)
AS
BEGIN 
Update Phong set MaLoaiPhong = @MaLoaiPhong, MaLoaiTinhTrangPhong=@MaLoaiTinhTrangPhong, GhiChu=@GhiChu Where MaPhong = @MaPhong
END
GO

CREATE PROC updatePhongDaThue
@MaPhong varchar (3)
AS
BEGIN 
Update Phong set MaLoaiTinhTrangPhong = 2 Where MaPhong = @MaPhong
END
GO

CREATE PROC updatePhongDaNhan
@MaPhong varchar (3)
AS
BEGIN 
Update Phong set MaLoaiTinhTrangPhong = 3 Where MaPhong = @MaPhong
END
GO

CREATE PROC updatePhongDaThanhToan
@MaPhong varchar (3)
AS
BEGIN 
Update Phong set MaLoaiTinhTrangPhong = 1 Where MaPhong = @MaPhong
END
GO

CREATE PROC deletePhong
@MaPhong varchar (3)
AS
BEGIN 
DELETE Phong Where MaPhong = @MaPhong
END
GO

-- BẢNG DanhSachSuDungDichVu
CREATE PROC getDanhSachSuDungDichVu_ByMaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT DanhSachSuDungDichVu.MaSuDungDVu,DanhSachSuDungDichVu.MaDichVu,DanhSachSuDungDichVu.MaNhanPhong,DanhSachSuDungDichVu.SoLuong,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi,DichVu.DonGia
FROM DanhSachSuDungDichVu 
JOIN DichVu ON DanhSachSuDungDichVu.MaDichVu = DichVu.MaDichVu
JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
WHERE DanhSachSuDungDichVu.MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC getByMaSuDungDichVu
@MaSuDungDVu varchar (4)
AS
BEGIN 
SELECT DanhSachSuDungDichVu.MaSuDungDVu,DanhSachSuDungDichVu.MaDichVu,DanhSachSuDungDichVu.MaNhanPhong,DanhSachSuDungDichVu.SoLuong,LoaiDichVu.TenLoaiDichVu,DonVi.TenDonVi,DichVu.DonGia
FROM DanhSachSuDungDichVu 
JOIN DichVu ON DanhSachSuDungDichVu.MaDichVu = DichVu.MaDichVu
JOIN LoaiDichVu ON DichVu.MaLoaiDichVu = LoaiDichVu.MaLoaiDichVu
JOIN DonVi ON DichVu.MaDonVi = DonVi.MaDonVi
 WHERE MaSuDungDVu = @MaSuDungDVu
END
GO

CREATE PROC insertDanhSachSuDungDichVu
@MaSuDungDVu varchar (4),
@MaDichVu varchar (5),
@MaNhanPhong varchar (5),
@SoLuong int
AS
BEGIN 
Insert into DanhSachSuDungDichVu(MaSuDungDVu,MaDichVu,MaNhanPhong,SoLuong) Values(@MaSuDungDVu,@MaDichVu,@MaNhanPhong,@SoLuong)
END
GO

CREATE PROC insertDanhSachSuDungDichVuDefault
@MaSuDungDVu varchar (4),
@MaNhanPhong varchar (5)
AS
BEGIN 
Insert into DanhSachSuDungDichVu(MaSuDungDVu,MaDichVu,MaNhanPhong,SoLuong) Values(@MaSuDungDVu,'DV00',@MaNhanPhong,1)
END
GO

CREATE PROC updateDanhSachSuDungDichVu
@MaSuDungDVu varchar (4),
@MaDichVu varchar (5),
@MaNhanPhong varchar (5),
@SoLuong int
AS
BEGIN 
Update DanhSachSuDungDichVu set MaDichVu = @MaDichVu, MaNhanPhong=@MaNhanPhong, SoLuong=@SoLuong Where MaSuDungDVu = @MaSuDungDVu
END
GO

CREATE PROC deleteDanhSachSuDungDichVu
@MaSuDungDVu varchar (4)
AS
BEGIN 
DELETE DanhSachSuDungDichVu Where MaSuDungDVu = @MaSuDungDVu
END
GO

-- BẢNG ChiTietPhieuThuePhong
CREATE PROC getAllChiTietPhieuThuePhong
AS
BEGIN 
SELECT * FROM ChiTietPhieuThuePhong
END
GO

CREATE PROC deleteChiTietPhieuThuePhong
@MaPhieuThue varchar (10)
AS
BEGIN 
DELETE ChiTietPhieuThuePhong where MaPhieuThue = @MaPhieuThue
END
GO

CREATE PROC getByMaPhieuThue
@MaPhieuThue varchar (10)
AS
BEGIN 
SELECT * FROM ChiTietPhieuThuePhong where MaPhieuThue = @MaPhieuThue
END
GO

CREATE PROC insertChiTietPhieuThuePhong
@MaPhieuThue varchar (10),
@MaPhong varchar (3),
@NgayDangKy datetime,
@NgayNhan datetime,
@NgayTraDuKien datetime
AS
BEGIN 
Insert into ChiTietPhieuThuePhong(MaPhieuThue,MaPhong,NgayDangKy,NgayNhan,NgayTraDuKien) Values(@MaPhieuThue,@MaPhong,@NgayDangKy,@NgayNhan,@NgayTraDuKien)
END
GO

CREATE PROC updateChiTietPhieuThuePhong
@MaPhieuThue varchar (10),
@NgayDangKy datetime,
@NgayNhan datetime
AS
BEGIN 
UPDATE ChiTietPhieuThuePhong SET NgayDangKy =@NgayDangKy,NgayNhan=@NgayNhan where MaPhieuThue = @MaPhieuThue
END
GO

-- BẢNG ChiTietPhieuNhanPhong
CREATE PROC getAllChiTietPhieuNhanPhong
AS
BEGIN 
SELECT * FROM ChiTietPhieuNhanPhong
END
GO

CREATE PROC getChiTietPhieuNhanPhong_By_MaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT * FROM ChiTietPhieuNhanPhong Where MaNhanPhong =@MaNhanPhong 
END
GO

CREATE PROC insertChiTietPhieuNhanPhong
@MaNhanPhong varchar (5),
@MaPhong varchar (3),
@HoTenKhachHang nvarchar (50),
@CMND nvarchar (15),
@NgayNhan datetime,
@NgayTraDuKien datetime
AS
BEGIN 
Insert into ChiTietPhieuNhanPhong(MaNhanPhong,MaPhong,HoTenKhachHang,CMND,NgayNhan,NgayTraDuKien) 
Values(@MaNhanPhong,@MaPhong,@HoTenKhachHang,@CMND,@NgayNhan,@NgayTraDuKien)
END
GO

CREATE PROC deleteChiTietPhieuNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
DELETE ChiTietPhieuNhanPhong Where MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC updateNgayTraDuKien_ChiTietPhieuNhanPhong
@MaNhanPhong varchar (5),
@NgayTraDuKien datetime
AS
BEGIN 
UPDATE ChiTietPhieuNhanPhong SET NgayTraThucTe=@NgayTraDuKien Where MaNhanPhong = @MaNhanPhong
END
GO

-- BẢNG ChiTietHoaDon
CREATE PROC getAllChiTietHoaDon
AS
BEGIN 
SELECT * FROM ChiTietHoaDon
END
GO

CREATE PROC getChiTietHoaDon_By_MaHoaDon
@MaHoaDon int
AS
BEGIN 
select MaPhong,PhuThu,TienPhong, SUM(TienDichVu) as TongTienDichVu,GiamGiaKH,SoNgay,HinhThucThanhToan 
from ChiTietHoaDon WHERE  MaHoaDon = @MaHoaDon 
GROUP BY MaHoaDon,MaPhong,PhuThu,TienPhong,GiamGiaKH,SoNgay,HinhThucThanhToan
END
GO

CREATE PROC insertChiTietHoaDon
@MaHoaDon int,
@MaPhong  varchar (3),
@MaSuDungDichVu varchar (4),
@MaChinhSach varchar (5),
@PhuThu float,
@TienPhong float,
@TienDichVu float,
@GiamGiaKH float,
@HinhThucThanhToan nvarchar(50),
@SoNgay int,
@ThanhTien float
AS
BEGIN 
Insert into ChiTietHoaDon(MaHoaDon,MaPhong,MaSuDungDichVu,MaChinhSach,PhuThu,TienPhong,TienDichVu,GiamGiaKH,HinhThucThanhToan,SoNgay,ThanhTien) 
Values(@MaHoaDon,@MaPhong,@MaSuDungDichVu,@MaChinhSach,@PhuThu,@TienPhong,@TienDichVu,@GiamGiaKH,@HinhThucThanhToan,@SoNgay,@ThanhTien)
END
GO 

CREATE PROC insertChiTietHoaDonNoDV
@MaHoaDon int,
@MaPhong  varchar (3),
@MaChinhSach varchar (5),
@PhuThu float,
@TienPhong float,
@TienDichVu float,
@GiamGiaKH float,
@HinhThucThanhToan nvarchar(50),
@SoNgay int,
@ThanhTien float
AS
BEGIN 
Insert into ChiTietHoaDon(MaHoaDon,MaPhong,MaChinhSach,PhuThu,TienPhong,TienDichVu,GiamGiaKH,HinhThucThanhToan,SoNgay,ThanhTien) 
Values(@MaHoaDon,@MaPhong,@MaChinhSach,@PhuThu,@TienPhong,@TienDichVu,@GiamGiaKH,@HinhThucThanhToan,@SoNgay,@ThanhTien)
END
GO 

CREATE proc getConfigVal
@MaCauHinh int,
@MaNguoiDung int
AS
BEGIN
SELECT * FROM [CauHinhNguoiDung]
WHERE MaCauHinh = @MaCauHinh and MaNguoiDung = @MaNguoiDung
END
go

DECLARE @Number INT = 1 ;
WHILE @Number < = 18
BEGIN
INSERT INTO PhanQuyen(MaNhomQuyen,MaQuyen) VALUES (1,@Number)
SET @Number = @Number + 1 ;
END
GO

INSERT INTO CauHinh(LoaiCauHinh) VALUES 
('Language'),
('Color')
GO

CREATE PROC updateCauHinhNguoiDung
@MaCauHinh int,
@MaNguoiDung int,
@NoiDungCauHinh nvarchar (50)
AS
BEGIN 
update CauHinhNguoiDung SET NoiDungCauHinh = @NoiDungCauHinh WHERE MaCauHinh = @MaCauHinh AND MaNguoiDung = @MaNguoiDung
END
GO


CREATE PROC insertNguoiDung
@TenNguoiDung nvarchar (50),
@TenDangNhap varchar (50),
@MatKhau nvarchar (50),
@Anh image,
@Email varchar (50),
@NgaySinh datetime,
@GioiTinh bit,
@MaNhomQuyen int
AS
DECLARE @id int
BEGIN TRY
    BEGIN TRANSACTION

Insert into NguoiDung(TenNguoiDung,TenDangNhap,MatKhau,Anh,Email,NgaySinh,GioiTinh,MaNhomQuyen) Values(@TenNguoiDung,@TenDangNhap,@MatKhau,@Anh,@Email,@NgaySinh,@GioiTinh,@MaNhomQuyen)
set @id = @@IDENTITY
exec insertCauHinhNguoiDung 1,@id,'vietnam'
exec insertCauHinhNguoiDung 2,@id,'[36, 36,36]'

		COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION
END CATCH
GO

exec insertNguoiDung 'Admin Manager','admin','123', null ,'admin@gmail.com','2020-12-12',1,1
go
    

CREATE VIEW DistinctGiaDichVu
AS
select dt.MaPhong,SUM(TienDichVu) as TienDichVu
FROM (Select DISTINCT(MaHoaDon),MaPhong,TienDichVu,MaSuDungDichVu from ChiTietHoaDon) dt
GROUP by dt.MaPhong
Go


CREATE VIEW ChiTietKinhDoanh
as
SELECT ChiTietHoaDon.*,PhieuNhanPhong.MaPhieuThue,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraThucTe from ChiTietHoaDon
JOIN HoaDon
ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon
JOIN PhieuNhanPhong
ON PhieuNhanPhong.MaNhanPhong = HoaDon.MaNhanPhong
JOIN ChiTietPhieuNhanPhong
ON ChiTietPhieuNhanPhong.MaNhanPhong = PhieuNhanPhong.MaNhanPhong
go

CREATE PROC ThongKePhong
@NgayBatDau datetime,
@NgayKetThuc datetime
as
select dt.MaPhong,SUM(SoNgay) as SoNgay,COUNT(dt.MaPhong) as SoLanThue,SUM(TienPhong) as TienPhong,DistinctGiaDichVu.TienDichVu,SUM(GiamGiaKH) as GiamGia,
SUM(ThanhTien) AS TongTien
FROM (Select DISTINCT(MaHoaDon),MaPhong,TienPhong,GiamGiaKH,SoNgay,ThanhTien from ChiTietKinhDoanh) dt
JOIN (
select dt.MaPhong,Sum(dt.ThanhTien) as TongTien
FROM (Select DISTINCT(MaHoaDon),MaPhong,ngay.ThanhTien from (
SELECT ChiTietHoaDon.*,PhieuNhanPhong.MaPhieuThue,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraThucTe from ChiTietHoaDon
JOIN HoaDon
ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon
JOIN PhieuNhanPhong
ON PhieuNhanPhong.MaNhanPhong = HoaDon.MaNhanPhong
JOIN ChiTietPhieuNhanPhong
ON ChiTietPhieuNhanPhong.MaNhanPhong = PhieuNhanPhong.MaNhanPhong
GROUP by ChiTietPhieuNhanPhong.NgayTraThucTe,ChiTietHoaDon.MaHoaDon,ChiTietHoaDon.MaPhong,ChiTietHoaDon.MaSuDungDichVu,
ChiTietHoaDon.MaChinhSach,ChiTietHoaDon.PhuThu,ChiTietHoaDon.TienPhong,ChiTietHoaDon.TienDichVu,ChiTietHoaDon.GiamGiaKH,
ChiTietHoaDon.HinhThucThanhToan,ChiTietHoaDon.SoNgay,ChiTietHoaDon.ThanhTien,PhieuNhanPhong.MaPhieuThue,ChiTietPhieuNhanPhong.NgayNhan
HAVING ChiTietPhieuNhanPhong.NgayTraThucTe BETWEEN @NgayBatDau And @NgayKetThuc
) ngay
) dt
GROUP by dt.MaPhong
) dv
on dv.MaPhong = dt.MaPhong
JOIN DistinctGiaDichVu
ON DistinctGiaDichVu.MaPhong = dv.MaPhong
GROUP by dt.MaPhong,dv.TongTien,DistinctGiaDichVu.TienDichVu
GO

CREATE PROC ThongKeKhachHang
@tuNgay DATETIME,
@denNgay DATETIME
as
SELECT Phong.MaPhong,KhachHang.TenKhachHang,KhachHang.CMND,KhachHang.GioiTinh,
KhachHang.DienThoai,KhachHang.DiaChi,KhachHang.QuocTich,
ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraThucTe
FROM KhachHang
JOIN PhieuNhanPhong
ON KhachHang.MaKhachHang = PhieuNhanPhong.MaKhachHang
JOIN ChiTietPhieuNhanPhong
ON PhieuNhanPhong.MaNhanPhong = ChiTietPhieuNhanPhong.MaNhanPhong
JOIN Phong
ON ChiTietPhieuNhanPhong.MaPhong = Phong.MaPhong
WHERE (NgayTraThucTe BETWEEN @tuNgay and @denNgay)
go

CREATE VIEW SumPhong
AS
select dt.MaPhong,Count(MaPhong) as soLan
FROM (Select DISTINCT(MaHoaDon),MaPhong from ChiTietHoaDon) dt
GROUP by dt.MaPhong
Go


CREATE VIEW HsPhong
AS
select dt.MaPhong,Count(MaPhong) as soLan,FORMAT(CONVERT(float,Count(MaPhong))*100/(SELECT sum(soLan) From SumPhong),'N2') as HiieuSuatPhong
FROM (Select DISTINCT(MaHoaDon),MaPhong from ChiTietHoaDon) dt
GROUP by dt.MaPhong
Go

CREATE PROC ThongKeHieuSuatPhong
@NgayBatDau datetime,
@NgayKetThuc datetime
as
select Phong.MaPhong,isnull(HsPhong.HiieuSuatPhong,0) as HieuSuatThue ,isnull(SUM(SoNgay),0) as SoNgay,COUNT(dt.MaPhong) as SoLanThue,
isnull(SUM(TienPhong),0) as TienPhong, isnull(DistinctGiaDichVu.TienDichVu,0) as TienDichVu,isnull(SUM(GiamGiaKH),0) as GiamGia,
isnull(SUM(ThanhTien),0) AS TongTien
FROM (Select DISTINCT(MaHoaDon),MaPhong,TienPhong,GiamGiaKH,SoNgay,ThanhTien from ChiTietKinhDoanh) dt
JOIN (
select dt.MaPhong,Sum(dt.ThanhTien) as TongTien
FROM (Select DISTINCT(MaHoaDon),MaPhong,ngay.ThanhTien from (
SELECT ChiTietHoaDon.*,PhieuNhanPhong.MaPhieuThue,ChiTietPhieuNhanPhong.NgayNhan,ChiTietPhieuNhanPhong.NgayTraThucTe from ChiTietHoaDon
JOIN HoaDon
ON ChiTietHoaDon.MaHoaDon = HoaDon.MaHoaDon
JOIN PhieuNhanPhong
ON PhieuNhanPhong.MaNhanPhong = HoaDon.MaNhanPhong
JOIN ChiTietPhieuNhanPhong
ON ChiTietPhieuNhanPhong.MaNhanPhong = PhieuNhanPhong.MaNhanPhong
GROUP by ChiTietPhieuNhanPhong.NgayTraThucTe,ChiTietHoaDon.MaHoaDon,ChiTietHoaDon.MaPhong,ChiTietHoaDon.MaSuDungDichVu,
ChiTietHoaDon.MaChinhSach,ChiTietHoaDon.PhuThu,ChiTietHoaDon.TienPhong,ChiTietHoaDon.TienDichVu,ChiTietHoaDon.GiamGiaKH,
ChiTietHoaDon.HinhThucThanhToan,ChiTietHoaDon.SoNgay,ChiTietHoaDon.ThanhTien,PhieuNhanPhong.MaPhieuThue,ChiTietPhieuNhanPhong.NgayNhan
HAVING ChiTietPhieuNhanPhong.NgayTraThucTe BETWEEN @NgayBatDau And @NgayKetThuc
) ngay
) dt
GROUP by dt.MaPhong
) dv
on dv.MaPhong = dt.MaPhong
JOIN DistinctGiaDichVu
ON DistinctGiaDichVu.MaPhong = dv.MaPhong

JOIN HsPhong
ON dt.MaPhong = HsPhong.MaPhong
right JOIN Phong
ON dt.MaPhong  = Phong.MaPhong
GROUP by dt.MaPhong,dv.TongTien,DistinctGiaDichVu.TienDichVu,HsPhong.HiieuSuatPhong,Phong.MaPhong
GO

CREATE PROC GetChiTietPhieuNhanPhongByMaPhong
@MaPhong VARCHAR(10)
as
BEGIN
SELECT ChiTietPhieuNhanPhong.* from ChiTietPhieuNhanPhong
JOIN Phong on ChiTietPhieuNhanPhong.MaPhong = Phong.MaPhong
Where ChiTietPhieuNhanPhong.MaPhong = @MaPhong
END
GO  