/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ChiTietPhieuThuePhong;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IChiTietPhieuThuePhongDAO {

    List<ChiTietPhieuThuePhong> getAll();

    List<ChiTietPhieuThuePhong> getByMaPhieuThue(String maPhieuThue);

    int add(ChiTietPhieuThuePhong ct);

    int delete(String maPhieuThue);

    int update(String maPhieuThue, LocalDate ngayDKy, LocalDate ngayNhan);
}
