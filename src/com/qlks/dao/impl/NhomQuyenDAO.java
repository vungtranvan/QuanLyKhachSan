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
    public List<NhomQuyen> search(String tenNhomQuyen) {
        String sql = "{Call SearchNhomQuyen(?)}";
        return query(sql, new NhomQuyenMapper(), tenNhomQuyen);
    }

    @Override
    public int add(NhomQuyen nhomQuyen) {
        String sql = "{Call insertNhomQuyen(?)}";
        return this.update(sql, nhomQuyen.getTenNhomQuyen());
    }

    @Override
    public int update(NhomQuyen nhomQuyen) {
        String sql = "{Call updateNhomQuyen(?,?)}";
        return this.update(sql, nhomQuyen.getMaNhomQuyen(), nhomQuyen.getTenNhomQuyen());
    }

    @Override
    public int delete(int maNhomQuyen) {
        String sql = "{Call deleteNhomQuyen(?)}";
        return this.update(sql, maNhomQuyen);
    }

    @Override
    public List<NhomQuyen> getMaxId() {
        String sql = "{Call getMaxId}";
        return query(sql, new NhomQuyenMapper());
    }

}
