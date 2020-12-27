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
    public List<DichVu> search(String maDichVu, String maLoaiDichVu, String maDonVi) {
        String sql = "{Call SearchDichVu(?,?,?}";
        return query(sql, new DichVuMapper(), maDichVu, maLoaiDichVu, maDonVi);
    }

    @Override
    public int add(DichVu dichVu) {
        String sql = "{Call insertDichVu(?,?,?,?)}";
        return this.update(sql, dichVu.getMaDichVu(), dichVu.getMaLoaiDichVu(), dichVu.getMaDonVi(), dichVu.getDonGia());
    }

    @Override
    public int update(DichVu dichVu) {
        String sql = "{Call updateDichVu(?,?,?,?)}";
        return this.update(sql, dichVu.getMaDichVu(), dichVu.getMaLoaiDichVu(), dichVu.getMaDonVi(), dichVu.getDonGia());
    }

    @Override
    public int delete(String maDichVu) {
        String sql = "{Call deleteDichVu(?)}";
        return this.update(sql, maDichVu);
    }

}
