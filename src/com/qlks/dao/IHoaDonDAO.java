/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.HoaDon;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IHoaDonDAO {

    List<HoaDon> getAll();

    List<HoaDon> getByMaHoaDon(int maHoaDon);

    List<HoaDon> getByMaKhachHang(String maKhachHang);

    List<HoaDon> getByMaNhanPhong(String maNhanPhong);

    List<HoaDon> search(int maHoaDon, String maKhachHang, String maNhanPhong, String nhanVienLap, LocalDateTime ngayLap);

    int add(HoaDon hoaDon);

    int update(HoaDon hoaDon);

    int delete(int maHoaDon);
}
