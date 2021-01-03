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
public class PhieuThuePhong {

    private String maPhieuThue;
    private String maKhachHang;
    private String tenKhachHang;
    private String maPhong;
    private LocalDate ngayDangKy;
    private LocalDate ngayNhan;
    private boolean trangThai;

    public PhieuThuePhong() {
    }

    public PhieuThuePhong(String maPhieuThue, String maKhachHang) {
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
    }

    public PhieuThuePhong(String maPhieuThue, String maKhachHang, String tenKhachHang, String maPhong, LocalDate ngayDangKy, LocalDate ngayNhan, boolean trangThai) {
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.maPhong = maPhong;
        this.ngayDangKy = ngayDangKy;
        this.ngayNhan = ngayNhan;
        this.trangThai = trangThai;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public LocalDate getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(LocalDate ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
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
