/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IChiTietPhieuThuePhongDAO;
import com.qlks.mapper.ChiTietPhieuThuePhongMapper;
import com.qlks.models.ChiTietPhieuThuePhong;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class ChiTietPhieuThuePhongDAO extends AbstractDAO<ChiTietPhieuThuePhong> implements IChiTietPhieuThuePhongDAO {

    @Override
    public List<ChiTietPhieuThuePhong> getAll() {
        String sql = "{Call getAllChiTietPhieuThuePhong}";
        return query(sql, new ChiTietPhieuThuePhongMapper());
    }

    @Override
    public List<ChiTietPhieuThuePhong> getByMaPhieuThue(String maPhieuThue) {
        String sql = "{Call getByMaPhieuThue(?)}";
        return query(sql, new ChiTietPhieuThuePhongMapper(), maPhieuThue);
    }

    @Override
    public int add(ChiTietPhieuThuePhong ct) {
        String sql = "{Call insertChiTietPhieuThuePhong(?,?,?,?,?)}";
        return this.update(sql, ct.getMaPhieuThue(), ct.getMaPhong(), ct.getNgayDangKy(), ct.getNgayNhan(), ct.getNgayTraDuKien());
    }

    @Override
    public int delete(String maPhieuThue) {
        String sql = "{Call deleteChiTietPhieuThuePhong(?)}";
        return this.update(sql, maPhieuThue);
    }

    @Override
    public int update(String maPhieuThue, LocalDate ngayDKy, LocalDate ngayNhan) {
        String sql = "{Call updateChiTietPhieuThuePhong(?,?,?)}";
        return this.update(sql, maPhieuThue, ngayDKy, ngayNhan);
    }

}
