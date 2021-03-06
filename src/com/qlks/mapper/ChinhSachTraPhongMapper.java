/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ChinhSachTraPhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class ChinhSachTraPhongMapper implements RowMapper<ChinhSachTraPhong> {

    @Override
    public ChinhSachTraPhong mapRow(ResultSet rs) {
        try {
            ChinhSachTraPhong data = new ChinhSachTraPhong(rs.getString("MaChinhSach"), rs.getString("NoiDung"), rs.getFloat("PhuThu"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
