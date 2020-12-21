/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.PhieuNhanPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IPhieuNhanPhongDAO {

    List<PhieuNhanPhong> getAll();

    List<PhieuNhanPhong> getByMaNhanPhong(String maNhanPhong);

    List<PhieuNhanPhong> search(String maNhanPhong, String maPhieuThue, String maKhachHang);

    void add(PhieuNhanPhong phieuNhanPhong);

    void update(PhieuNhanPhong phieuNhanPhong);

    void delete(String maNhanPhong);
}
