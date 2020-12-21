/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.QuyDinh;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class QuyDinhMapper implements RowMapper<QuyDinh> {

    @Override
    public QuyDinh mapRow(ResultSet rs) {
        try {
            QuyDinh data = new QuyDinh(rs.getInt("MaQuyDinh"), rs.getString("TenQuyDinh"), rs.getString("MoTa"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
