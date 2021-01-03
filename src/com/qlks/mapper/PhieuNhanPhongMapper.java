/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.PhieuNhanPhong;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class PhieuNhanPhongMapper implements RowMapper<PhieuNhanPhong> {

    @Override
    public PhieuNhanPhong mapRow(ResultSet rs) {
        try {
            PhieuNhanPhong data = null;
            if (rs.getDate("NgayTraThucTe") == null) {
                data = new PhieuNhanPhong(rs.getString("MaNhanPhong"), rs.getString("MaPhieuThue"), rs.getString("MaKhachHang"), rs.getString("MaPhong"),
                        rs.getString("HoTenKhachHang"), rs.getString("CMND"), rs.getDate("NgayNhan").toLocalDate(),
                        rs.getDate("NgayTraDuKien").toLocalDate(), rs.getBoolean("TrangThai"));
            } else {
                data = new PhieuNhanPhong(rs.getString("MaNhanPhong"), rs.getString("MaPhieuThue"), rs.getString("MaKhachHang"), rs.getString("MaPhong"),
                        rs.getString("HoTenKhachHang"), rs.getString("CMND"), rs.getDate("NgayNhan").toLocalDate(),
                        rs.getDate("NgayTraDuKien").toLocalDate(), rs.getDate("NgayTraThucTe").toLocalDate(), rs.getBoolean("TrangThai"));
            }
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
