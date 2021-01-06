/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IThongKeKhachHangDAO;
import com.qlks.mapper.ThongKeKhachHangMapper;
import com.qlks.models.ThongKeKhachHang;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class ThongKeKhachHangDAO extends AbstractDAO<ThongKeKhachHang> implements IThongKeKhachHangDAO {

    @Override
    public List<ThongKeKhachHang> getAll(LocalDate ngayInput1, LocalDate ngayInput2) {
        String sql = "{Call ThongKeKhachHang(?,?)}";
        return query(sql, new ThongKeKhachHangMapper(), ngayInput1, ngayInput2);
    }
}