/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.Quyen;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IQuyenDAO {

    List<Quyen> getAll();

    List<Quyen> search(String tenQuyen);

    void add(Quyen quyen);

    void update(Quyen quyen);

    void delete(Quyen quyen);
}
