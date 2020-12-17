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
public class ChinhSachTraPhong {

    private String maChinhSach;
    private String noiDung;
    private float phuThu;

    public ChinhSachTraPhong() {
    }

    public ChinhSachTraPhong(String maChinhSach, String noiDung, float phuThu) {
        this.maChinhSach = maChinhSach;
        this.noiDung = noiDung;
        this.phuThu = phuThu;
    }

    public String getMaChinhSach() {
        return maChinhSach;
    }

    public void setMaChinhSach(String maChinhSach) {
        this.maChinhSach = maChinhSach;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public float getPhuThu() {
        return phuThu;
    }

    public void setPhuThu(float phuThu) {
        this.phuThu = phuThu;
    }

}
