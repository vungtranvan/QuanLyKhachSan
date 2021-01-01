/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.PhieuThuePhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class PhieuThuePhongMapper implements RowMapper<PhieuThuePhong> {

    @Override
    public PhieuThuePhong mapRow(ResultSet rs) {
        try {
            PhieuThuePhong data = new PhieuThuePhong(rs.getString("MaPhieuThue"), rs.getString("MaKhachHang"), rs.getString("TenKhachHang"),
                    rs.getString("MaPhong"), rs.getDate("NgayDangKy").toLocalDate(), rs.getDate("NgayNhan").toLocalDate());
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
