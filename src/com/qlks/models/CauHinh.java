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
public class CauHinh {

    private int maCauHinh;
    private String loaiCauHinh;

    public CauHinh() {
    }

    public CauHinh(String loaiCauHinh) {
        this.loaiCauHinh = loaiCauHinh;
    }

    public CauHinh(int maCauHinh, String loaiCauHinh) {
        this.maCauHinh = maCauHinh;
        this.loaiCauHinh = loaiCauHinh;
    }

    public int getMaCauHinh() {
        return maCauHinh;
    }

    public void setMaCauHinh(int maCauHinh) {
        this.maCauHinh = maCauHinh;
    }

    public String getLoaiCauHinh() {
        return loaiCauHinh;
    }

    public void setLoaiCauHinh(String loaiCauHinh) {
        this.loaiCauHinh = loaiCauHinh;
    }

}
