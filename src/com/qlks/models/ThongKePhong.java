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
public class ThongKePhong {

    private String maPhong;
    private int soNgay;
    private float tienPhong;
    private float giamGia;
    private float thanhTien;
    private float TienDichVu;

    public ThongKePhong() {
    }

    public ThongKePhong(String maPhong, int soNgay, float tienPhong, float giamGia, float thanhTien, float TienDichVu) {
        this.maPhong = maPhong;
        this.soNgay = soNgay;
        this.tienPhong = tienPhong;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
        this.TienDichVu = TienDichVu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public float getTienPhong() {
        return tienPhong;
    }

    public void setTienPhong(float tienPhong) {
        this.tienPhong = tienPhong;
    }

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public float getTienDichVu() {
        return TienDichVu;
    }

    public void setTienDichVu(float TienDichVu) {
        this.TienDichVu = TienDichVu;
    }

}
