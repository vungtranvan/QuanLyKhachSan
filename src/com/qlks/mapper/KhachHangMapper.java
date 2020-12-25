/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class KhachHangMapper implements RowMapper<KhachHang> {

    @Override
    public KhachHang mapRow(ResultSet rs) {
        try {
            KhachHang data = new KhachHang(rs.getString("MaKhachHang"),
                    rs.getString("TenKhachHang"), rs.getString("CMND"), rs.getString("DiaChi"),
                    rs.getString("DienThoai"), rs.getBoolean("GioiTinh"), rs.getString("QuocTich"));
            return data;

        } catch (SQLException ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
