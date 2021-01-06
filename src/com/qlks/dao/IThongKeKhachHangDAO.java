/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.ThongKeKhachHangmd;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IThongKeKhachHangDAO {

    List<ThongKeKhachHangmd> getAll(LocalDate ngayInput1, LocalDate ngayInput2);

}
