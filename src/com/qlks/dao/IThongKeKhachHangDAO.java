/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ThongKeKhachHang;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IThongKeKhachHangDAO {

    List<ThongKeKhachHang> getAll(LocalDate ngayInput1, LocalDate ngayInput2);

}
