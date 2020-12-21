/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.INhomQuyenDAO;
import com.qlks.mapper.NhomQuyenMapper;
import com.qlks.models.NhomQuyen;
import java.util.List;

/**
 *
 * @author hello
 */
public class NhomQuyenDAO extends AbstractDAO<NhomQuyen> implements INhomQuyenDAO {

    @Override
    public List<NhomQuyen> getAll() {
        String sql = "{Call getAllNhomQuyen}";
        return query(sql, new NhomQuyenMapper());
    }

    @Override
    public List<NhomQuyen> search(int maNhomQuyen, String tenNhomQuyen) {
        String sql = "{Call SearchNhomQuyen(?,?)}";
        return query(sql, new NhomQuyenMapper(), maNhomQuyen, tenNhomQuyen);
    }

    @Override
    public void add(NhomQuyen nhomQuyen) {
        String sql = "{Call insertNhomQuyen(?)}";
        this.update(sql, nhomQuyen.getTenNhomQuyen());
    }

    @Override
    public void update(NhomQuyen nhomQuyen) {
        String sql = "{Call updateNhomQuyen(?,?)}";
        this.update(sql, nhomQuyen.getMaNhomQuyen(), nhomQuyen.getTenNhomQuyen());
    }

    @Override
    public void delete(int maNhomQuyen) {
        String sql = "{Call deleteNhomQuyen(?)}";
        this.update(sql, maNhomQuyen);
    }

}
