/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.NguoiDung;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface INguoiDungDAO {

    List<NguoiDung> getAll();

    List<NguoiDung> getByMa(int maNguoiDung);

    List<NguoiDung> search(int maNguoiDung, String tenNguoiDung, String tenDangNhap, String email, LocalDate ngaySinh, Boolean gioiTinh, int maNhomQuyen);

    void add(NguoiDung nguoiDung);

    void update(NguoiDung nguoiDung);

    void delete(int maNguoiDung);
}