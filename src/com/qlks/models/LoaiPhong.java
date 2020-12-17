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
public class LoaiPhong {

    private String maLoaiPhong;
    private String tenLoaiPhong;
    private float donGia;
    private int soNguoiChuan;
    private int soNguoiToiDa;
    private float tyLeTang;

    public LoaiPhong() {
    }

    public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, float donGia, int soNguoiChuan, int soNguoiToiDa, float tyLeTang) {
        this.maLoaiPhong = maLoaiPhong;
        this.tenLoaiPhong = tenLoaiPhong;
        this.donGia = donGia;
        this.soNguoiChuan = soNguoiChuan;
        this.soNguoiToiDa = soNguoiToiDa;
        this.tyLeTang = tyLeTang;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return tenLoaiPhong;
    }

    public void setTenLoaiPhong(String tenLoaiPhong) {
        this.tenLoaiPhong = tenLoaiPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoNguoiChuan() {
        return soNguoiChuan;
    }

    public void setSoNguoiChuan(int soNguoiChuan) {
        this.soNguoiChuan = soNguoiChuan;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public float getTyLeTang() {
        return tyLeTang;
    }

    public void setTyLeTang(float tyLeTang) {
        this.tyLeTang = tyLeTang;
    }

}
