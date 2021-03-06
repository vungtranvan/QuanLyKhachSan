/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IChiTietHoaDonDAO;
import com.qlks.mapper.ChiTietHoaDonByMaMapper;
import com.qlks.mapper.ChiTietHoaDonMapper;
import com.qlks.models.ChiTietHoaDon;
import java.util.List;

/**
 *
 * @author hello
 */
public class ChiTietHoaDonDAO extends AbstractDAO<ChiTietHoaDon> implements IChiTietHoaDonDAO {

    @Override
    public List<ChiTietHoaDon> getAll() {
        String sql = "{Call getAllChiTietHoaDon}";
        return query(sql, new ChiTietHoaDonMapper());
    }

    @Override
    public List<ChiTietHoaDon> getByMaHoaDon(int maHoaDon) {
        String sql = "{Call getChiTietHoaDon_By_MaHoaDon(?)}";
        return query(sql, new ChiTietHoaDonByMaMapper(), maHoaDon);
    }

    @Override
    public int addCoDV(ChiTietHoaDon ct) {
        String sql = "{Call insertChiTietHoaDon(?,?,?,?,?,?,?,?,?,?,?)}";
        return this.update(sql, ct.getMaHoaDon(), ct.getMaPhong(), ct.getMaSuDungDichVu(),
                ct.getMaChinhSach(), ct.getPhuThu(), ct.getTienPhong(), ct.getTienDichVu(),
                ct.getGiamGiaKH(), ct.getHinhThucThanhToan(), ct.getSoNgay(), ct.getThanhTien());
    }

    @Override
    public int addNoDV(ChiTietHoaDon ct) {
        String sql = "{Call insertChiTietHoaDonNoDV(?,?,?,?,?,?,?,?,?,?)}";
        return this.update(sql, ct.getMaHoaDon(), ct.getMaPhong(),
                ct.getMaChinhSach(), ct.getPhuThu(), ct.getTienPhong(), ct.getTienDichVu(),
                ct.getGiamGiaKH(), ct.getHinhThucThanhToan(), ct.getSoNgay(), ct.getThanhTien());
    }
}
