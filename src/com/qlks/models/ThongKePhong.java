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
    private float hieuSuatPhong;
    private int soNgay;
    private int soLanThue;
    private float tienPhong;
    private float tienDichVu;
    private float giamGia;
    private float tongTien;

    public ThongKePhong() {
    }

    public ThongKePhong(String maPhong, int soNgay, int soLanThue, float tienPhong, float tienDichVu, float giamGia, float tongTien) {
        this.maPhong = maPhong;
        this.soNgay = soNgay;
        this.soLanThue = soLanThue;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.giamGia = giamGia;
        this.tongTien = tongTien;
    }

    public ThongKePhong(String maPhong, float hieuSuatPhong, int soNgay, int soLanThue, float tienPhong, float tienDichVu, float giamGia, float tongTien) {
        this.maPhong = maPhong;
        this.hieuSuatPhong = hieuSuatPhong;
        this.soNgay = soNgay;
        this.soLanThue = soLanThue;
        this.tienPhong = tienPhong;
        this.tienDichVu = tienDichVu;
        this.giamGia = giamGia;
        this.tongTien = tongTien;
    }

    public float getHieuSuatPhong() {
        return hieuSuatPhong;
    }

    public void setHieuSuatPhong(float hieuSuatPhong) {
        this.hieuSuatPhong = hieuSuatPhong;
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

    public int getSoLanThue() {
        return soLanThue;
    }

    public void setSoLanThue(int soLanThue) {
        this.soLanThue = soLanThue;
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

    public float getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(float giamGia) {
        this.giamGia = giamGia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

}
