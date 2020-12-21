/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.NhomQuyen;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class NhomQuyenMapper implements RowMapper<NhomQuyen> {

    @Override
    public NhomQuyen mapRow(ResultSet rs) {
        try {
            NhomQuyen data = new NhomQuyen(rs.getInt("MaNhomQuyen"), rs.getString("TenNhomQuyen"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
