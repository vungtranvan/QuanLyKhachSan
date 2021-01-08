/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IPhieuThuePhongDAO;
import com.qlks.mapper.PhieuThuePhongMapper;
import com.qlks.models.PhieuThuePhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class PhieuThuePhongDAO extends AbstractDAO<PhieuThuePhong> implements IPhieuThuePhongDAO {

    @Override
    public List<PhieuThuePhong> getAll() {
        String sql = "{Call getAllPhieuThuePhong}";
        return query(sql, new PhieuThuePhongMapper());
    }

    @Override
    public List<PhieuThuePhong> getChuaXuLy() {
        String sql = "{Call getPhieuThuePhong_ChuaXL}";
        return query(sql, new PhieuThuePhongMapper());
    }

    @Override
    public List<PhieuThuePhong> getChuaXuLy(String maPhieu, String maKH) {
        String sql = "{Call getPhieuThuePhong_ChuaXL_ByMa(?,?)}";
        return query(sql, new PhieuThuePhongMapper(), maPhieu, maKH);
    }

    @Override
    public List<PhieuThuePhong> getByMaPhieuThue(String maPhieu) {
        String sql = "{Call getPhieuNhanPhong_ByMaPhieuThue(?)}";
        return query(sql, new PhieuThuePhongMapper(), maPhieu);
    }

    @Override
    public List<PhieuThuePhong> search(String maPhieu, String tenKH, String maPhong) {
        String sql = "{Call SearchThuePhong(?,?,?)}";
        return query(sql, new PhieuThuePhongMapper(), maPhieu, tenKH, maPhong);
    }

    @Override
    public int add(PhieuThuePhong phieuThuePhong) {
        String sql = "{Call insertPhieuThuePhong(?,?)}";
        return this.update(sql, phieuThuePhong.getMaPhieuThue(), phieuThuePhong.getMaKhachHang());
    }

    @Override
    public int delete(String maPhieuThue) {
        String sql = "{Call deletePhieuThuePhong(?)}";
        return this.update(sql, maPhieuThue);
    }

    @Override
    public int updateTrangThai(String maPhieuThue) {
        String sql = "{Call updateTrangThaiPhieuThue(?)}";
        return this.update(sql, maPhieuThue);
    }

}
