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
    public List<DanhSachSuDungDichVu> getAll() {
        String sql = "{Call getAllDanhSachSuDungDichVu}";
        return query(sql, new DanhSachSuDungDichVuMapper());
    }

    @Override
    public List<DanhSachSuDungDichVu> getByMaSuDungDichVu(String maSuDungDVu) {
        String sql = "{Call getByMaSuDungDichVu(?)}";
        return query(sql, new DanhSachSuDungDichVuMapper(), maSuDungDVu);
    }

    @Override
    public List<DanhSachSuDungDichVu> search(String maSuDungDVu, String maDichVu, String maNhanPhong) {
        String sql = "{Call SearchDanhSachSuDungDichVu(?,?,?)}";
        return query(sql, new DanhSachSuDungDichVuMapper(), maSuDungDVu, maDichVu, maNhanPhong);
    }

    @Override
    public void add(DanhSachSuDungDichVu dv) {
        String sql = "{Call insertDanhSachSuDungDichVu(?,?,?,?)}";
        this.update(sql, dv.getMaSuDungDVu(), dv.getMaDichVu(), dv.getMaNhanPhong(), dv.getSoLuong());
    }

    @Override
    public void update(DanhSachSuDungDichVu dv) {
        String sql = "{Call updateDanhSachSuDungDichVu(?,?,?,?)}";
        this.update(sql, dv.getMaSuDungDVu(), dv.getMaDichVu(), dv.getMaNhanPhong(), dv.getSoLuong());
    }

    @Override
    public void delete(String maSuDungDVu) {
        String sql = "{Call deleteDanhSachSuDungDichVu(?)}";
        this.update(sql, maSuDungDVu);
    }

}
