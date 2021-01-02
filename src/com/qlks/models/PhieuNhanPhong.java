/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.models;

import java.time.LocalDate;

/**
 *
 * @author hello
 */
public class PhieuNhanPhong {

    private String maNhanPhong;
    private String maPhieuThue;
    private String maKhachHang;
    private String maPhong;
    private String hoTenKhachHang;
    private String chungMinhThuNhanDan;
    private LocalDate ngayNhan;
    private LocalDate ngayTraDuKien;
    private LocalDate ngayTraThucTe;

    public PhieuNhanPhong() {
    }

    public PhieuNhanPhong(String maNhanPhong, String maPhieuThue, String maKhachHang) {
        this.maNhanPhong = maNhanPhong;
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
    }

    public PhieuNhanPhong(String maNhanPhong, String maPhieuThue, String maKhachHang, String maPhong, String hoTenKhachHang, String chungMinhThuNhanDan, LocalDate ngayNhan, LocalDate ngayTraDuKien, LocalDate ngayTraThucTe) {
        this.maNhanPhong = maNhanPhong;
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
        this.maPhong = maPhong;
        this.hoTenKhachHang = hoTenKhachHang;
        this.chungMinhThuNhanDan = chungMinhThuNhanDan;
        this.ngayNhan = ngayNhan;
        this.ngayTraDuKien = ngayTraDuKien;
        this.ngayTraThucTe = ngayTraThucTe;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getHoTenKhachHang() {
        return hoTenKhachHang;
    }

    public void setHoTenKhachHang(String hoTenKhachHang) {
        this.hoTenKhachHang = hoTenKhachHang;
    }

    public String getChungMinhThuNhanDan() {
        return chungMinhThuNhanDan;
    }

    public void setChungMinhThuNhanDan(String chungMinhThuNhanDan) {
        this.chungMinhThuNhanDan = chungMinhThuNhanDan;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public LocalDate getNgayTraDuKien() {
        return ngayTraDuKien;
    }

    public void setNgayTraDuKien(LocalDate ngayTraDuKien) {
        this.ngayTraDuKien = ngayTraDuKien;
    }

    public LocalDate getNgayTraThucTe() {
        return ngayTraThucTe;
    }

    public void setNgayTraThucTe(LocalDate ngayTraThucTe) {
        this.ngayTraThucTe = ngayTraThucTe;
    }

    public String getMaNhanPhong() {
        return maNhanPhong;
    }

    public void setMaNhanPhong(String maNhanPhong) {
        this.maNhanPhong = maNhanPhong;
    }

    public String getMaPhieuThue() {
        return maPhieuThue;
    }

    public void setMaPhieuThue(String maPhieuThue) {
        this.maPhieuThue = maPhieuThue;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

}
