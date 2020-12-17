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
public class ThietBi {

    private String maThietBi;
    private String maLoaiPhong;
    private String tenThietBi;
    private int soLuong;
    private float gia;

    public ThietBi() {
    }

    public ThietBi(String maThietBi, String maLoaiPhong, String tenThietBi, int soLuong, float gia) {
        this.maThietBi = maThietBi;
        this.maLoaiPhong = maLoaiPhong;
        this.tenThietBi = tenThietBi;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaThietBi() {
        return maThietBi;
    }

    public void setMaThietBi(String maThietBi) {
        this.maThietBi = maThietBi;
    }

    public String getMaLoaiPhong() {
        return maLoaiPhong;
    }

    public void setMaLoaiPhong(String maLoaiPhong) {
        this.maLoaiPhong = maLoaiPhong;
    }

    public String getTenThietBi() {
        return tenThietBi;
    }

    public void setTenThietBi(String tenThietBi) {
        this.tenThietBi = tenThietBi;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

}
