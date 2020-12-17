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
public class ChiTietPhieuThuePhong {

    private String maPhieuThue;
    private String maPhong;
    private LocalDate ngayDangKy;
    private LocalDate ngayNhan;

    public ChiTietPhieuThuePhong() {
    }

    public ChiTietPhieuThuePhong(String maPhieuThue, String maPhong, LocalDate ngayDangKy, LocalDate ngayNhan) {
        this.maPhieuThue = maPhieuThue;
        this.maPhong = maPhong;
        this.ngayDangKy = ngayDangKy;
        this.ngayNhan = ngayNhan;
    }

    public String getMaPhieuThue() {
        return maPhieuThue;
    }

    public void setMaPhieuThue(String maPhieuThue) {
        this.maPhieuThue = maPhieuThue;
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

}
