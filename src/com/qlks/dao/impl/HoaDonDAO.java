/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IHoaDonDAO;
import com.qlks.mapper.HoaDonMapper;
import com.qlks.models.HoaDon;
import java.time.LocalDateTime;
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
    public List<HoaDon> getByMaHoaDon(String maHoaDon) {
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
    public List<HoaDon> search(String maHoaDon, String maKhachHang, String maNhanPhong, int maKhuyenMai, String nhanVienLap, LocalDateTime ngayLap) {
        String sql = "{Call SearchNHoaDon(?,?,?,?,?,?)}";
        return query(sql, new HoaDonMapper(), maHoaDon, maKhachHang, maNhanPhong, maKhuyenMai, nhanVienLap, ngayLap);
    }

    @Override
    public void add(HoaDon hoaDon) {
        String sql = "{Call insertHoaDon(?,?,?,?,?,?,?)}";
        this.update(sql, hoaDon.getMaHoaDon(), hoaDon.getMaKhachHang(), hoaDon.getMaNhanPhong(),
                hoaDon.getMaKhuyenMai(), hoaDon.getNhanVienLap(), hoaDon.getTongTien(), hoaDon.getNgayLap());
    }

    @Override
    public void update(HoaDon hoaDon) {
        String sql = "{Call updateHoaDon(?,?,?,?,?,?,?)}";
        this.update(sql, hoaDon.getMaHoaDon(), hoaDon.getMaKhachHang(), hoaDon.getMaNhanPhong(),
                hoaDon.getMaKhuyenMai(), hoaDon.getNhanVienLap(), hoaDon.getTongTien(), hoaDon.getNgayLap());
    }

    @Override
    public void delete(String maHoaDon) {
        String sql = "{Call deleteHoaDon(?)}";
        this.update(sql, maHoaDon);
    }

}