/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.PhanQuyen;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class PhanQuyenMapper implements RowMapper<PhanQuyen> {

    @Override
    public PhanQuyen mapRow(ResultSet rs) {
        try {
            PhanQuyen data = new PhanQuyen(rs.getInt("MaQuyen"), rs.getInt("MaNhomQuyen"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
