/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IThongKeHieuSuatPhongDAO;
import com.qlks.mapper.HieuSuatPhongMapper;
import com.qlks.models.ThongKePhong;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class ThongKeHieuSuatPhongDAO extends AbstractDAO<ThongKePhong> implements IThongKeHieuSuatPhongDAO {

    @Override
    public List<ThongKePhong> getAll(LocalDate ngayInput1, LocalDate ngayInput2) {
        String sql = "{Call ThongKeHieuSuatPhong(?,?)}";
        return query(sql, new HieuSuatPhongMapper(), ngayInput1, ngayInput2);
    }
}