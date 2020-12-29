/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.DichVu;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class DichVuGetByMaMapper implements RowMapper<DichVu> {

    @Override
    public DichVu mapRow(ResultSet rs) {
        try {
            DichVu data = new DichVu(rs.getString("MaDichVu"), rs.getString("MaLoaiDichVu"), rs.getString("MaDonVi"), rs.getFloat("DonGia"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
