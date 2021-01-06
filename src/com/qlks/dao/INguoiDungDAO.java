/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.NguoiDung;
import java.util.List;

/**
 *
 * @author hello
 */
public interface INguoiDungDAO {

    List<NguoiDung> getAll();

    List<NguoiDung> getByMa(int maNguoiDung);

    List<NguoiDung> getByTenDangNhap(String tenDangNhap);

    List<NguoiDung> getByEmail(String password);

    List<NguoiDung> checkDangNhap(String tenDangNhap, String password);

    List<NguoiDung> search(String tenNguoiDung, String email, int maNhomQuyen);

    int add(NguoiDung nguoiDung);

    int update(NguoiDung nguoiDung);
    
     int updatePassword(int maNguoiDung, String password);

    int delete(int maNguoiDung);
}
