/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.PhieuThuePhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IPhieuThuePhongDAO {

    List<PhieuThuePhong> getAll();

    List<PhieuThuePhong> getChuaXuLy();

    List<PhieuThuePhong> getChuaXuLy(String maPhieu, String maKH);

    List<PhieuThuePhong> getByMaPhieuThue(String maPhieu);

    List<PhieuThuePhong> search(String maPhieu, String tenKH, String maPhong);

    int add(PhieuThuePhong phieuThuePhong);

    int delete(String maPhieuThue);

    int updateTrangThai(String maPhieuThue);
}
