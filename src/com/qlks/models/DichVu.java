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
public class DichVu {

    private String maDichVu;
    private String maLoaiDichVu;
    private String maDonVi;
    private String tenLoaiDichVu;
    private String tenDonVi;
    private float donGia;

    public DichVu() {
    }

    public DichVu(String maDichVu, String maLoaiDichVu, String maDonVi, String tenLoaiDichVu, String tenDonVi, float donGia) {
        this.maDichVu = maDichVu;
        this.maLoaiDichVu = maLoaiDichVu;
        this.maDonVi = maDonVi;
        this.tenLoaiDichVu = tenLoaiDichVu;
        this.tenDonVi = tenDonVi;
        this.donGia = donGia;
    }

    public DichVu(String maDichVu, String maLoaiDichVu, String maDonVi, float donGia) {
        this.maDichVu = maDichVu;
        this.maLoaiDichVu = maLoaiDichVu;
        this.maDonVi = maDonVi;
        this.donGia = donGia;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(String maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(String maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getMaDonVi() {
        return maDonVi;
    }

    public void setMaDonVi(String maDonVi) {
        this.maDonVi = maDonVi;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public String getTenDonVi() {
        return tenDonVi;
    }

    public void setTenDonVi(String tenDonVi) {
        this.tenDonVi = tenDonVi;
    }

    @Override
    public String toString() {
        return tenLoaiDichVu;
    }

}
