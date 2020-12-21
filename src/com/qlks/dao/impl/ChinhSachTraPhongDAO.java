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
    public List<ChinhSachTraPhong> search(String maChinhSachTraPhong, String noiDungMaChinhSach) {
        String sql = "{Call SearchChinhSachTraPhong(?,?)}";
        return query(sql, new ChinhSachTraPhongMapper(), maChinhSachTraPhong, noiDungMaChinhSach);
    }

    @Override
    public void add(ChinhSachTraPhong chinhSach) {
        String sql = "{Call insertChinhSachTraPhong(?,?,?)}";
        this.update(sql, chinhSach.getMaChinhSach(), chinhSach.getNoiDung(), chinhSach.getPhuThu());
    }

    @Override
    public void update(ChinhSachTraPhong chinhSach) {
        String sql = "{Call updateChinhSachTraPhong(?,?,?)}";
        this.update(sql, chinhSach.getMaChinhSach(), chinhSach.getNoiDung(), chinhSach.getPhuThu());
    }

    @Override
    public void delete(String maChinhSachTraPhong) {
        String sql = "{Call deleteChinhSachTraPhong(?)}";
        this.update(sql, maChinhSachTraPhong);
    }

}
