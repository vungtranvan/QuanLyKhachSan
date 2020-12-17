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
public class KhachHang {

    private String maKhachHang;
    private String tenKhachHang;
    private String chungMinhThuNhanDan;
    private String diaChi;
    private int dienThoai;
    private boolean gioiTinh;
    private String quocTich;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhachHang, String chungMinhThuNhanDan, String diaChi, int dienThoai, boolean gioiTinh, String quocTich) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.chungMinhThuNhanDan = chungMinhThuNhanDan;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.gioiTinh = gioiTinh;
        this.quocTich = quocTich;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getChungMinhThuNhanDan() {
        return chungMinhThuNhanDan;
    }

    public void setChungMinhThuNhanDan(String chungMinhThuNhanDan) {
        this.chungMinhThuNhanDan = chungMinhThuNhanDan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(int dienThoai) {
        this.dienThoai = dienThoai;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

}
