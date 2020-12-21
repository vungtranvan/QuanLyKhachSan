/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.CauHinh;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class CauHinhMapper implements RowMapper<CauHinh> {

    @Override
    public CauHinh mapRow(ResultSet rs) {
        try {
            CauHinh data = new CauHinh(rs.getInt("MaCauHinh"), rs.getString("LoaiCauHinh"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
