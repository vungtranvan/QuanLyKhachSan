package com.qlks.models;

/**
 *
 * @author hello
 */
public class DanhSachSuDungDichVu {

    private String maSuDungDVu;
    private String maDichVu;
    private String maNhanPhong;
    private int soLuong;

    public DanhSachSuDungDichVu() {
    }

    public DanhSachSuDungDichVu(String maSuDungDVu, String maDichVu, String maNhanPhong, int soLuong) {
        this.maSuDungDVu = maSuDungDVu;
        this.maDichVu = maDichVu;
        this.maNhanPhong = maNhanPhong;
        this.soLuong = soLuong;
    }

    public String getMaSuDungDVu() {
        return maSuDungDVu;
    }

    public void setMaSuDungDVu(String maSuDungDVu) {
        this.maSuDungDVu = maSuDungDVu;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getMaNhanPhong() {
        return maNhanPhong;
    }

    public void setMaNhanPhong(String maNhanPhong) {
        this.maNhanPhong = maNhanPhong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
