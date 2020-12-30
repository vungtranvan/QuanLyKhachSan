/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.ICauHinhNguoiDungDAO;
import com.qlks.mapper.CauHinhNguoiDungMapper;
import com.qlks.models.CauHinhNguoiDung;
import java.util.List;

/**
 *
 * @author hello
 */
public class CauHinhNguoiDungDAO extends AbstractDAO<CauHinhNguoiDung> implements ICauHinhNguoiDungDAO {

    @Override
    public List<CauHinhNguoiDung> getValue(int maCauHinh, int maNguoiDung) {
        String sql = "{Call getConfigVal(?,?)}";
        return query(sql, new CauHinhNguoiDungMapper(), maCauHinh, maNguoiDung);
    }

    @Override
    public int add(CauHinhNguoiDung cauHinhNguoiDung) {
        String sql = "{Call insertCauHinhNguoiDung(?,?,?)}";
        return this.update(sql, cauHinhNguoiDung.getMaCauHinh(), cauHinhNguoiDung.getMaNguoiDung(), cauHinhNguoiDung.getNoiDungCauHinh());
    }

    @Override
    public int update(CauHinhNguoiDung cauHinhNguoiDung) {
        String sql = "{Call updateCauHinhNguoiDung(?,?,?)}";
        return this.update(sql, cauHinhNguoiDung.getMaCauHinh(), cauHinhNguoiDung.getMaNguoiDung(), cauHinhNguoiDung.getNoiDungCauHinh());
    }

}
