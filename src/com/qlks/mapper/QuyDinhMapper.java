/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.QuyDinh;
import java.sql.ResultSet;

/**
 *
 * @author hello
 */
public class QuyDinhMapper implements RowMapper<QuyDinh> {

    @Override
    public QuyDinh mapRow(ResultSet rs) {
        try {
            QuyDinh data = new QuyDinh(rs.getString("TenQuyDinh"), rs.getString("MoTa"));
            return data;
        } catch (Exception e) {
            
        }
        return null;
    }

}
