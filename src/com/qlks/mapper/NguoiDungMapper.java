/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class NguoiDungMapper implements RowMapper<NguoiDung> {

    @Override
    public NguoiDung mapRow(ResultSet rs) {
        try {
            NguoiDung data = new NguoiDung(rs.getInt("MaNguoiDung"), rs.getString("TenNguoiDung"),
                    rs.getString("TenDangNhap"), rs.getString("MatKhau"), rs.getString("Anh"),
                    rs.getString("Email"), rs.getDate("NgaySinh").toLocalDate(), rs.getBoolean("GioiTinh"), rs.getInt("MaNhomQuyen"));
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
