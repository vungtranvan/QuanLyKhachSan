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
    public List<PhieuNhanPhong> search(String maNhanPhong, String maPhieuThue, String maKhachHang) {
        String sql = "{Call SearchPhieuNhanPhong(?,?,?)}";
        return query(sql, new PhieuNhanPhongMapper(), maNhanPhong, maPhieuThue, maKhachHang);
    }

    @Override
    public void add(PhieuNhanPhong phieuNhanPhong) {
        String sql = "{Call insertPhieuNhanPhong(?,?,?)}";
        this.update(sql, phieuNhanPhong.getMaNhanPhong(), phieuNhanPhong.getMaPhieuThue(), phieuNhanPhong.getMaKhachHang());
    }

    @Override
    public void update(PhieuNhanPhong phieuNhanPhong) {
        String sql = "{Call updatePhieuNhanPhong(?,?,?)}";
        this.update(sql, phieuNhanPhong.getMaNhanPhong(), phieuNhanPhong.getMaPhieuThue(), phieuNhanPhong.getMaKhachHang());
    }

    @Override
    public void delete(String maNhanPhong) {
        String sql = "{Call deletePhieuNhanPhong(?)}";
        this.update(sql, maNhanPhong);
    }

}
