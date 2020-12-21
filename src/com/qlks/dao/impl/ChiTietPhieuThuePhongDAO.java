/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IChiTietPhieuThuePhongDAO;
import com.qlks.mapper.ChiTietPhieuThuePhongMapper;
import com.qlks.models.ChiTietPhieuThuePhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class ChiTietPhieuThuePhongDAO extends AbstractDAO<ChiTietPhieuThuePhong> implements IChiTietPhieuThuePhongDAO {

    @Override
    public List<ChiTietPhieuThuePhong> getAll() {
        String sql = "{Call getAllChiTietPhieuThuePhong}";
        return query(sql, new ChiTietPhieuThuePhongMapper());
    }

    @Override
    public void add(ChiTietPhieuThuePhong ct) {
        String sql = "{Call insertChiTietPhieuThuePhong(?,?,?,?)}";
        this.update(sql, ct.getMaPhieuThue(), ct.getMaPhong(), ct.getNgayDangKy(), ct.getNgayNhan());
    }

}
