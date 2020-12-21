/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.KhuyenMai;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class KhuyenMaiMapper implements RowMapper<KhuyenMai> {

    @Override
    public KhuyenMai mapRow(ResultSet rs) {
        try {
            KhuyenMai data = new KhuyenMai(rs.getInt("MaKhuyenMai"), rs.getString("MaPhieu"), 
                    rs.getFloat("GiaTri"), rs.getString("NoiDung"), rs.getDate("NgayBatDau").toLocalDate(),
                    rs.getDate("NgayKetThuc").toLocalDate(), rs.getBoolean("KieuTinh"), rs.getBoolean("TrangThai"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
