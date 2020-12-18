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

    void add(QuyDinh location);

    void update(QuyDinh location);

    void delete(QuyDinh location);
}
