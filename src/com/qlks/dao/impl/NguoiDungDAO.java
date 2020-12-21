/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.INguoiDungDAO;
import com.qlks.mapper.NguoiDungMapper;
import com.qlks.models.NguoiDung;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class NguoiDungDAO extends AbstractDAO<NguoiDung> implements INguoiDungDAO {

    @Override
    public List<NguoiDung> getAll() {
        String sql = "{Call getAllNguoiDung}";
        return query(sql, new NguoiDungMapper());
    }

    @Override
    public List<NguoiDung> getByMa(int maNguoiDung) {
        String sql = "{Call getNguoiDungById(?)}";
        return query(sql, new NguoiDungMapper(), maNguoiDung);
    }

    @Override
    public void add(NguoiDung nguoiDung) {
        String sql = "{Call insertNguoiDung(?,?,?,?,?,?,?,?)}";
        this.update(sql, nguoiDung.getTenNguoiDung(), nguoiDung.getTenDangNhap(),
                nguoiDung.getMatKhau(), nguoiDung.getAnh(), nguoiDung.getEmail(),
                nguoiDung.getNgaySinh(), nguoiDung.isGioiTinh(), nguoiDung.getMaNhomQuyen());
    }

    @Override
    public void update(NguoiDung nguoiDung) {
        String sql = "{Call updateNguoiDung(?,?,?,?,?,?,?,?,?)}";
        this.update(sql, nguoiDung.getTenNguoiDung(), nguoiDung.getTenDangNhap(),
                nguoiDung.getMatKhau(), nguoiDung.getAnh(), nguoiDung.getEmail(),
                nguoiDung.getNgaySinh(), nguoiDung.isGioiTinh(), nguoiDung.getMaNhomQuyen(), nguoiDung.getMaNguoiDung());
    }

    @Override
    public void delete(int maNguoiDung) {
        String sql = "{Call deleteNguoiDung(?)}";
        this.update(sql, maNguoiDung);
    }

    @Override
    public List<NguoiDung> search(int maNguoiDung, String tenNguoiDung, String tenDangNhap, String email, LocalDate ngaySinh, Boolean gioiTinh, int maNhomQuyen) {
        String sql = "{Call SearchNguoiDung(?,?,?,?,?,?,?)}";
        return query(sql, new NguoiDungMapper(), maNguoiDung, tenNguoiDung, tenDangNhap, email, ngaySinh, gioiTinh, maNhomQuyen);
    }

}