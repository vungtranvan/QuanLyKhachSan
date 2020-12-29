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
public class PhanQuyen {

    private int maQuyen;
    private int maNhomQuyen;
    private String Quyen;

    public PhanQuyen() {
    }

    public PhanQuyen(int maQuyen, int maNhomQuyen) {
        this.maQuyen = maQuyen;
        this.maNhomQuyen = maNhomQuyen;
    }

    public PhanQuyen(int maQuyen, int maNhomQuyen, String Quyen) {
        this.maQuyen = maQuyen;
        this.maNhomQuyen = maNhomQuyen;
        this.Quyen = Quyen;
    }

    public int getMaQuyen() {
        return maQuyen;
    }

    public void setMaQuyen(int maQuyen) {
        this.maQuyen = maQuyen;
    }

    public int getMaNhomQuyen() {
        return maNhomQuyen;
    }

    public void setMaNhomQuyen(int maNhomQuyen) {
        this.maNhomQuyen = maNhomQuyen;
    }

    public String getQuyen() {
        return Quyen;
    }

    public void setQuyen(String Quyen) {
        this.Quyen = Quyen;
    }

}
