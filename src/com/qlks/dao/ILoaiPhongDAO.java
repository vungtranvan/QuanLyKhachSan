/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.LoaiPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface ILoaiPhongDAO {

    List<LoaiPhong> getAll();

    List<LoaiPhong> search(String maLoaiPhong, String tenLoaiPhong);

    int add(LoaiPhong loaiPhong);

    int update(LoaiPhong loaiPhong);

    int delete(String maLoaiPhong);
}
