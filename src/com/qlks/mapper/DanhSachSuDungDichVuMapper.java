/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.DanhSachSuDungDichVu;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class DanhSachSuDungDichVuMapper implements RowMapper<DanhSachSuDungDichVu> {

    @Override
    public DanhSachSuDungDichVu mapRow(ResultSet rs) {
        try {
            DanhSachSuDungDichVu data = new DanhSachSuDungDichVu(rs.getString("MaSuDungDVu"), rs.getString("MaDichVu"),
                    rs.getString("MaNhanPhong"), rs.getInt("SoLuong"), rs.getString("TenLoaiDichVu"), rs.getString("TenDonVi"),rs.getFloat("DonGia"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
