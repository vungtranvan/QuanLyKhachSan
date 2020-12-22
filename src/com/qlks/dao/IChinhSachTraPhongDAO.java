/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ChinhSachTraPhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IChinhSachTraPhongDAO {

    List<ChinhSachTraPhong> getAll();

    List<ChinhSachTraPhong> search(String maChinhSachTraPhong, String noiDungMaChinhSach);

    int add(ChinhSachTraPhong chinhSach);

    int update(ChinhSachTraPhong chinhSach);

    int delete(String maChinhSachTraPhong);
}
