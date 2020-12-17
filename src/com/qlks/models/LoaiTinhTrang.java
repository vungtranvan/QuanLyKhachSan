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
public class LoaiTinhTrang {

    private int maLoaiTinhTrangPhong;
    private String tenLoaiTinhTrang;

    public LoaiTinhTrang() {
    }

    public LoaiTinhTrang(String tenLoaiTinhTrang) {
        this.tenLoaiTinhTrang = tenLoaiTinhTrang;
    }

    public LoaiTinhTrang(int maLoaiTinhTrangPhong, String tenLoaiTinhTrang) {
        this.maLoaiTinhTrangPhong = maLoaiTinhTrangPhong;
        this.tenLoaiTinhTrang = tenLoaiTinhTrang;
    }

    public int getMaLoaiTinhTrangPhong() {
        return maLoaiTinhTrangPhong;
    }

    public void setMaLoaiTinhTrangPhong(int maLoaiTinhTrangPhong) {
        this.maLoaiTinhTrangPhong = maLoaiTinhTrangPhong;
    }

    public String getTenLoaiTinhTrang() {
        return tenLoaiTinhTrang;
    }

    public void setTenLoaiTinhTrang(String tenLoaiTinhTrang) {
        this.tenLoaiTinhTrang = tenLoaiTinhTrang;
    }

}
