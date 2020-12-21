/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.LoaiPhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class LoaiPhongMapper implements RowMapper<LoaiPhong> {

    @Override
    public LoaiPhong mapRow(ResultSet rs) {
        try {
            LoaiPhong data = new LoaiPhong(rs.getString("MaLoaiPhong"), rs.getString("TenLoaiPhong"),
                    rs.getFloat("DonGia"), rs.getInt("SoNguoiChuan"), rs.getInt("SoNguoiToiDa"), rs.getFloat("TyLeTang"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
