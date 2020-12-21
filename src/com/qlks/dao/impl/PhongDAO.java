/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IPhongDAO;
import com.qlks.mapper.PhongMapper;
import com.qlks.models.Phong;
import java.util.List;

/**
 *
 * @author hello
 */
public class PhongDAO extends AbstractDAO<Phong> implements IPhongDAO {

    @Override
    public List<Phong> getAll() {
        String sql = "{Call getAllPhong}";
        return query(sql, new PhongMapper());
    }

    @Override
    public List<Phong> getByMaPhong(String maPhong) {
        String sql = "{Call getByMaPhong(?)}";
        return query(sql, new PhongMapper(), maPhong);
    }

    @Override
    public List<Phong> search(String maPhong, String maLoaiPhong, String maLoaiTinhTrangPhong) {
        String sql = "{Call SearchPhong(?,?,?)}";
        return query(sql, new PhongMapper(), maPhong, maLoaiPhong, maLoaiTinhTrangPhong);
    }

    @Override
    public void add(Phong phong) {
        String sql = "{Call insertPhong(?,?,?,?)}";
        this.update(sql, phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getMaLoaiTinhTrangPhong(), phong.getGhiChu());
    }

    @Override
    public void update(Phong phong) {
        String sql = "{Call updatePhong(?,?,?,?)}";
        this.update(sql, phong.getMaPhong(), phong.getMaLoaiPhong(), phong.getMaLoaiTinhTrangPhong(), phong.getGhiChu());
    }

    @Override
    public void delete(String maPhong) {
        String sql = "{Call deletePhong(?)}";
        this.update(sql, maPhong);
    }

}
