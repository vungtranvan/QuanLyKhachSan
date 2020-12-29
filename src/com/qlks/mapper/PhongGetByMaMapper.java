/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.Phong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class PhongGetByMaMapper implements RowMapper<Phong> {

    @Override
    public Phong mapRow(ResultSet rs) {
        try {
            Phong data = new Phong(rs.getString("MaPhong"), rs.getString("MaLoaiPhong"), rs.getInt("MaLoaiTinhTrangPhong"), rs.getString("GhiChu"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
