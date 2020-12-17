/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.models;

/**
 *
 * @author hello
 */
public class PhieuNhanPhong {

    private String maNhanPhong;
    private String maPhieuThue;
    private String maKhachHang;

    public PhieuNhanPhong() {
    }

    public PhieuNhanPhong(String maNhanPhong, String maPhieuThue, String maKhachHang) {
        this.maNhanPhong = maNhanPhong;
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
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
