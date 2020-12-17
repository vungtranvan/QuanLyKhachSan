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
public class CauHinhNguoiDung {

    private int maCauHinh;
    private int maNguoiDung;
    private String noiDungCauHinh;

    public CauHinhNguoiDung() {
    }

    public CauHinhNguoiDung(int maCauHinh, int maNguoiDung, String noiDungCauHinh) {
        this.maCauHinh = maCauHinh;
        this.maNguoiDung = maNguoiDung;
        this.noiDungCauHinh = noiDungCauHinh;
    }

    public int getMaCauHinh() {
        return maCauHinh;
    }

    public void setMaCauHinh(int maCauHinh) {
        this.maCauHinh = maCauHinh;
    }

    public int getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(int maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getNoiDungCauHinh() {
        return noiDungCauHinh;
    }

    public void setNoiDungCauHinh(String noiDungCauHinh) {
        this.noiDungCauHinh = noiDungCauHinh;
    }

}
