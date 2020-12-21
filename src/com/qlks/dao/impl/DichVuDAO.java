/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IDichVuDAO;
import com.qlks.mapper.DichVuMapper;
import com.qlks.models.DichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public class DichVuDAO extends AbstractDAO<DichVu> implements IDichVuDAO {

    @Override
    public List<DichVu> getAll() {
        String sql = "{Call getAllDichVu}";
        return query(sql, new DichVuMapper());
    }

    @Override
    public List<DichVu> search(String maDichVu, String maLoaiDichVu, String maDonVi, float donGia) {
        String sql = "{Call SearchDichVu(?,?,?,?}";
        return query(sql, new DichVuMapper(), maDichVu, maLoaiDichVu, maDonVi, donGia);
    }

    @Override
    public void add(DichVu dichVu) {
        String sql = "{Call insertDichVu(?,?,?,?)}";
        this.update(sql, dichVu.getMaDichVu(), dichVu.getMaLoaiDichVu(), dichVu.getMaDonVi(), dichVu.getDonGia());
    }

    @Override
    public void update(DichVu dichVu) {
        String sql = "{Call updateDichVu(?,?,?,?)}";
        this.update(sql, dichVu.getMaDichVu(), dichVu.getMaLoaiDichVu(), dichVu.getMaDonVi(), dichVu.getDonGia());
    }

    @Override
    public void delete(String maDichVu) {
        String sql = "{Call deleteDichVu(?)}";
        this.update(sql, maDichVu);
    }

}
