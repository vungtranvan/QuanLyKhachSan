/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IChiTietPhieuNhanPhongDAO;
import com.qlks.mapper.ChiTietPhieuNhanPhongMapper;
import com.qlks.models.ChiTietPhieuNhanPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class ChiTietPhieuNhanPhongDAO extends AbstractDAO<ChiTietPhieuNhanPhong> implements IChiTietPhieuNhanPhongDAO {

    @Override
    public List<ChiTietPhieuNhanPhong> getAll() {
        String sql = "{Call getAllChiTietPhieuNhanPhong}";
        return query(sql, new ChiTietPhieuNhanPhongMapper());
    }

    @Override
    public List<ChiTietPhieuNhanPhong> getByMaNhanPhong(String maNhanPhong) {
        String sql = "{Call getChiTietPhieuNhanPhong_By_MaNhanPhong(?)}";
        return query(sql, new ChiTietPhieuNhanPhongMapper(), maNhanPhong);
    }

    @Override
    public int add(ChiTietPhieuNhanPhong ct) {
        String sql = "{Call insertChiTietPhieuNhanPhong(?,?,?,?,?,?)}";
        return this.update(sql, ct.getMaNhanPhong(), ct.getMaPhong(), ct.getHoTenKhachHang(),
                ct.getChungMinhThuNhanDan(), ct.getNgayNhan(), ct.getNgayTraDuKien());
    }

}
