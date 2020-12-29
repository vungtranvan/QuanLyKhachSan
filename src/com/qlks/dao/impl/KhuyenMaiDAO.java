/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IKhuyenMaiDAO;
import com.qlks.mapper.KhuyenMaiMapper;
import com.qlks.models.KhuyenMai;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class KhuyenMaiDAO extends AbstractDAO<KhuyenMai> implements IKhuyenMaiDAO {

    @Override
    public List<KhuyenMai> getAll() {
        String sql = "{Call getAllKhuyenMai}";
        return query(sql, new KhuyenMaiMapper());
    }

    @Override
    public List<KhuyenMai> getByMaKhuyenMai(int maKhuyenMai) {
        String sql = "{Call getByMaKhuyenMai(?)}";
        return query(sql, new KhuyenMaiMapper(), maKhuyenMai);
    }

    @Override
    public List<KhuyenMai> getByMaPhieuKhuyenMai(String maPhieu) {
        String sql = "{Call getByMaPhieuKhuyenMai(?)}";
        return query(sql, new KhuyenMaiMapper(), maPhieu);
    }

    @Override
    public List<KhuyenMai> search(String maPhieu, String noiDung, Boolean trangThai) {
        String sql = "{Call SearchKhuyenMai_YesTrangThai(?,?,?)}";
        return query(sql, new KhuyenMaiMapper(), maPhieu, noiDung, trangThai);
    }

    @Override
    public List<KhuyenMai> search(String maPhieu, String noiDung) {
        String sql = "{Call SearchKhuyenMai_NoTrangThai(?,?)}";
        return query(sql, new KhuyenMaiMapper(), maPhieu, noiDung);
    }

    @Override
    public int add(KhuyenMai khuyenMai) {
        String sql = "{Call insertKhuyenMai(?,?,?,?,?,?,?)}";
        return this.update(sql, khuyenMai.getMaPhieu(), khuyenMai.getGiaTri(), khuyenMai.getNoiDung(), khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc(), khuyenMai.isKieuTinh(), khuyenMai.isTrangThai());
    }

    @Override
    public int update(KhuyenMai khuyenMai) {
        String sql = "{Call updateKhuyenMai(?,?,?,?,?,?,?,?)}";
        return this.update(sql, khuyenMai.getMaKhuyenMai(), khuyenMai.getMaPhieu(), khuyenMai.getGiaTri(), khuyenMai.getNoiDung(), khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc(), khuyenMai.isKieuTinh(), khuyenMai.isTrangThai());
    }

    @Override
    public int delete(int maKhuyenMai) {
        String sql = "{Call deleteKhuyenMai(?)}";
        return this.update(sql, maKhuyenMai);
    }

}
