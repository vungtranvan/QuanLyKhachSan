/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IPhieuNhanPhongDAO;
import com.qlks.mapper.PhieuNhanPhongMapper;
import com.qlks.models.PhieuNhanPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class PhieuNhanPhongDAO extends AbstractDAO<PhieuNhanPhong> implements IPhieuNhanPhongDAO {

    @Override
    public List<PhieuNhanPhong> getAll() {
        String sql = "{Call getAllPhieuNhanPhong}";
        return query(sql, new PhieuNhanPhongMapper());
    }

    @Override
    public List<PhieuNhanPhong> getByMaNhanPhong(String maNhanPhong) {
        String sql = "{Call getPhieuNhanPhongByMaNhanPhong(?)}";
        return query(sql, new PhieuNhanPhongMapper(), maNhanPhong);
    }

    @Override
    public List<PhieuNhanPhong> getByMaPhieuThue(String maPhieu) {
        String sql = "{Call getPhieuNhanPhong_ByMaPhieuThue(?)}";
        return query(sql, new PhieuNhanPhongMapper(), maPhieu);
    }

    @Override
    public List<PhieuNhanPhong> search(String maPhong, String tenKH, String CMND) {
        String sql = "{Call SearchPhieuNhanPhong(?,?,?)}";
        return query(sql, new PhieuNhanPhongMapper(), maPhong, tenKH, CMND);
    }

    @Override
    public int add(PhieuNhanPhong phieuNhanPhong) {
        String sql = "{Call insertPhieuNhanPhong(?,?,?)}";
        return this.update(sql, phieuNhanPhong.getMaNhanPhong(), phieuNhanPhong.getMaPhieuThue(), phieuNhanPhong.getMaKhachHang());
    }

    @Override
    public int update(PhieuNhanPhong phieuNhanPhong) {
        String sql = "{Call updatePhieuNhanPhong(?,?,?)}";
        return this.update(sql, phieuNhanPhong.getMaNhanPhong(), phieuNhanPhong.getMaPhieuThue(), phieuNhanPhong.getMaKhachHang());
    }

    @Override
    public int delete(String maNhanPhong) {
        String sql = "{Call deletePhieuNhanPhong(?)}";
        return this.update(sql, maNhanPhong);
    }

    @Override
    public int updateTrangThai(String maNhanPhong) {
        String sql = "{Call updateTrangThaiPhieuNhanPhong(?)}";
        return this.update(sql, maNhanPhong);
    }

}
