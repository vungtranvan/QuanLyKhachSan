/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IThongKePhongDAO;
import com.qlks.mapper.ThongKePhongMapper;
import com.qlks.models.ThongKePhong;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class ThongKePhongDAO extends AbstractDAO<ThongKePhong> implements IThongKePhongDAO {

    @Override
    public List<ThongKePhong> getAll(LocalDate ngayInput1, LocalDate ngayInput2) {
        String sql = "{Call ThongKePhong(?,?)}";
        return query(sql, new ThongKePhongMapper(), ngayInput1, ngayInput2);
    }
}
