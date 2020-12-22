/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ChiTietPhieuThuePhong;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IChiTietPhieuThuePhongDAO {

    List<ChiTietPhieuThuePhong> getAll();

    int add(ChiTietPhieuThuePhong ct);
}
