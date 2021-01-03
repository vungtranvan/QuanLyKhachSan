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
