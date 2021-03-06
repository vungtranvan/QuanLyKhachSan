/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ChiTietHoaDon;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class ChiTietHoaDonByMaMapper implements RowMapper<ChiTietHoaDon> {

    @Override
    public ChiTietHoaDon mapRow(ResultSet rs) {
        try {
            ChiTietHoaDon data = new ChiTietHoaDon(rs.getString("MaPhong"), rs.getFloat("PhuThu"),
                    rs.getFloat("TienPhong"), rs.getFloat("TongTienDichVu"), rs.getFloat("GiamGiaKH"),
                    rs.getInt("SoNgay"), rs.getString("HinhThucThanhToan"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
