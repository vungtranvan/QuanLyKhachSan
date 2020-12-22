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

    int add(PhieuNhanPhong phieuNhanPhong);

    int update(PhieuNhanPhong phieuNhanPhong);

    int delete(String maNhanPhong);
}
