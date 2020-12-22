/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao;

import com.qlks.models.NhomQuyen;
import java.util.List;

/**
 *
 * @author hello
 */
public interface INhomQuyenDAO {

    List<NhomQuyen> getAll();

    List<NhomQuyen> search(int maNhomQuyen, String tenNhomQuyen);

    int add(NhomQuyen nhomQuyen);

    int update(NhomQuyen nhomQuyen);

    int delete(int maNhomQuyen);
}
