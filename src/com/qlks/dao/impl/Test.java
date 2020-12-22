/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlks.dao.impl;

import com.qlks.models.KhuyenMai;
import com.qlks.models.Quyen;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author hello
 */
public class Test {

    public static void main(String[] args) {
        KhuyenMaiDAO dao = new KhuyenMaiDAO();
        //dao.add(new KhuyenMai("DBA1234", 40, "Demo khuyến mại", LocalDate.parse("2020-12-22"), LocalDate.parse("2020-12-30"), false, true));

//        List<KhuyenMai> data = dao.getAll();
//        for (KhuyenMai data1 : data) {
//            System.out.println(data1.getMaPhieu());
//        }

        QuyenDAO quyenDAO = new QuyenDAO();
        List<Quyen> lstQuyen = quyenDAO.getAll();
        for (Quyen lstQuyen1 : lstQuyen) {
            System.out.println(lstQuyen1.getQuyen());
        }
    }
}
