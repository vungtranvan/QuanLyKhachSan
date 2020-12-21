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
    public List<KhachHang> search(String maKhachHang, String tenKhachHang, String CMND, String diaChi, int dienThoai, Boolean gioiTinh, String quocTich) {
        String sql = "{Call SearchKhachHang(?,?,?,?,?,?,?)}";
        return query(sql, new KhachHangMapper(), maKhachHang, tenKhachHang, CMND, diaChi, dienThoai, gioiTinh, quocTich);
    }
    
    @Override
    public void add(KhachHang khachHang) {
        String sql = "{Call insertKhachHang(?,?,?,?,?,?,?)}";
        this.update(sql, khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getChungMinhThuNhanDan(),
                khachHang.getDiaChi(), khachHang.getDienThoai(), khachHang.isGioiTinh(), khachHang.getQuocTich());
    }
    
    @Override
    public void update(KhachHang khachHang) {
        String sql = "{Call updateKhachHang(?,?,?,?,?,?,?)}";
        this.update(sql, khachHang.getMaKhachHang(), khachHang.getTenKhachHang(), khachHang.getChungMinhThuNhanDan(),
                khachHang.getDiaChi(), khachHang.getDienThoai(), khachHang.isGioiTinh(), khachHang.getQuocTich());
    }
    
    @Override
    public void delete(String maKhachHang) {
//        if (maKhachHang == null) {
//             maKhachHang = "";
//        }
        String sql = "{Call deleteKhachHang(?)}";
        this.update(sql, maKhachHang);
    }
    
}
