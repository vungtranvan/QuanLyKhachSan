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
public class ChiTietHoaDonMapper implements RowMapper<ChiTietHoaDon> {

    @Override
    public ChiTietHoaDon mapRow(ResultSet rs) {
        try {
            ChiTietHoaDon data = new ChiTietHoaDon(rs.getInt("MaHoaDon"), rs.getString("MaPhong"),
                    rs.getString("MaSuDungDichVu"), rs.getString("MaChinhSach"), rs.getFloat("PhuThu"),
                    rs.getFloat("TienPhong"), rs.getFloat("TienDichVu"), rs.getFloat("GiamGiaKH"), 
                    rs.getString("HinhThucThanhToan"), rs.getInt("SoNgay"), rs.getFloat("ThanhTien"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
