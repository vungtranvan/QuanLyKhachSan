/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IChiTietHoaDonDAO {

    List<ChiTietHoaDon> getAll();

    List<ChiTietHoaDon> getByMaHoaDon(String maHoaDon);

    int add(ChiTietHoaDon ct);

    //void update(ChiTietHoaDon ct);
    //void delete(String maKhachHang);
}
