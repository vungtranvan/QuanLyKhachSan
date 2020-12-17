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
public class PhieuThuePhong {

    private String maPhieuThue;
    private String maKhachHang;

    public PhieuThuePhong() {
    }

    public PhieuThuePhong(String maPhieuThue, String maKhachHang) {
        this.maPhieuThue = maPhieuThue;
        this.maKhachHang = maKhachHang;
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
