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
    public List<KhuyenMai> search(int maKhuyenMai, String maPhieu, float giaTri, String noiDung, LocalDate ngayBatDau, LocalDate ngayKetThuc, Boolean kieuTinh, Boolean trangThai) {
        String sql = "{Call SearchKhuyenMai(?,?,?,?,?,?,?,?)}";
        return query(sql, new KhuyenMaiMapper(), maKhuyenMai, maPhieu, giaTri, noiDung, ngayBatDau, ngayKetThuc, kieuTinh, trangThai);
    }

    @Override
    public void add(KhuyenMai khuyenMai) {
        String sql = "{Call insertKhuyenMai(?,?,?,?,?,?,?)}";
        this.update(sql, khuyenMai.getMaPhieu(), khuyenMai.getGiaTri(), khuyenMai.getNoiDung(), khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc(), khuyenMai.isKieuTinh(), khuyenMai.isTrangThai());
    }

    @Override
    public void update(KhuyenMai khuyenMai) {
        String sql = "{Call updateKhuyenMai(?,?,?,?,?,?,?,?)}";
        this.update(sql, khuyenMai.getMaKhuyenMai(), khuyenMai.getMaPhieu(), khuyenMai.getGiaTri(), khuyenMai.getNoiDung(), khuyenMai.getNgayBatDau(), khuyenMai.getNgayKetThuc(), khuyenMai.isKieuTinh(), khuyenMai.isTrangThai());
    }

    @Override
    public void delete(int maKhuyenMai) {
        String sql = "{Call deleteKhuyenMai(?)}";
        this.update(sql, maKhuyenMai);
    }

}
