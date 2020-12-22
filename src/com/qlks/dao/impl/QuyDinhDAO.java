/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IQuyDinhDAO;
import com.qlks.mapper.QuyDinhMapper;
import com.qlks.models.QuyDinh;
import java.util.List;

/**
 *
 * @author hello
 */
public class QuyDinhDAO extends AbstractDAO<QuyDinh> implements IQuyDinhDAO {

    @Override
    public List<QuyDinh> getAll() {
        String sql = "{Call getAllQuyDinh}";
        return query(sql, new QuyDinhMapper());
    }

    @Override
    public int add(QuyDinh quydinh) {
        String sql = "{Call insertQuyDinh(?,?)}";
        return this.update(sql, quydinh.getTenQuyDinh(), quydinh.getMoTa());
    }

    @Override
    public int update(QuyDinh quydinh) {
        String sql = "{Call updateQuyDinh(?,?,?)}";
        return this.update(sql, quydinh.getTenQuyDinh(), quydinh.getMoTa(), quydinh.getMaQuyDinh());
    }

    @Override
    public int delete(int maQuyDinh) {
        String sql = "{Call deleteQuyDinh(?)}";
        return this.update(sql, maQuyDinh);
    }

    @Override
    public List<QuyDinh> search(String tenQuyDinh) {
        String sql = "{Call SearchQuyDinh(?)}";
        return query(sql, new QuyDinhMapper(), tenQuyDinh);
    }

}
