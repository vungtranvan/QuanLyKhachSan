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
public class ThongKeKhachHangmd {

    private String maPhong;
    private String tenKhachHang;
    private String chungMinhThuNhanDan;
    private boolean gioiTinh;
    private String dienThoai;
    private String diaChi;
    private String quocTich;
    private LocalDate ngayNhan;
    private LocalDate ngayTraThucTe;

    public ThongKeKhachHangmd() {
    }

    public ThongKeKhachHangmd(String maPhong, String tenKhachHang, String chungMinhThuNhanDan, boolean gioiTinh, String dienThoai, String diaChi, String quocTich, LocalDate ngayNhan, LocalDate ngayTraThucTe) {
        this.maPhong = maPhong;
        this.tenKhachHang = tenKhachHang;
        this.chungMinhThuNhanDan = chungMinhThuNhanDan;
        this.gioiTinh = gioiTinh;
        this.dienThoai = dienThoai;
        this.diaChi = diaChi;
        this.quocTich = quocTich;
        this.ngayNhan = ngayNhan;
        this.ngayTraThucTe = ngayTraThucTe;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
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

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    public LocalDate getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(LocalDate ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public LocalDate getNgayTraThucTe() {
        return ngayTraThucTe;
    }

    public void setNgayTraThucTe(LocalDate ngayTraThucTe) {
        this.ngayTraThucTe = ngayTraThucTe;
    }

}
