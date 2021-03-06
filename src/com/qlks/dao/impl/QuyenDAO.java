/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IQuyenDAO;
import com.qlks.mapper.QuyenMapper;
import com.qlks.models.Quyen;
import java.util.List;

/**
 *
 * @author hello
 */
public class QuyenDAO extends AbstractDAO<Quyen> implements IQuyenDAO {

    @Override
    public List<Quyen> getAll() {
        String sql = "{Call getAllQuyen}";
        return query(sql, new QuyenMapper());
    }

    @Override
    public List<Quyen> search(String tenQuyen) {
        String sql = "{Call SearchQuyen(?)}";
        return query(sql, new QuyenMapper(), tenQuyen);
    }

    @Override
    public int add(Quyen quyen) {
        String sql = "{Call insertQuyen(?)}";
        return this.update(sql, quyen.getQuyen());
    }

    @Override
    public int update(Quyen quyen) {
        String sql = "{Call updateQuyen(?,?)}";
        return this.update(sql, quyen.getQuyen(), quyen.getMaQuyen());
    }

    @Override
    public int delete(int maQuyen) {
        String sql = "{Call deleteQuyen(?)}";
        return this.update(sql, maQuyen);
    }

}
