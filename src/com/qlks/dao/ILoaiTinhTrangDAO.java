/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.LoaiTinhTrang;
import java.util.List;

/**
 *
 * @author hello
 */
public interface ILoaiTinhTrangDAO {

    List<LoaiTinhTrang> getAll();

    List<LoaiTinhTrang> getByMaLoaiTinhTrang(int maLoaiTinhTrang);

    List<LoaiTinhTrang> search(String tenLoaiTinhTrang);

    int add(LoaiTinhTrang loaiTinhTrang);

    int update(LoaiTinhTrang loaiTinhTrang);

    int delete(int maLoaiTinhTrang);
}
