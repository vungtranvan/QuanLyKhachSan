/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.Phong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IPhongDAO {

    List<Phong> getAll();

    List<Phong> getByMaPhong(String maPhong);

    List<Phong> search(String maPhong, String maLoaiPhong, String maLoaiTinhTrangPhong);

    void add(Phong phong);

    void update(Phong phong);

    void delete(String maPhong);
}
