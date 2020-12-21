/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.ILoaiPhongDAO;
import com.qlks.mapper.LoaiPhongMapper;
import com.qlks.models.LoaiPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class LoaiPhongDAO extends AbstractDAO<LoaiPhong> implements ILoaiPhongDAO {

    @Override
    public List<LoaiPhong> getAll() {
        String sql = "{Call getAllLoaiPhong}";
        return query(sql, new LoaiPhongMapper());
    }

    @Override
    public List<LoaiPhong> search(String maLoaiPhong, String tenLoaiPhong, float donGia, int soNguoiChuan, int soNguoiToiDa) {
        String sql = "{Call SearchLoaiPhong(?,?,?,?,?)}";
        return query(sql, new LoaiPhongMapper(), maLoaiPhong, tenLoaiPhong, donGia, soNguoiChuan, soNguoiToiDa);
    }

    @Override
    public void add(LoaiPhong loaiPhong) {
        String sql = "{Call insertLoaiPhong(?,?,?,?,?,?)}";
        this.update(sql, loaiPhong.getMaLoaiPhong(), loaiPhong.getTenLoaiPhong(),
                loaiPhong.getDonGia(), loaiPhong.getSoNguoiChuan(), loaiPhong.getSoNguoiToiDa(), loaiPhong.getTyLeTang());
    }

    @Override
    public void update(LoaiPhong loaiPhong) {
        String sql = "{Call updateLoaiPhong(?,?,?,?,?,?)}";
        this.update(sql, loaiPhong.getMaLoaiPhong(), loaiPhong.getTenLoaiPhong(),
                loaiPhong.getDonGia(), loaiPhong.getSoNguoiChuan(), loaiPhong.getSoNguoiToiDa(), loaiPhong.getTyLeTang());
    }

    @Override
    public void delete(String maLoaiPhong) {
        String sql = "{Call deleteLoaiPhong(?)}";
        this.update(sql, maLoaiPhong);
    }

}
