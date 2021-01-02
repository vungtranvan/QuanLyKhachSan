/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.PhieuThuePhong;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IPhieuThuePhongDAO {

    List<PhieuThuePhong> getAll();

    List<PhieuThuePhong> search(String maPhieu, String tenKH, LocalDate ngayDky, LocalDate ngayNhan, String maPhong);

    int add(PhieuThuePhong phieuThuePhong);

    int delete(String maPhieuThue);
}
