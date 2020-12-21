/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ChiTietPhieuNhanPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IChiTietPhieuNhanPhongDAO {

    List<ChiTietPhieuNhanPhong> getAll();

    List<ChiTietPhieuNhanPhong> getByMaNhanPhong(String maNhanPhong);

    void add(ChiTietPhieuNhanPhong ct);
}
