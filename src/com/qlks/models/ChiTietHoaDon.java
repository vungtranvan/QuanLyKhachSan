
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
public class ChiTietHoaDon {

    private String maHoaDon;
    private String maPhong;
    private String maSuDungDichVu;
    private String maChinhSach;
    private float phuThu;
    private float tienPhong;
    private float tienDichVu;
    private float giamGiaKH;
    private String hinhThucThanhToan;
    private int soNgay;
    private float thanhTien;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHoaDon, String maPhong, String maSuDungDichVu, String maChinhSach, float phuThu, float tienPhong, float tienDichVu, float giamGiaKH, String hinhThucThanhToan, int soNgay, float thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maPhong = maPhong;
        this.maSuDungDichVu = maSuDungDichVu;
        this.maChinhSach = maChinhSach;
        this.phuThu = phuThu;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.giamGiaKH = giamGiaKH;
        this.hinhThucThanhToan = hinhThucThanhToan;
        this.soNgay = soNgay;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaSuDungDichVu() {
        return maSuDungDichVu;
    }

    public void setMaSuDungDichVu(String maSuDungDichVu) {
        this.maSuDungDichVu = maSuDungDichVu;
    }

    public String getMaChinhSach() {
        return maChinhSach;
    }

    public void setMaChinhSach(String maChinhSach) {
        this.maChinhSach = maChinhSach;
    }

    public float getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(float phuThu) {
        this.phuThu = phuThu;
    }

    public float getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(float tienPhong) {
        this.tienPhong = tienPhong;
    }

    public float getTienDichVu() {
        return tienDichVu;
    }

    public void setTienDichVu(float tienDichVu) {
        this.tienDichVu = tienDichVu;
    }

    public float getGiamGiaKH() {
        return giamGiaKH;
    }

    public void setGiamGiaKH(float giamGiaKH) {
        this.giamGiaKH = giamGiaKH;
    }

    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

}