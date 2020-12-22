/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.QuyDinh;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IQuyDinhDAO {

    List<QuyDinh> getAll();

    int add(QuyDinh location);

    int update(QuyDinh location);

    int delete(int maQuyDinh);

    List<QuyDinh> search(String tenQuyDinh);
}
