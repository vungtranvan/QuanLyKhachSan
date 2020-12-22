/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.DichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IDichVuDAO {

    List<DichVu> getAll();

    List<DichVu> search(String maDichVu, String maLoaiDichVu, String maDonVi, float donGia);

    int add(DichVu dichVu);

    int update(DichVu dichVu);

    int delete(String maDichVu);
}
