/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.models.QuyDinh;
import java.util.List;

/**
 *
 * @author hello
 */
public class Test {

    public static void main(String[] args) {
        QuyDinhDAO dao = new QuyDinhDAO();
        String name = "";
        List<QuyDinh> data = dao.search(name);
        for (QuyDinh data1 : data) {
            System.out.println("Tên: " + data1.getTenQuyDinh());
        }
    }
}
