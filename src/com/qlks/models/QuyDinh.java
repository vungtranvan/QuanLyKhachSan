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
public class QuyDinh {

    private String tenQuyDinh;
    private String moTa;

    public QuyDinh() {
    }

    public QuyDinh(String tenQuyDinh, String moTa) {
        this.tenQuyDinh = tenQuyDinh;
        this.moTa = moTa;
    }

    public String getTenQuyDinh() {
        return tenQuyDinh;
    }

    public void setTenQuyDinh(String tenQuyDinh) {
        this.tenQuyDinh = tenQuyDinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
