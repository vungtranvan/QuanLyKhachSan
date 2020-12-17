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
public class Phong {

    private String maPhong;
    private String maLoaiPhong;
    private int maLoaiTinhTrangPhong;
    private String ghiChu;

    public Phong() {
    }

    public Phong(String maPhong, String maLoaiPhong, int maLoaiTinhTrangPhong, String ghiChu) {
        this.maPhong = maPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.maLoaiTinhTrangPhong = maLoaiTinhTrangPhong;
        this.ghiChu = ghiChu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public int getMaLoaiTinhTrangPhong() {
        return maLoaiTinhTrangPhong;
    }

    public void setMaLoaiTinhTrangPhong(int maLoaiTinhTrangPhong) {
        this.maLoaiTinhTrangPhong = maLoaiTinhTrangPhong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
