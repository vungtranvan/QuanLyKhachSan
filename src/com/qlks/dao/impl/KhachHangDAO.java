/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IKhachHangDAO;
import com.qlks.mapper.KhachHangMapper;
import com.qlks.models.KhachHang;
import java.util.List;

/**
 *
 * @author hello
 */
public class KhachHangDAO extends AbstractDAO<KhachHang> implements IKhachHangDAO {

    @Override
    public List<KhachHang> getAll() {
        String sql = "{Call getAllKhachHang}";
        return query(sql, new KhachHangMapper());
    }

    @Override
    public List<KhachHang> getByMa(String maKhachHang) {
        String sql = "{Call getKhachHangByMa(?)}";
        return query(sql, new KhachHangMapper(),maKhachHang);
    }

    @Override
    public List<KhachHang> search(String maKhachHang, String tenKhachHang, String CMND, String diaChi, int dienThoai, Boolean gioiTinh, String quocTich) {
        String sql = "{Call SearchKhachHang(?,?,?,?,?,?,?)}";
        return query(sql, new KhachHangMapper(), maKhachHang, tenKhachHang, CMND, diaChi, dienThoai, gioiTinh, quocTich);
    }

    @Override
    public int add(KhachHang khachHang) {
        String sql = "{Call insertKhachHang(?,?,?,?,?,?,?)}";
        return this.update(sql, khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getChungMinhThuNhanDan(),
                khachHang.getDiaChi(), khachHang.getDienThoai(), khachHang.isGioiTinh(), khachHang.getQuocTich());
    }

    @Override
    public int update(KhachHang khachHang) {
        String sql = "{Call updateKhachHang(?,?,?,?,?,?,?)}";
        return this.update(sql, khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getChungMinhThuNhanDan(),
                khachHang.getDiaChi(), khachHang.getDienThoai(), khachHang.isGioiTinh(), khachHang.getQuocTich());
    }

    @Override
    public int delete(String maKhachHang) {
        String sql = "{Call deleteKhachHang(?)}";
        return this.update(sql, maKhachHang);
    }

}
