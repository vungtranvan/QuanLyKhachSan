/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.Quyen;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class QuyenMapper implements RowMapper<Quyen> {

    @Override
    public Quyen mapRow(ResultSet rs) {
        try {
            Quyen data = new Quyen(rs.getInt("MaQuyen"), rs.getString("Quyen"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
