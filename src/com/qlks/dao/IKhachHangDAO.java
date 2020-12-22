/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.KhachHang;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IKhachHangDAO {

    List<KhachHang> getAll();

    List<KhachHang> search(String maKhachHang, String tenKhachHang, String CMND, String diaChi, int dienThoai, Boolean gioiTinh, String quocTich);

    int add(KhachHang khachHang);

    int update(KhachHang khachHang);

    int delete(String maKhachHang);

}
