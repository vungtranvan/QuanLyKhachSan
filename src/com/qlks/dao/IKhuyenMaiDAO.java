/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.KhuyenMai;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IKhuyenMaiDAO {

    List<KhuyenMai> getAll();

    List<KhuyenMai> getByMaKhuyenMai(int maKhuyenMai);

    List<KhuyenMai> getByMaPhieuKhuyenMai(String maPhieu);

    List<KhuyenMai> kiemTraHieuLucKM(String maPhieu, LocalDate ngayKT);

    List<KhuyenMai> search(String maPhieu, String noiDung, Boolean trangThai);

    List<KhuyenMai> search(String maPhieu, String noiDung);

    int add(KhuyenMai khuyenMai);

    int update(KhuyenMai khuyenMai);

    int updateTrangThai(String maPhieu);

    int delete(int maKhuyenMai);
}
