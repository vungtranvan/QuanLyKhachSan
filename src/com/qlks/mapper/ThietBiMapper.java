/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ThietBi;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class ThietBiMapper implements RowMapper<ThietBi> {

    @Override
    public ThietBi mapRow(ResultSet rs) {
        try {
            ThietBi data = new ThietBi(rs.getString("MaThietBi"), rs.getString("MaLoaiPhong"), rs.getString("TenThietBi"), rs.getInt("SoLuong"), rs.getFloat("Gia"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
