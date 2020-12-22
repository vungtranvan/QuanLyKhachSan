/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.CauHinh;
import java.util.List;

/**
 *
 * @author hello
 */
public interface ICauHinhDAO {

    List<CauHinh> getAll();

    List<CauHinh> search(String loaiCauHinh);

    int add(CauHinh cauhinh);

    int update(CauHinh cauhinh);

    int delete(int maCauHinh);

}
