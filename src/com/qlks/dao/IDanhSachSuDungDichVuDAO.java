/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.DanhSachSuDungDichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IDanhSachSuDungDichVuDAO {

    List<DanhSachSuDungDichVu> getAll();

    List<DanhSachSuDungDichVu> getByMaSuDungDichVu(String maSuDungDVu);

    List<DanhSachSuDungDichVu> search(String maSuDungDVu, String maDichVu, String maNhanPhong);

    void add(DanhSachSuDungDichVu dv);

    void update(DanhSachSuDungDichVu dv);

    void delete(String maSuDungDVu);
}
