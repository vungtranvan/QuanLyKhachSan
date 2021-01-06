/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IHoaDonDAO;
import com.qlks.mapper.HoaDonMapper;
import com.qlks.models.HoaDon;
import java.util.List;

/**
 *
 * @author hello
 */
public class HoaDonDAO extends AbstractDAO<HoaDon> implements IHoaDonDAO {

    @Override
    public List<HoaDon> getAll() {
        String sql = "{Call getAllHoaDon}";
        return query(sql, new HoaDonMapper());
    }

    @Override
    public List<HoaDon> getByMaHoaDon(int maHoaDon) {
        String sql = "{Call getByMaHoaDon(?)}";
        return query(sql, new HoaDonMapper(), maHoaDon);
    }

    @Override
    public List<HoaDon> getByMaKhachHang(String maKhachHang) {
        String sql = "{Call getByMaKhachHang(?)}";
        return query(sql, new HoaDonMapper(), maKhachHang);
    }

    @Override
    public List<HoaDon> getByMaNhanPhong(String maNhanPhong) {
        String sql = "{Call getByMaNhanPhong(?)}";
        return query(sql, new HoaDonMapper(), maNhanPhong);
    }

    @Override
    public List<HoaDon> getIdMAX() {
        String sql = "{Call getHoaDonIdMAX}";
        return query(sql, new HoaDonMapper());
    }

    @Override
    public List<HoaDon> search(String tenKhachHang) {
        String sql = "{Call SearchHoaDon(?)}";
        return query(sql, new HoaDonMapper(), tenKhachHang);
    }

    @Override
    public int add(HoaDon hoaDon) {
        String sql = "{Call insertHoaDon(?,?,?,?,?,?)}";
        return this.update(sql, hoaDon.getMaKhachHang(), hoaDon.getMaNhanPhong(),
                hoaDon.getMaKhuyenMai(), hoaDon.getNhanVienLap(), hoaDon.getTongTien(), hoaDon.getNgayLap());
    }


    @Override
    public int delete(int maHoaDon) {
        String sql = "{Call deleteHoaDon(?)}";
        return this.update(sql, maHoaDon);
    }

    @Override
    public int addNoKM(HoaDon hoaDon) {
       String sql = "{Call insertHoaDon_NoKM(?,?,?,?,?)}";
        return this.update(sql, hoaDon.getMaKhachHang(), hoaDon.getMaNhanPhong(), hoaDon.getNhanVienLap(), hoaDon.getTongTien(), hoaDon.getNgayLap());
    }

}
