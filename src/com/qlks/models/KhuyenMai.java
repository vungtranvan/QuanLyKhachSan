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
public class KhuyenMai {

    private int maKhuyenMai;
    private String maPhieu;
    private float giaTri;
    private String noiDung;
    private boolean kieuTinh;

    public KhuyenMai() {
    }

    public KhuyenMai(String maPhieu, float giaTri, String noiDung, boolean kieuTinh) {
        this.maPhieu = maPhieu;
        this.giaTri = giaTri;
        this.noiDung = noiDung;
        this.kieuTinh = kieuTinh;
    }

    public KhuyenMai(int maKhuyenMai, String maPhieu, float giaTri, String noiDung, boolean kieuTinh) {
        this.maKhuyenMai = maKhuyenMai;
        this.maPhieu = maPhieu;
        this.giaTri = giaTri;
        this.noiDung = noiDung;
        this.kieuTinh = kieuTinh;
    }

    public int getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(int maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public float getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(float giaTri) {
        this.giaTri = giaTri;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public boolean isKieuTinh() {
        return kieuTinh;
    }

    public void setKieuTinh(boolean kieuTinh) {
        this.kieuTinh = kieuTinh;
    }

}
