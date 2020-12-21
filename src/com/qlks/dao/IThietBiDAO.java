/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ThietBi;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IThietBiDAO {
    List<ThietBi> getAll();

    List<ThietBi> search(String maThietBi, String maLoaiPhong, String tenThietBi, float gia);

    void add(ThietBi thietBi);

    void update(ThietBi thietBi);

    void delete(String maThietBi);
}