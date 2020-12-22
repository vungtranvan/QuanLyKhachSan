/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.LoaiDichVu;
import java.util.List;

/**
 *
 * @author hello
 */
public interface ILoaiDichVuDAO {

    List<LoaiDichVu> getAll();

    List<LoaiDichVu> search(String maLoaiDichVu, String tenLoaiDichVu);

    int add(LoaiDichVu loaiDichVu);

    int update(LoaiDichVu loaiDichVu);

    int delete(String maLoaiDichVu);
}
