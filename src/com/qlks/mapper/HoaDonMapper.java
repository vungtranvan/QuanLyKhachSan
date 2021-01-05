/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.HoaDon;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class HoaDonMapper implements RowMapper<HoaDon> {

    @Override
    public HoaDon mapRow(ResultSet rs) {
        try {
            HoaDon data = new HoaDon(rs.getInt("MaHoaDon"), rs.getString("MaKhachHang"), rs.getString("MaNhanPhong"), 
                    rs.getInt("MaKhuyenMai"), rs.getString("NhanVienLap"), rs.getFloat("TongTien"), rs.getDate("NgayLap").toLocalDate(), rs.getString("TenKhachHang"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
