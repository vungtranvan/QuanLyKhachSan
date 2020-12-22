/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.ICauHinhDAO;
import com.qlks.mapper.CauHinhMapper;
import com.qlks.models.CauHinh;
import java.util.List;

/**
 *
 * @author hello
 */
public class CauHinhDAO extends AbstractDAO<CauHinh> implements ICauHinhDAO {

    @Override
    public List<CauHinh> getAll() {
        String sql = "{Call getAllCauHinh}";
        return query(sql, new CauHinhMapper());
    }

    @Override
    public List<CauHinh> search(String loaiCauHinh) {
        String sql = "{Call SearchCauHinh(?)}";
        return query(sql, new CauHinhMapper(), loaiCauHinh);
    }

    @Override
    public int add(CauHinh cauhinh) {
        String sql = "{Call insertCauHinh(?)}";
        return this.update(sql, cauhinh.getLoaiCauHinh());
    }

    @Override
    public int update(CauHinh cauhinh) {
        String sql = "{Call updateCauHinh(?,?)}";
        return this.update(sql, cauhinh.getLoaiCauHinh(), cauhinh.getMaCauHinh());
    }

    @Override
    public int delete(int maCauHinh) {
        String sql = "{Call deleteCauHinh(?)}";
        return this.update(sql, maCauHinh);
    }

}
