/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.PhanQuyen;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IPhanQuyenDAO {

    List<PhanQuyen> getAll();

    void add(PhanQuyen phanQuyen);
}
