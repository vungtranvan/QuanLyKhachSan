/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ThongKePhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class HieuSuatPhongMapper implements RowMapper<ThongKePhong> {

    @Override
    public ThongKePhong mapRow(ResultSet rs) {
        try {
            ThongKePhong data = new ThongKePhong(rs.getString("MaPhong"), rs.getFloat("HieuSuatThue"), rs.getInt("SoNgay"), rs.getInt("SoLanThue"), rs.getFloat("TienPhong"), rs.getFloat("TienDichVu"),
                    rs.getFloat("GiamGiaKH"), rs.getFloat("TongTien"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
