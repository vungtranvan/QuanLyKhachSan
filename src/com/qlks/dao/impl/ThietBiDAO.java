/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IThietBiDAO;
import com.qlks.mapper.ThietBiMapper;
import com.qlks.models.ThietBi;
import java.util.List;

/**
 *
 * @author hello
 */
public class ThietBiDAO extends AbstractDAO<ThietBi> implements IThietBiDAO {

    @Override
    public List<ThietBi> getAll() {
        String sql = "{Call getAllThietBi}";
        return query(sql, new ThietBiMapper());
    }

    @Override
    public List<ThietBi> search(String maThietBi, String maLoaiPhong, String tenThietBi) {
        String sql = "{Call SearchThietBi(?,?,?)}";
        return query(sql, new ThietBiMapper(), maThietBi, maLoaiPhong, tenThietBi);
    }

    @Override
    public int add(ThietBi thietbi) {
        String sql = "{Call insertThietBi(?,?,?,?,?)}";
        return this.update(sql, thietbi.getMaThietBi(), thietbi.getMaLoaiPhong(), thietbi.getTenThietBi(), thietbi.getSoLuong(), thietbi.getGia());
    }

    @Override
    public int update(ThietBi thietbi) {
        String sql = "{Call updateThietBi(?,?,?,?,?)}";
        return this.update(sql, thietbi.getMaThietBi(), thietbi.getMaLoaiPhong(), thietbi.getTenThietBi(), thietbi.getSoLuong(), thietbi.getGia());
    }

    @Override
    public int delete(String maThietBi) {
        String sql = "{Call deleteThietBi(?)}";
        return this.update(sql, maThietBi);
    }

}
