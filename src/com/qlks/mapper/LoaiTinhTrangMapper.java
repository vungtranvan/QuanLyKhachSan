/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.LoaiTinhTrang;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class LoaiTinhTrangMapper implements RowMapper<LoaiTinhTrang> {

    @Override
    public LoaiTinhTrang mapRow(ResultSet rs) {
        try {
            LoaiTinhTrang data = new LoaiTinhTrang(rs.getInt("MaLoaiTinhTrangPhong"), rs.getString("TenLoaiTinhTrang"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
