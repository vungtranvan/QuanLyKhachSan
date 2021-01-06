/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ThongKeKhachHangmd;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class ThongKeKhachHangMapper implements RowMapper<ThongKeKhachHangmd> {

    @Override
    public ThongKeKhachHangmd mapRow(ResultSet rs) {
        try {
            ThongKeKhachHangmd data = new ThongKeKhachHangmd(rs.getString("MaPhong"), rs.getString("TenKhachHang"),
                    rs.getString("CMND"), rs.getBoolean("GioiTinh"), rs.getString("DienThoai"), rs.getString("DiaChi"),
                    rs.getString("QuocTich"), rs.getDate("NgayNhan").toLocalDate(), rs.getDate("NgayTraThucTe").toLocalDate());
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
