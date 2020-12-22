/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.ILoaiTinhTrangDAO;
import com.qlks.mapper.LoaiTinhTrangMapper;
import com.qlks.models.LoaiTinhTrang;
import java.util.List;

/**
 *
 * @author hello
 */
public class LoaiTinhTrangDAO extends AbstractDAO<LoaiTinhTrang> implements ILoaiTinhTrangDAO {

    @Override
    public List<LoaiTinhTrang> getAll() {
        String sql = "{Call getAllLoaiTinhTrang}";
        return query(sql, new LoaiTinhTrangMapper());
    }

    @Override
    public List<LoaiTinhTrang> getByMaLoaiTinhTrang(int maLoaiTinhTrang) {
        String sql = "{Call getByMaLoaiTinhTrang(?)}";
        return query(sql, new LoaiTinhTrangMapper(), maLoaiTinhTrang);
    }

    @Override
    public List<LoaiTinhTrang> search(int maLoaiTinhTrang, String tenLoaiTinhTrang) {
        String sql = "{Call SearchLoaiTinhTrang(?,?)}";
        return query(sql, new LoaiTinhTrangMapper(), maLoaiTinhTrang, tenLoaiTinhTrang);
    }

    @Override
    public int add(LoaiTinhTrang loaiTinhTrang) {
        String sql = "{Call insertLoaiTinhTrang(?)}";
        return this.update(sql, loaiTinhTrang.getTenLoaiTinhTrang());
    }

    @Override
    public int update(LoaiTinhTrang loaiTinhTrang) {
        String sql = "{Call updateLoaiTinhTrang(?,?)}";
        return this.update(sql, loaiTinhTrang.getMaLoaiTinhTrangPhong(), loaiTinhTrang.getTenLoaiTinhTrang());
    }

    @Override
    public int delete(int maLoaiTinhTrang) {
        String sql = "{Call deleteLoaiTinhTrang(?)}";
        return this.update(sql, maLoaiTinhTrang);
    }

}
