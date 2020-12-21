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

    List<LoaiTinhTrang> search(int maLoaiTinhTrang, String tenLoaiTinhTrang);

    void add(LoaiTinhTrang loaiTinhTrang);

    void update(LoaiTinhTrang loaiTinhTrang);

    void delete(int maLoaiTinhTrang);
}
