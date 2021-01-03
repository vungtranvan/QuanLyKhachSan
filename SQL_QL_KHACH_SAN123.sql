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
BEGIN TRY
    BEGIN TRANSACTION
Insert into NguoiDung(TenNguoiDung,TenDangNhap,MatKhau,Anh,Email,NgaySinh,GioiTinh,MaNhomQuyen) Values(@TenNguoiDung,@TenDangNhap,@MatKhau,@Anh,@Email,@NgaySinh,@GioiTinh,@MaNhomQuyen)

exec insertCauHinhNguoiDung 1,@@IDENTITY,'vietnam'
		COMMIT TRANSACTION
END TRY
BEGIN CATCH
    ROLLBACK TRANSACTION
END CATCH
GO
