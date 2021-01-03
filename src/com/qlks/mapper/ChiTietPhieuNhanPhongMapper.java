/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.ChiTietPhieuNhanPhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class ChiTietPhieuNhanPhongMapper implements RowMapper<ChiTietPhieuNhanPhong> {

    @Override
    public ChiTietPhieuNhanPhong mapRow(ResultSet rs) {
        try {
            ChiTietPhieuNhanPhong data = null;
            if (rs.getDate("NgayTraThucTe") != null) {
                data = new ChiTietPhieuNhanPhong(rs.getString("MaNhanPhong"), rs.getString("MaPhong"),
                        rs.getString("HoTenKhachHang"), rs.getString("CMND"), rs.getDate("NgayNhan").toLocalDate(),
                        rs.getDate("NgayTraDuKien").toLocalDate(), rs.getDate("NgayTraThucTe").toLocalDate());
            } else {
                data = new ChiTietPhieuNhanPhong(rs.getString("MaNhanPhong"), rs.getString("MaPhong"),
                        rs.getString("HoTenKhachHang"), rs.getString("CMND"), rs.getDate("NgayNhan").toLocalDate(),
                        rs.getDate("NgayTraDuKien").toLocalDate());
            }

            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
