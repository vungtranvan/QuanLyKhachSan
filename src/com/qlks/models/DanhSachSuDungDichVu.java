package com.qlks.models;

/**
 *
 * @author hello
 */
public class DanhSachSuDungDichVu {

    private String maSuDungDVu;
    private String maDichVu;
    private String maNhanPhong;
    private String maPhong;
    private int soLuong;
    private String tenLoaiDichVu;
    private String tenDonvi;
    private float donGia;

    public DanhSachSuDungDichVu() {
    }

    public DanhSachSuDungDichVu(String maSuDungDVu, String maDichVu, String maNhanPhong, String maPhong, int soLuong) {
        this.maSuDungDVu = maSuDungDVu;
        this.maDichVu = maDichVu;
        this.maNhanPhong = maNhanPhong;
        this.maPhong = maPhong;
        this.soLuong = soLuong;
    }

    public DanhSachSuDungDichVu(String maSuDungDVu, String maDichVu, String maNhanPhong, String maPhong, int soLuong, String tenLoaiDichVu, String tenDonvi, float donGia) {
        this.maSuDungDVu = maSuDungDVu;
        this.maDichVu = maDichVu;
        this.maNhanPhong = maNhanPhong;
        this.maPhong = maPhong;
        this.soLuong = soLuong;
        this.tenLoaiDichVu = tenLoaiDichVu;
        this.tenDonvi = tenDonvi;
        this.donGia = donGia;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public String getTenDonvi() {
        return tenDonvi;
    }

    public void setTenDonvi(String tenDonvi) {
        this.tenDonvi = tenDonvi;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
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
