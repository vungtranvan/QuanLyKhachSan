/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.mapper;

import com.qlks.models.DonVi;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hello
 */
public class DonViMapper implements RowMapper<DonVi> {

    @Override
    public DonVi mapRow(ResultSet rs) {
        try {
            DonVi data = new DonVi(rs.getString("MaDonVi"), rs.getString("TenDonVi"));
            return data;
        } catch (Exception ex) {
            Logger.getLogger(NguoiDungMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
