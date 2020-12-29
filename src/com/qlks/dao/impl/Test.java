/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.models.PhanQuyen;
import java.util.List;

/**
 *
 * @author hoangdung
 */
public class Test {

    public static void main(String[] args) {
        PhanQuyenDAO dao = new PhanQuyenDAO();
        int row = dao.add(new PhanQuyen(1, 1));
        if (row > 0) {
            System.out.println("Thêm thành công");
        }

        List<PhanQuyen> lstPQ = dao.getAll();
        for (PhanQuyen phanQuyen : lstPQ) {
            System.out.println("MaNhomQuyen:" + phanQuyen.getMaNhomQuyen());
            System.out.println("getMaQuyen:" + phanQuyen.getMaQuyen());
        }
    }
}
