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
	Anh varchar(MAX),
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
	DienThoai int,
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
	MaHoaDon varchar (3) PRIMARY KEY NOT NULL,
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
	MaKhachHang varchar (3) NOT NULL
)
GO

CREATE TABLE PhieuThuePhong
(
	MaPhieuThue varchar (10) PRIMARY KEY NOT NULL,
	MaKhachHang varchar (3) NOT NULL
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
	MaHoaDon varchar (3) NOT NULL,
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
	PRIMARY KEY(MaHoaDon, MaPhong, MaSuDungDichVu, MaChinhSach)
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
SELECT * FROM CauHinh
END
GO

CREATE PROC SearchCauHinh
@LoaiCauHinh nvarchar (50)
AS
BEGIN 
SELECT * FROM CauHinh Where LoaiCauHinh LIKE '%'+@LoaiCauHinh+'%'
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
SELECT * FROM CauHinh
END
GO

CREATE PROC SearchQuyen
@Quyen nvarchar (50)
AS
BEGIN 
SELECT * FROM Quyen Where Quyen LIKE '%'+@Quyen+'%'
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
SELECT * FROM NguoiDung
END
GO

CREATE PROC SearchNguoiDung
@MaNguoiDung int,
@TenNguoiDung nvarchar (50),
@TenDangNhap varchar (50),
@Email varchar (50),
@NgaySinh datetime,
@GioiTinh bit,
@MaNhomQuyen int
AS
BEGIN 
SELECT * FROM NguoiDung Where MaNguoiDung = @MaNguoiDung OR TenNguoiDung LIKE '%'+@TenNguoiDung+'%' 
OR TenDangNhap LIKE '%'+@TenDangNhap+'%' OR Email LIKE '%'+@Email+'%' OR NgaySinh LIKE '%'+@NgaySinh+'%' 
OR GioiTinh = @GioiTinh OR MaNhomQuyen =@MaNhomQuyen
END
GO

CREATE PROC getNguoiDungById
@MaNguoiDung int
AS
BEGIN 
SELECT * FROM NguoiDung Where MaNguoiDung = @MaNguoiDung
END
GO

CREATE PROC insertNguoiDung
@TenNguoiDung nvarchar (50),
@TenDangNhap varchar (50),
@MatKhau nvarchar (50),
@Anh varchar(MAX),
@Email varchar (50),
@NgaySinh datetime,
@GioiTinh bit,
@MaNhomQuyen int
AS
BEGIN 
Insert into NguoiDung(TenNguoiDung,TenDangNhap,MatKhau,Anh,Email,NgaySinh,GioiTinh,MaNhomQuyen) Values(@TenNguoiDung,@TenDangNhap,@MatKhau,@Anh,@Email,@NgaySinh,@GioiTinh,@MaNhomQuyen)
END
GO

CREATE PROC updateNguoiDung
@MaNguoiDung int,
@TenNguoiDung nvarchar (50),
@TenDangNhap varchar (50),
@MatKhau nvarchar (50),
@Anh varchar(MAX),
@Email varchar (50),
@NgaySinh datetime,
@GioiTinh bit,
@MaNhomQuyen int
AS
BEGIN 
Update NguoiDung set TenNguoiDung = @TenNguoiDung, TenDangNhap =@TenDangNhap,MatKhau=@MatKhau,Anh=@Anh,Email=@Email,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh, MaNhomQuyen = @MaNhomQuyen Where MaNguoiDung = @MaNguoiDung
END
GO

CREATE PROC deleteNguoiDung
@MaNguoiDung int
AS
BEGIN 
DELETE NguoiDung Where MaNguoiDung = @MaNguoiDung
END
GO


-- BẢNG KhachHang
CREATE PROC getAllKhachHang
AS
BEGIN 
SELECT * FROM KhachHang
END
GO

CREATE PROC SearchKhachHang
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai int,
@GioiTinh bit,
@QuocTich nvarchar(50)
AS
BEGIN 
SELECT * FROM KhachHang Where MaKhachHang LIKE '%'+@MaKhachHang+'%' OR TenKhachHang LIKE '%'+@TenKhachHang+'%' 
OR CMND LIKE '%'+@CMND+'%' OR DiaChi LIKE '%'+@DiaChi+'%' OR DienThoai LIKE '%'+@DienThoai+'%' 
OR GioiTinh = @GioiTinh OR QuocTich LIKE '%'+@QuocTich+'%'
END
GO

CREATE PROC insertKhachHang
@MaKhachHang varchar (3),
@TenKhachHang nvarchar (50),
@CMND nvarchar (15),
@DiaChi nvarchar (50),
@DienThoai int,
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
@DienThoai int,
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
SELECT * FROM ThietBi
END
GO

CREATE PROC SearchThietBi
@MaThietBi varchar (8),
@MaLoaiPhong varchar (3),
@TenThietBi nvarchar (50),
@Gia float
AS
BEGIN 
SELECT * FROM ThietBi Where MaThietBi LIKE '%'+@MaThietBi+'%' OR MaLoaiPhong LIKE '%'+@MaLoaiPhong+'%' 
OR TenThietBi LIKE '%'+@TenThietBi+'%' OR Gia = @Gia
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

CREATE PROC SearchDonVi
@MaDonVi varchar (3),
@TenDonVi nvarchar (50)
AS
BEGIN 
SELECT * FROM DonVi Where MaDonVi LIKE '%'+@MaDonVi+'%' OR TenDonVi LIKE '%'+@TenDonVi+'%' 
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

CREATE PROC SearchChinhSachTraPhong
@MaChinhSach varchar (5),
@NoiDung nvarchar (50)
AS
BEGIN 
SELECT * FROM ChinhSachTraPhong Where MaChinhSach LIKE '%'+@MaChinhSach+'%' OR NoiDung LIKE '%'+@NoiDung+'%' 
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
SELECT * FROM DichVu
END
GO

CREATE PROC SearchDichVu
@MaDichVu varchar (5),
@MaLoaiDichVu varchar (5),
@MaDonVi varchar (3),
@DonGia float
AS
BEGIN 
SELECT * FROM DichVu Where MaDichVu LIKE '%'+@MaDichVu+'%' OR MaLoaiDichVu LIKE '%'+@MaLoaiDichVu+'%' 
OR MaDonVi LIKE '%'+@MaDonVi+'%' OR DonGia = DonGia
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

CREATE PROC SearchLoaiDichVu
@MaLoaiDichVu varchar (5),
@TenLoaiDichVu nvarchar (50)
AS
BEGIN 
SELECT * FROM LoaiDichVu Where TenLoaiDichVu LIKE '%'+@TenLoaiDichVu+'%' OR MaLoaiDichVu LIKE '%'+@MaLoaiDichVu+'%'
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

CREATE PROC SearchLoaiPhong
@MaLoaiPhong Varchar (3),
@TenLoaiPhong nvarchar (50),
@DonGia Float,
@SoNguoiChuan int,
@SoNguoiToiDa int
AS
BEGIN 
SELECT * FROM LoaiPhong Where MaLoaiPhong  LIKE '%'+@MaLoaiPhong +'%' OR TenLoaiPhong LIKE '%'+@TenLoaiPhong+'%'  OR DonGia = @DonGia OR SoNguoiChuan = @SoNguoiChuan OR SoNguoiToiDa = @SoNguoiToiDa
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

CREATE PROC SearchNhomQuyen
@MaNhomQuyen int,
@TenNhomQuyen nvarchar (50)
AS
BEGIN 
SELECT * FROM NhomQuyen Where MaNhomQuyen = @MaNhomQuyen OR TenNhomQuyen LIKE '%'+@TenNhomQuyen+'%'
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
BEGIN 
DELETE NhomQuyen Where MaNhomQuyen = @MaNhomQuyen
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
SELECT * FROM HoaDon
END
GO

CREATE PROC getByMaHoaDon
@MaHoaDon varchar (3)
AS
BEGIN 
SELECT * FROM HoaDon Where MaHoaDon = @MaHoaDon
END
GO

CREATE PROC getByMaKhachHang
@MaKhachHang varchar (3)
AS
BEGIN 
SELECT * FROM HoaDon Where MaKhachHang = @MaKhachHang
END
GO

CREATE PROC getByMaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT * FROM HoaDon Where MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC SearchNHoaDon
@MaHoaDon varchar (3),
@MaKhachHang varchar (3),
@MaNhanPhong varchar (5),
@MaKhuyenMai int,
@NhanVienLap nvarchar (50),
@NgayLap datetime
AS
BEGIN 
SELECT * FROM HoaDon Where MaHoaDon LIKE '%'+@MaHoaDon+'%' OR MaKhachHang LIKE '%'+@MaKhachHang+'%' 
OR MaNhanPhong LIKE '%'+@MaNhanPhong+'%' OR MaKhuyenMai=@MaKhuyenMai OR NhanVienLap LIKE '%'+@NhanVienLap+'%' OR NgayLap = @NgayLap
END
GO

CREATE PROC insertHoaDon
@MaHoaDon varchar (3),
@MaKhachHang varchar (3),
@MaNhanPhong varchar (5),
@MaKhuyenMai int,
@NhanVienLap nvarchar (50),
@TongTien float,
@NgayLap datetime
AS
BEGIN 
Insert into HoaDon(MaHoaDon,MaKhachHang,MaNhanPhong,MaKhuyenMai,NhanVienLap,TongTien,NgayLap) Values(@MaHoaDon,@MaKhachHang,@MaNhanPhong,@MaKhuyenMai,@NhanVienLap,@TongTien,@NgayLap)
END
GO

CREATE PROC updateHoaDon
@MaHoaDon varchar (3),
@MaKhachHang varchar (3),
@MaNhanPhong varchar (5),
@MaKhuyenMai int,
@NhanVienLap nvarchar (50),
@TongTien float,
@NgayLap datetime
AS
BEGIN 
Update HoaDon set MaKhachHang = @MaKhachHang, MaNhanPhong = @MaNhanPhong,MaKhuyenMai=@MaKhuyenMai,NhanVienLap=@NhanVienLap,TongTien=@TongTien,NgayLap=@NgayLap Where MaHoaDon = @MaHoaDon
END
GO

CREATE PROC deleteHoaDon
@MaHoaDon varchar (3)
AS
BEGIN 
DELETE HoaDon Where MaHoaDon = @MaHoaDon
END
GO

-- BẢNG KhuyenMai
CREATE PROC getAllKhuyenMai
AS
BEGIN 
SELECT * FROM KhuyenMai
END
GO

CREATE PROC getByMaKhuyenMai
@MaKhuyenMai int
AS
BEGIN 
SELECT * FROM KhuyenMai WHERE MaKhuyenMai = @MaKhuyenMai
END
GO

CREATE PROC SearchKhuyenMai
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
SELECT * FROM KhuyenMai 
Where MaKhuyenMai = @MaKhuyenMai OR MaPhieu LIKE '%'+@MaPhieu+'%'
OR GiaTri =@GiaTri OR NoiDung LIKE '%'+@NoiDung+'%' OR NgayBatDau = @NgayBatDau
OR NgayKetThuc =@NgayKetThuc OR KieuTinh =@KieuTinh OR TrangThai =@TrangThai
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
SELECT * FROM LoaiTinhTrang
END
GO

CREATE PROC getByMaLoaiTinhTrang
@MaLoaiTinhTrangPhong int
AS
BEGIN 
SELECT * FROM LoaiTinhTrang WHERE MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong
END
GO

CREATE PROC SearchLoaiTinhTrang
@MaLoaiTinhTrangPhong int,
@TenLoaiTinhTrang  nvarchar(50)
AS
BEGIN 
SELECT * FROM LoaiTinhTrang 
Where MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong OR TenLoaiTinhTrang LIKE '%'+@TenLoaiTinhTrang+'%'
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
SELECT * FROM PhieuNhanPhong
END
GO

CREATE PROC getPhieuNhanPhongByMaNhanPhong
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT * FROM PhieuNhanPhong WHERE MaNhanPhong = @MaNhanPhong
END
GO

CREATE PROC SearchPhieuNhanPhong
@MaNhanPhong varchar (5),
@MaPhieuThue varchar (10),
@MaKhachHang varchar (3)
AS
BEGIN 
SELECT * FROM PhieuNhanPhong 
Where MaNhanPhong LIKE '%'+@MaNhanPhong+'%' OR MaPhieuThue LIKE '%'+@MaPhieuThue+'%' OR MaKhachHang LIKE '%'+@MaKhachHang+'%'
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
SELECT * FROM PhieuThuePhong
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

-- BẢNG Phong
CREATE PROC getAllPhong
AS
BEGIN 
SELECT * FROM Phong
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
BEGIN 
SELECT * FROM Phong 
Where MaPhong LIKE '%'+@MaPhong+'%' OR  MaLoaiPhong LIKE '%'+@MaLoaiPhong+'%' OR MaLoaiTinhTrangPhong = @MaLoaiTinhTrangPhong
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

CREATE PROC deletePhong
@MaPhong varchar (3)
AS
BEGIN 
DELETE Phong Where MaPhong = @MaPhong
END
GO

-- BẢNG DanhSachSuDungDichVu
CREATE PROC getAllDanhSachSuDungDichVu
AS
BEGIN 
SELECT * FROM DanhSachSuDungDichVu
END
GO

CREATE PROC getByMaSuDungDichVu
@MaSuDungDVu varchar (4)
AS
BEGIN 
SELECT * FROM DanhSachSuDungDichVu WHERE MaSuDungDVu = @MaSuDungDVu
END
GO

CREATE PROC SearchDanhSachSuDungDichVu
@MaSuDungDVu varchar (4),
@MaDichVu varchar (5),
@MaNhanPhong varchar (5)
AS
BEGIN 
SELECT * FROM DanhSachSuDungDichVu 
Where MaSuDungDVu LIKE '%'+@MaSuDungDVu+'%' OR  MaDichVu LIKE '%'+@MaDichVu+'%' OR  MaNhanPhong LIKE '%'+@MaNhanPhong+'%'
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

CREATE PROC insertChiTietPhieuThuePhong
@MaPhieuThue varchar (10),
@MaPhong varchar (3),
@NgayDangKy datetime,
@NgayNhan datetime
AS
BEGIN 
Insert into ChiTietPhieuThuePhong(MaPhieuThue,MaPhong,NgayDangKy,NgayNhan) Values(@MaPhieuThue,@MaPhong,@NgayDangKy,@NgayNhan)
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
@NgayTraDuKien datetime,
@NgayTraThucTe datetime
AS
BEGIN 
Insert into ChiTietPhieuNhanPhong(MaNhanPhong,MaPhong,HoTenKhachHang,CMND,NgayNhan,NgayTraDuKien,NgayTraThucTe) 
Values(@MaNhanPhong,@MaPhong,@HoTenKhachHang,@CMND,@NgayNhan,@NgayTraDuKien,@NgayTraThucTe)
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
@MaHoaDon varchar (3)
AS
BEGIN 
SELECT * FROM ChiTietHoaDon Where MaHoaDon =@MaHoaDon 
END
GO

CREATE PROC insertChiTietHoaDon
@MaHoaDon varchar (3),
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