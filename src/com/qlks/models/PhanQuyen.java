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

    public PhanQuyen() {
    }

    public PhanQuyen(int maQuyen, int maNhomQuyen) {
        this.maQuyen = maQuyen;
        this.maNhomQuyen = maNhomQuyen;
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

}
