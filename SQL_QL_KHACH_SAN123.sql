GO 


DECLARE @Number INT = 1 ;
WHILE @Number < = 18
BEGIN
INSERT into PhanQuyen(MaNhomQuyen,MaQuyen) VALUES (1,@Number)
SET @Number = @Number + 1 ;
END

GO


INSERT into CauHinh (LoaiCauHinh) VALUES ('Language')
insert into CauHinhNguoiDung(MaCauHinh,MaNguoiDung,NoiDungCauHinh) VALUES (1,1,'vietnam')

GO

SELECT * FROM Quyen

GO
CREATE proc getConfigVal
@MaCauHinh int,
@MaNguoiDung int
AS
BEGIN
SELECT * from CauHinhNguoiDung WHERE MaCauHinh = @MaCauHinh and @MaNguoiDung = @MaNguoiDung
END
GO
SELECT * FROM CauHinhNguoiDung
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
