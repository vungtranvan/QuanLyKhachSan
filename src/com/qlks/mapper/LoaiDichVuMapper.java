/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.LoaiDichVu;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class LoaiDichVuMapper implements RowMapper<LoaiDichVu> {

    @Override
    public LoaiDichVu mapRow(ResultSet rs) {
        try {
            LoaiDichVu data = new LoaiDichVu(rs.getString("MaLoaiDichVu"), rs.getString("TenLoaiDichVu"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
