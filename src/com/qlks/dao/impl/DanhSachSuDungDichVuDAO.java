/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IDanhSachSuDungDichVuDAO;
import com.qlks.mapper.DanhSachSuDungDichVuMapper;
import com.qlks.models.DanhSachSuDungDichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public class DanhSachSuDungDichVuDAO extends AbstractDAO<DanhSachSuDungDichVu> implements IDanhSachSuDungDichVuDAO {

    @Override
    public List<DanhSachSuDungDichVu> getAll(String maNhanPhong, String maPhong) {
        String sql = "{Call getDanhSachSuDungDichVu_ByMaNhanPhong(?,?)}";
        return query(sql, new DanhSachSuDungDichVuMapper(), maNhanPhong, maPhong);
    }

    @Override
    public List<DanhSachSuDungDichVu> getByMaSuDungDichVu(String maSuDungDVu) {
        String sql = "{Call getByMaSuDungDichVu(?)}";
        return query(sql, new DanhSachSuDungDichVuMapper(), maSuDungDVu);
    }

    @Override
    public int add(DanhSachSuDungDichVu dv) {
        String sql = "{Call insertDanhSachSuDungDichVu(?,?,?,?,?)}";
        return this.update(sql, dv.getMaSuDungDVu(), dv.getMaDichVu(), dv.getMaNhanPhong(), dv.getMaPhong(), dv.getSoLuong());
    }

    @Override
    public int update(DanhSachSuDungDichVu dv) {
        String sql = "{Call updateDanhSachSuDungDichVu(?,?,?,?,?)}";
        return this.update(sql, dv.getMaSuDungDVu(), dv.getMaDichVu(), dv.getMaNhanPhong(), dv.getMaPhong(), dv.getSoLuong());
    }

    @Override
    public int delete(String maSuDungDVu) {
        String sql = "{Call deleteDanhSachSuDungDichVu(?)}";
        return this.update(sql, maSuDungDVu);
    }

    @Override
    public int addDefault(String maSuDungDVu, String maNhanPhong, String maPhong) {
        String sql = "{Call insertDanhSachSuDungDichVuDefault(?,?)}";
        return this.update(sql, maSuDungDVu, maNhanPhong, maPhong);
    }

}
