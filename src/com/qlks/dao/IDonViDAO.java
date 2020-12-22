/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.DonVi;
import java.util.List;

/**
 *
 * @author hello
 */
public interface IDonViDAO {

    List<DonVi> getAll();

    List<DonVi> search(String maDonVi, String tenDonVi);

    int add(DonVi donVi);

    int update(DonVi donVi);

    int delete(String maDonVi);
}
