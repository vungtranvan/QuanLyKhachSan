/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IPhanQuyenDAO;
import com.qlks.mapper.PhanQuyenMapper;
import com.qlks.models.PhanQuyen;
import java.util.List;

/**
 *
 * @author hello
 */
public class PhanQuyenDAO extends AbstractDAO<PhanQuyen> implements IPhanQuyenDAO {

    @Override
    public List<PhanQuyen> getAll() {
        String sql = "{Call getAllPhanQuyen}";
        return query(sql, new PhanQuyenMapper());
    }

    @Override
    public List<PhanQuyen> getMaQuyenByMaQuyen(int maNhomQuyen) {
        String sql = "{Call getMaQuyenByMaNhomQuyen(?)}";
        return query(sql, new PhanQuyenMapper(), maNhomQuyen);
    }

    @Override
    public int add(PhanQuyen phanQuyen) {
        String sql = "{Call insertPhanQuyen(?,?)}";
        return this.update(sql, phanQuyen.getMaQuyen(), phanQuyen.getMaNhomQuyen());
    }

}
