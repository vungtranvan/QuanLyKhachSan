/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.ILoaiDichVuDAO;
import com.qlks.mapper.LoaiDichVuMapper;
import com.qlks.models.LoaiDichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public class LoaiDichVuDAO extends AbstractDAO<LoaiDichVu> implements ILoaiDichVuDAO {

    @Override
    public List<LoaiDichVu> getAll() {
        String sql = "{Call getAllLoaiDichVu}";
        return query(sql, new LoaiDichVuMapper());
    }

    @Override
    public List<LoaiDichVu> search(String maLoaiDichVu, String tenLoaiDichVu) {
        String sql = "{Call SearchLoaiDichVu(?,?)}";
        return query(sql, new LoaiDichVuMapper(), maLoaiDichVu, tenLoaiDichVu);
    }

    @Override
    public void add(LoaiDichVu loaiDichVu) {
        String sql = "{Call insertLoaiDichVu(?,?)}";
        this.update(sql, loaiDichVu.getMaLoaiDichVu(), loaiDichVu.getTenLoaiDichVu());
    }

    @Override
    public void update(LoaiDichVu loaiDichVu) {
        String sql = "{Call updateLoaiDichVu(?,?)}";
        this.update(sql, loaiDichVu.getMaLoaiDichVu(), loaiDichVu.getTenLoaiDichVu());
    }

    @Override
    public void delete(String maLoaiDichVu) {
        String sql = "{Call deleteLoaiDichVu(?,?)}";
        this.update(sql, maLoaiDichVu);
    }

}
