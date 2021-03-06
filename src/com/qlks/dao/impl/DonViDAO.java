/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.dao.IDonViDAO;
import com.qlks.mapper.DonViMapper;
import com.qlks.models.DonVi;
import java.util.List;

/**
 *
 * @author hello
 */
public class DonViDAO extends AbstractDAO<DonVi> implements IDonViDAO {

    @Override
    public List<DonVi> getAll() {
        String sql = "{Call getAllDonVi}";
        return query(sql, new DonViMapper());
    }

    @Override
    public List<DonVi> getByMa(String maDVi) {
        String sql = "{Call getDonViByMa(?)}";
        return query(sql, new DonViMapper(), maDVi);
    }

    @Override
    public List<DonVi> search(String maDonVi, String tenDonVi) {
        String sql = "{Call SearchDonVi(?,?)}";
        return query(sql, new DonViMapper(), maDonVi, tenDonVi);
    }

    @Override
    public int add(DonVi donVi) {
        String sql = "{Call insertDonVi(?,?)}";
        return this.update(sql, donVi.getMaDonVi(), donVi.getTenDonVi());
    }

    @Override
    public int update(DonVi donVi) {
        String sql = "{Call updateDonVi(?,?)}";
        return this.update(sql, donVi.getMaDonVi(), donVi.getTenDonVi());
    }

    @Override
    public int delete(String maDonVi) {
        String sql = "{Call deleteDonVi(?)}";
        return this.update(sql, maDonVi);
    }

}
