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
    private String tenLoaiPhong;
    private String tenLoaiTinhTrangPhong;
    private float donGia;
    private String ghiChu;

    public Phong() {
    }

    public Phong(String maPhong, String maLoaiPhong, int maLoaiTinhTrangPhong, String tenLoaiPhong, String tenLoaiTinhTrangPhong, float donGia, String ghiChu) {
        this.maPhong = maPhong;
        this.maLoaiPhong = maLoaiPhong;
        this.maLoaiTinhTrangPhong = maLoaiTinhTrangPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.tenLoaiTinhTrangPhong = tenLoaiTinhTrangPhong;
        this.donGia = donGia;
        this.ghiChu = ghiChu;
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

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public String getTenLoaiTinhTrangPhong() {
        return tenLoaiTinhTrangPhong;
    }

    public void setTenLoaiTinhTrangPhong(String tenLoaiTinhTrangPhong) {
        this.tenLoaiTinhTrangPhong = tenLoaiTinhTrangPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return maPhong;
    }

}
