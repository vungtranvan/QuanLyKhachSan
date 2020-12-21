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
public class KhuyenMai {

    private int maKhuyenMai;
    private String maPhieu;
    private float giaTri;
    private String noiDung;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private boolean kieuTinh;
    private boolean trangThai;

    public KhuyenMai() {
    }

    public KhuyenMai(String maPhieu, float giaTri, String noiDung, LocalDate ngayBatDau, LocalDate ngayKetThuc, boolean kieuTinh, boolean trangThai) {
        this.maPhieu = maPhieu;
        this.giaTri = giaTri;
        this.noiDung = noiDung;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.kieuTinh = kieuTinh;
        this.trangThai = trangThai;
    }

    public KhuyenMai(int maKhuyenMai, String maPhieu, float giaTri, String noiDung, LocalDate ngayBatDau, LocalDate ngayKetThuc, boolean kieuTinh, boolean trangThai) {
        this.maKhuyenMai = maKhuyenMai;
        this.maPhieu = maPhieu;
        this.giaTri = giaTri;
        this.noiDung = noiDung;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.kieuTinh = kieuTinh;
        this.trangThai = trangThai;
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

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public boolean isKieuTinh() {
        return kieuTinh;
    }

    public void setKieuTinh(boolean kieuTinh) {
        this.kieuTinh = kieuTinh;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

}
