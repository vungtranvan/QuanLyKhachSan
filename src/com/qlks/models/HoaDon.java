/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.models;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author hello
 */
public class HoaDon {

    private String maHoaDon;
    private String maKhachHang;
    private String maNhanPhong;
    private int maKhuyenMai;
    private String nhanVienLap;
    private float tongTien;
    private LocalDate ngayLap;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maKhachHang, String maNhanPhong, int maKhuyenMai, String nhanVienLap, float tongTien, LocalDate ngayLap) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.maNhanPhong = maNhanPhong;
        this.maKhuyenMai = maKhuyenMai;
        this.nhanVienLap = nhanVienLap;
        this.tongTien = tongTien;
        this.ngayLap = ngayLap;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaNhanPhong() {
        return maNhanPhong;
    }

    public void setMaNhanPhong(String maNhanPhong) {
        this.maNhanPhong = maNhanPhong;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(String nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

}
