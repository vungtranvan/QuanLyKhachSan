/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IChinhSachTraPhongDAO;
import com.qlks.mapper.ChinhSachTraPhongMapper;
import com.qlks.models.ChinhSachTraPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public class ChinhSachTraPhongDAO extends AbstractDAO<ChinhSachTraPhong> implements IChinhSachTraPhongDAO {

    @Override
    public List<ChinhSachTraPhong> getAll() {
        String sql = "{Call getAllChinhSachTraPhong()}";
        return query(sql, new ChinhSachTraPhongMapper());
    }

    @Override
    public List<ChinhSachTraPhong> getByMa(String maChinhSach) {
        String sql = "{Call getChinhSachTraPhongByMa(?)}";
        return query(sql, new ChinhSachTraPhongMapper(), maChinhSach);
    }

    @Override
    public List<ChinhSachTraPhong> search(String maChinhSachTraPhong, String noiDungMaChinhSach) {
        String sql = "{Call SearchChinhSachTraPhong(?,?)}";
        return query(sql, new ChinhSachTraPhongMapper(), maChinhSachTraPhong, noiDungMaChinhSach);
    }

    @Override
    public int add(ChinhSachTraPhong chinhSach) {
        String sql = "{Call insertChinhSachTraPhong(?,?,?)}";
        return this.update(sql, chinhSach.getMaChinhSach(), chinhSach.getNoiDung(), chinhSach.getPhuThu());
    }

    @Override
    public int update(ChinhSachTraPhong chinhSach) {
        String sql = "{Call updateChinhSachTraPhong(?,?,?)}";
        return this.update(sql, chinhSach.getMaChinhSach(), chinhSach.getNoiDung(), chinhSach.getPhuThu());
    }

    @Override
    public int delete(String maChinhSachTraPhong) {
        String sql = "{Call deleteChinhSachTraPhong(?)}";
        return this.update(sql, maChinhSachTraPhong);
    }

}
